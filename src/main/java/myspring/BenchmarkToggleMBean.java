package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public interface BenchmarkToggleMBean {

    void setEnabled(boolean enabled);

    void killAll();
}
