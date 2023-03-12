package lt.vu.mif.tsptask1.services;

import lt.vu.mif.tsptask1.entities.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@ApplicationScoped
@Transactional
public class EmployeeService {
    @PersistenceContext
    private EntityManager entityManager;

    public void createEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    public void removeEmployee(Employee employee) {
        entityManager.remove(employee);
    }

    public Employee findEmployee(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public Collection<Employee> findAllEmployees() {
        return entityManager
                .createNamedQuery("Employee.findAll", Employee.class)
                .getResultList();
    }
}
