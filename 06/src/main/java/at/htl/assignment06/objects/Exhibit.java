package at.htl.assignment06.objects;

import at.htl.assignment06.building.ExhibitionRoom;

import javax.persistence.*;

@Entity
@Table(name = "EXHIBITS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Exhibit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "EXHIBIT_NAME", nullable = false)
    private String exhibitName;
    @Column(name = "ORIGIN", nullable = false)
    private String origin;
    @Column(name = "ROOM", nullable = false)
    private ExhibitionRoom room;

    public String getExhibitName()
    {
        return exhibitName;
    }

    public void setExhibitName(String exhibitName)
    {
        this.exhibitName = exhibitName;
    }

    public String getOrigin()
    {
        return origin;
    }

    public void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public ExhibitionRoom getRoom()
    {
        return room;
    }

    public void setRoom(ExhibitionRoom room)
    {
        this.room = room;
    }

    public Exhibit(String exhibitName, String origin, ExhibitionRoom room)
    {
        this.exhibitName = exhibitName;
        this.origin = origin;
        this.room = room;
    }
}
