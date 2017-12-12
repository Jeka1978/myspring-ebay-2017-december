package profile_examples;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Prod
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    @SneakyThrows
    public List<Employee> getEmployees() {
        Thread.sleep(500);
        return Arrays.asList(new Employee(10),new Employee(20));
    }
}
