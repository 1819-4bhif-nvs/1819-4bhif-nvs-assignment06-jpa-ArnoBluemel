package at.htl.assignment06.model.events;

import at.htl.assignment06.model.people.Visitor;

import javax.persistence.*;

@Entity
@Table(name = "SINGLE_VISITS")
public class SingleVisit extends Visit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "VISITOR")
    private Visitor visitor;

    public Visitor getVisitor()
    {
        return visitor;
    }

    public void setVisitor(Visitor visitor)
    {
        this.visitor = visitor;
    }

    public SingleVisit(Integer priceAdult, Integer priceUnderaged, Visitor visitor)
    {
        super(priceAdult, priceUnderaged);
        this.visitor = visitor;
    }
}
