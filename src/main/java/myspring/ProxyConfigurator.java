package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public interface ProxyConfigurator {
    Object wrapWithProxy(Object t,Class type);
}
