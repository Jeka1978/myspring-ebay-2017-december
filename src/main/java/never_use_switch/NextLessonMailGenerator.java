package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */

@Component("3")
public class NextLessonMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return "<html>next lesson will be in Sunday!!!</html>";
    }
}
