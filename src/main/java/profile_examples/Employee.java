package profile_examples;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * @author Evgeny Borisov
 */
@Value
@RequiredArgsConstructor
public class Employee {
    private final int salary;
}
