package at.htl.assignment06.people;

import at.htl.assignment06.objects.Exhibit;

import javax.persistence.*;

@Entity
@Table(name = "VISITORS")
public class Visitor extends Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "FAVOURITE_OBJECT")
    private Exhibit favouriteObject;

    public Exhibit getFavouriteObject()
    {
        return favouriteObject;
    }

    public void setFavouriteObject(Exhibit favouriteObject)
    {
        this.favouriteObject = favouriteObject;
    }

    public Visitor(String name, String age, Exhibit favouriteObject)
    {
        super(name, age, Person.DEFAULT_CLEARANCE_VISITOR);
        this.favouriteObject = favouriteObject;
    }
}
