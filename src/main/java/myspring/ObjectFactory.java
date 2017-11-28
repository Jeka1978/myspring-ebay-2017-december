package myspring;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
    }


    @SneakyThrows
    public Object createObject(Class type) {
//        type.newInstance()

        return null;
    }


}
