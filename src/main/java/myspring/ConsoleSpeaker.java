package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
@Benchmark
public class ConsoleSpeaker implements Speaker {
    public void speak(String message) {
        System.out.println(message);
    }
}
