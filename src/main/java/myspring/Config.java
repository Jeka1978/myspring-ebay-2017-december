package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public interface Config {
    <T> Class<T> getImplClass(Class<T> type);
}
