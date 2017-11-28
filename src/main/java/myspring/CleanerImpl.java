package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 3, max = 7)
    private int repeat;

    public CleanerImpl() {
        System.out.println("repeat = " + repeat);
    }

    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVVvvvvvvvvvvvvvvvvvvvv");
        }
    }
}
