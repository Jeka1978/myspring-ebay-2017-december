package quoters;

import lombok.Setter;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
@DeprecatedClass(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }


    public void terminate() {
        System.out.println("you are terminated...");
    }
}
