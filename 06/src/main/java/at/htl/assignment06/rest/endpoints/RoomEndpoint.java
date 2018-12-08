package at.htl.assignment06.rest.endpoints;

import at.htl.assignment06.model.building.ExhibitionRoom;
import at.htl.assignment06.model.building.ResearchRoom;
import at.htl.assignment06.model.building.Room;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("rooms")
@Stateless
public class RoomEndpoint
{
    @PersistenceContext(unitName = "H2PU")
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Room> tq = em.createQuery("select r from Room r", Room.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRoom(@PathParam("id") long id)
    {
        Room r = em.find(Room.class, id);
        return Response.ok().entity(r).build();
    }

    @GET
    @Path("exhibition-rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllExhibitionRooms()
    {
        TypedQuery<ExhibitionRoom> tq = em.createQuery("select er from ExhibitionRoom er", ExhibitionRoom.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("exhibition-room/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExhibitionRoom(@PathParam("id") long id)
    {
        ExhibitionRoom er = em.find(ExhibitionRoom.class, id);
        return Response.ok().entity(er).build();
    }

    @GET
    @Path("research-rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllResearchRooms()
    {
        TypedQuery<ResearchRoom> tq = em.createQuery("select er from ResearchRoom er", ResearchRoom.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("research-room/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResearchRoom(@PathParam("id") long id)
    {
        ResearchRoom er = em.find(ResearchRoom.class, id);
        return Response.ok().entity(er).build();
    }
}
