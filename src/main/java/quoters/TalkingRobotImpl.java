package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */

@Component
public class TalkingRobotImpl implements TalkingRobot {
    private final List<Quoter> quoters;

    @Autowired
    public TalkingRobotImpl(List<Quoter> quoters) {
        this.quoters = quoters;
    }


    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}











