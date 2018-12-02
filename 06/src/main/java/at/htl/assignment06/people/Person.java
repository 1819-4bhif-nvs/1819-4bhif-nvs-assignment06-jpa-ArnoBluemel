package at.htl.assignment06.people;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person
{
    protected static Integer DEFAULT_CLEARANCE_VISITOR = 0;
    protected static Integer DEFAULT_CLEARANCE_PERSONNEL = 1;
    protected static Integer DEFAULT_CLEARANCE_SCIENTIST = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "AGE", nullable = false)
    private String age;
    @Column(name = "CLEARANCE", nullable = false)
    private Integer clearance;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public Integer getClearance()
    {
        return clearance;
    }

    public void setClearance(Integer clearance)
    {
        this.clearance = clearance;
    }

    public Person(String name, String age, Integer clearance)
    {
        this.name = name;
        this.clearance = clearance;
        this.age = age;
    }
}
