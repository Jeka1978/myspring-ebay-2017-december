package profile_examples;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Dev
@Repository
public class LocalEmployeeDao implements EmployeeDao {
    @Override
    public List<Employee> getEmployees() {
        return Arrays.asList(new Employee(20), new Employee(30));
    }
}
