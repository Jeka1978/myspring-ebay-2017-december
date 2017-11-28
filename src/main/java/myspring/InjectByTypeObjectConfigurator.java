package myspring;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class InjectByTypeObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> type = t.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(type);
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Class<?> typeToInject = field.getType();
                Object objectToInject = ObjectFactory.getInstance().createObject(typeToInject);
                field.setAccessible(true);
                field.set(t, objectToInject);
            }
        }
    }
}
