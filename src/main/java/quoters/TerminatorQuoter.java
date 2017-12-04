package quoters;

import lombok.Setter;

import java.util.List;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
