package quoters;

import lombok.Setter;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class ShakespearQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
