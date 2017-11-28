package myspring;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("myspring");
    private List<ObjectConfigurator> objectConfigurators = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> set = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (java.lang.Class<? extends ObjectConfigurator> aClass : set) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                objectConfigurators.add(aClass.newInstance());
            }
        }

    }


    @SneakyThrows
    public <T> T createObject(Class<T> type) {

        // todo 1 make @Benchmark work also if it presnet above specific method
        // todo 2 refactor - move this code to some other place like ProcyConfiguer  or ObjectConfigurer
        // todo 3 imposable bonus: support turn on/off bechmark without restart (JMX)
        type = resolveImpl(type);
        T t = type.newInstance();
        configure(t);
        invokeInitMethods(type, t);
        if (type.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("********** BENCHMARK started for method "+method.getName()+" **********");
                    long start = System.nanoTime();
                    Object retVal = method.invoke(t, args);
                    long end = System.nanoTime();

                    System.out.println(end-start);

                    System.out.println("********** BENCHMARK end for method "+method.getName()+" **********");

                    return retVal;
                }
            });
        }


        return t;
    }

    private <T> void invokeInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) {
        objectConfigurators.forEach(objectConfigurator -> objectConfigurator.configure(t));
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException("0 or more than one impl found for " + type + " please update your config");
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;
        }
        return type;
    }


}














