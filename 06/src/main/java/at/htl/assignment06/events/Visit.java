package at.htl.assignment06.events;

import javax.persistence.*;

@Entity
@Table(name = "VISITS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Visit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "PRICE_ADULT", nullable = false, precision = 2)
    private Integer priceAdult;
    @Column(name = "PRICE_UNDERAGED", nullable = false, precision = 2)
    private Integer priceUnderaged;

    public Integer getPriceAdult()
    {
        return priceAdult;
    }

    public void setPriceAdult(Integer priceAdult)
    {
        this.priceAdult = priceAdult;
    }

    public Integer getPriceUnderaged()
    {
        return priceUnderaged;
    }

    public void setPriceUnderaged(Integer priceUnderaged)
    {
        this.priceUnderaged = priceUnderaged;
    }

    public Visit(Integer priceAdult, Integer priceUnderaged)
    {
        this.priceAdult = priceAdult;
        this.priceUnderaged = priceUnderaged;
    }
}
