package profile_examples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "PROD");
        new AnnotationConfigApplicationContext(Config.class);
    }
}
