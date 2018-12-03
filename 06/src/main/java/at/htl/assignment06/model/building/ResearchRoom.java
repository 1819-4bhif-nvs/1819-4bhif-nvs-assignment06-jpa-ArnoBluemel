package at.htl.assignment06.model.building;

import at.htl.assignment06.model.people.Scientist;

import javax.persistence.*;
import java.util.List;

public class ResearchRoom extends Room
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;
    //?
    private List<Scientist> scientists;

    public ResearchRoom(String roomName, List<Scientist> scientists)
    {
        super(roomName, Room.DEFAULT_CLEARANCE_RESEARCH_ROOM);
        this.scientists = scientists;
    }
}
