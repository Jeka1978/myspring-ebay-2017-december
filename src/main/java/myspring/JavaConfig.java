package myspring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class JavaConfig implements Config {
    private Map<Class,Class> ifc2Impl = new HashMap<>();


    public JavaConfig() {
        ifc2Impl.put(Speaker.class, ConsoleSpeaker.class);
        ifc2Impl.put(Cleaner.class, CleanerImpl.class);

    }

    public <T> Class<T> getImplClass(Class<T> type) {
        return ifc2Impl.get(type);
    }
}
