package quoters.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */

@Component
public class TalkingRobotImpl implements TalkingRobot, ApplicationListener<ContextRefreshedEvent> {
    private final List<Quoter> quoters;
    @Autowired
    private Helper helper;


    @Autowired
    public TalkingRobotImpl(List<Quoter> quoters) {
        this.quoters = quoters;
    }


    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
        helper.sayHelp();
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        talk();
    }
}











