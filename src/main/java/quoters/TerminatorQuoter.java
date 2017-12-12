package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */

@Component
@Film
public class TerminatorQuoter implements Quoter {


    @Setter
    private List<String> messages;

    @Value("${terminator}")
    public void init(String[] messages,@Value("${JAVA_HOME}") String javaHome) {
        this.messages = Arrays.asList(messages);
        System.out.println("javaHome = " + javaHome);
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }


    public void terminate() {
        System.out.println("you are terminated...");
    }
}












