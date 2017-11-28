package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class IRobot {
    private Speaker speaker = new ConsoleSpeaker();
    private Cleaner cleaner = new CleanerImpl();

    public void cleanRoom() {
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}
