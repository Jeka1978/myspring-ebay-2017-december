package quoters;

import lombok.Setter;
import myspring.InjectRandomInt;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class ShakespearQuoter implements Quoter {

    @InjectRandomInt(min = 3, max = 7)
    private int repeat=0;

    @Setter
    private String message;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
