package profile_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class EbayService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EbayService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public double getTotalSalary() {
        List<Employee> employees = employeeDao.getEmployees();
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    @Scheduled(cron = "1/1 * * * * *")
    public void printTotal(){
        System.out.println(getTotalSalary());
    }
}

