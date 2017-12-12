package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component("2")
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return "<html> don't call us we call you</html";
    }
}
