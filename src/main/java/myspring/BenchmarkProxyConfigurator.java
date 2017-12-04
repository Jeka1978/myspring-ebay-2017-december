package myspring;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    private BenchmarkToggle toggle = new BenchmarkToggle();




    @Override
    public Object wrapWithProxy(Object t, Class type) {


        boolean methodNeedsBenchmark = Arrays.stream(type.getMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class));

        if (type.isAnnotationPresent(Benchmark.class) || methodNeedsBenchmark) {
            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, new org.springframework.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        return BenchmarkProxyConfigurator.this.invoke(method, args, type, t);
                    }
                });
            }
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return BenchmarkProxyConfigurator.this.invoke(method, args, type, t);
                }
            });
        } else {
            return t;
        }
    }

    private Object invoke(Method method, Object[] args, Class type, Object t) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if ((type.isAnnotationPresent(Benchmark.class) || classMethod.isAnnotationPresent(Benchmark.class))&& toggle.isEnabled()) {
            System.out.println("********** BENCHMARK started for method " + method.getName() + " **********");
            long start = System.nanoTime();
            Object retVal = method.invoke(t, args);
            long end = System.nanoTime();

            System.out.println(end - start);

            System.out.println("********** BENCHMARK end for method " + method.getName() + " **********");

            return retVal;
        } else {
            return method.invoke(t, args);
        }
    }
}
