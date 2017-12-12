package quoters;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Evgeny Borisov
 */
@Retention(RUNTIME)
@Qualifier
public @interface Book {
}
