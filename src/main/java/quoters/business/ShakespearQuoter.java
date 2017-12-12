package quoters.business;

import myspring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import quoters.Book;
import quoters.Secured;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
@Component
@Book
public class ShakespearQuoter implements Quoter {

    @InjectRandomInt(min = 3, max = 7)
    private int repeat=0;


    @Value("${shake}")
    private String message;

    @Override
    @Secured
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
