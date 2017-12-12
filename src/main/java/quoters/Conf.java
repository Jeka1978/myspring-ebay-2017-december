package quoters;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan(basePackages = {"quoters","myspring"})
@PropertySource("classpath:quotes.properties")
@EnableAspectJAutoProxy
public class Conf {










    /*@Bean   need to be addeded with spring <4.3 and not spring boot
    public static PropertySourcesPlaceholderConfigurer configurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }*/
}
