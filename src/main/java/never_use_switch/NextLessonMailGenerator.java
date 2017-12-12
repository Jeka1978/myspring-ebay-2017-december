package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */

@Component
public class NextLessonMailGenerator implements MailGenerator {
    @Override
    public String generate(MailInfo mailInfo) {
        return "<html>next lesson will be in Sunday!!!</html>";
    }

    @Override
    public int myCode() {
        return 3;
    }
}
