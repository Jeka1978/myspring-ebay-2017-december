package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}
