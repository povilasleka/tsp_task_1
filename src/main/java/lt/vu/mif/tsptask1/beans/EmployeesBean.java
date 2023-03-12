package lt.vu.mif.tsptask1.beans;

import lombok.Getter;
import lt.vu.mif.tsptask1.entities.Employee;
import lt.vu.mif.tsptask1.services.EmployeeService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class EmployeesBean {
    @Inject
    private EmployeeService employeeService;

    @Getter
    private List<Employee> allEmployees;

    @PostConstruct
    private void init() {
        allEmployees = (List<Employee>) employeeService.findAllEmployees();
    }
}
