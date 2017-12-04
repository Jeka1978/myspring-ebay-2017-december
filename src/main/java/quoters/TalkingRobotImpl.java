package quoters;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class TalkingRobotImpl implements TalkingRobot {
    private final List<Quoter> quoters;


    public TalkingRobotImpl(List<Quoter> quoters) {
        this.quoters = quoters;
    }




    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}











