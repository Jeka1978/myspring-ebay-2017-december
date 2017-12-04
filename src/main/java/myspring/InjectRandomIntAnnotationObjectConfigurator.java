package myspring;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator, BeanPostProcessor {
    private Random random = new Random();

    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(type);
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                int min = annotation.min();
                int max = annotation.max();

                int value = min + random.nextInt(max - min);
                field.setAccessible(true);
                field.set(t, value);

            }
        }

    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        configure(bean);
        return bean;
    }
}
