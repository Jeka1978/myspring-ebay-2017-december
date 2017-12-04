package quoters;

import java.util.List;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class TerminatorQuoter implements Quoter {
    private List<String> messages;
    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
