package at.htl.assignment06.model.events;

import at.htl.assignment06.model.people.Guide;
import at.htl.assignment06.model.people.Visitor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TOURS")
public class Tour extends Visit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "TITLE", nullable = false)//default value?
    private String title;
    @Column(name = "START", nullable = false)
    private LocalDateTime start;
    @Column(name = "END", nullable = false)
    private LocalDateTime end;
    @Column(name = "TOUR_GUIDE", nullable = false)
    private Guide tourGuide;
    //?
    private List<Visitor> visitors;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDateTime getStart()
    {
        return start;
    }

    public void setStart(LocalDateTime start)
    {
        this.start = start;
    }

    public LocalDateTime getEnd()
    {
        return end;
    }

    public void setEnd(LocalDateTime end)
    {
        this.end = end;
    }

    public Guide getTourGuide()
    {
        return tourGuide;
    }

    public void setTourGuide(Guide tourGuide)
    {
        this.tourGuide = tourGuide;
    }

    public List<Visitor> getVisitors()
    {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors)
    {
        this.visitors = visitors;
    }

    public Tour(Integer priceAdult, Integer priceUnderaged, String title, LocalDateTime start, LocalDateTime end, Guide tourGuide, List<Visitor> visitors)
    {
        super(priceAdult, priceUnderaged);
        this.title = title;
        this.start = start;
        this.end = end;
        this.tourGuide = tourGuide;
        this.visitors = visitors;
    }
}
