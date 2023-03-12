package lt.vu.mif.tsptask1.beans;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mif.tsptask1.entities.Employee;
import lt.vu.mif.tsptask1.services.EmployeeService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

@RequestScoped
@Named
public class EmployeeBean {
    @Inject
    private EmployeeService employeeService;

    @Getter @Setter
    private Employee employee;

    @PostConstruct
    public void init() {
        Map<String, String> requestParams =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Long employeeId = Long.parseLong(requestParams.get("employeeId"));
        this.employee = employeeService.findEmployee(employeeId);
    }
}
