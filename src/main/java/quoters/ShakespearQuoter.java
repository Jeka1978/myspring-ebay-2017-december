package quoters;

import lombok.Setter;
import myspring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
