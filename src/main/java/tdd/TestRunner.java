package tdd;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class TestRunner {




    @SneakyThrows
    public void runAllTestsMethods(Object o) {
        Class<?> type = o.getClass();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("test")|| method.isAnnotationPresent(Test.class)) {
                method.invoke(o);
            }
        }
    }
}
