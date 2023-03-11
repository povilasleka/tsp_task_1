package lt.vu.mif.tsptask1.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter @Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_WAREHOUSE")
    private Collection<Warehouse> workPlaces = new ArrayList<>();
}
