package at.htl.assignment06.model.people;

import javax.persistence.*;

@Entity
@Table(name = "STAFF")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Staff extends Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "SALARY", nullable = false, precision = 2)
    private Double salary;

    public Double getSalary()
    {
        return salary;
    }

    public void setSalary(Double salary)
    {
        this.salary = salary;
    }

    public Staff(String name, Long age, Integer clearance, Double salary)
    {
        super(name, age, clearance);
        this.salary = salary;
    }
}
