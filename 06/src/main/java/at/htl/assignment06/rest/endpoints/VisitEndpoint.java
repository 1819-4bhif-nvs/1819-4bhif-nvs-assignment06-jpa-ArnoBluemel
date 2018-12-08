package at.htl.assignment06.rest.endpoints;

import at.htl.assignment06.model.events.SingleVisit;
import at.htl.assignment06.model.events.Tour;
import at.htl.assignment06.model.events.Visit;

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

@Path("visits")
@Stateless
public class VisitEndpoint
{
    @PersistenceContext(unitName = "H2PU")
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Visit> tq = em.createQuery("select v from Visit v", Visit.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVisit(@PathParam("id") long id)
    {
        Visit v = em.find(Visit.class, id);
        return Response.ok().entity(v).build();
    }

    @GET
    @Path("single-vists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSingleVisit()
    {
        TypedQuery<SingleVisit> tq = em.createQuery("select sv from SingleVisit sv", SingleVisit.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("single-visits/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleVisit(@PathParam("id") long id)
    {
        SingleVisit sv = em.find(SingleVisit.class, id);
        return Response.ok().entity(sv).build();
    }

    @GET
    @Path("tours")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTours()
    {
        TypedQuery<Tour> tq = em.createQuery("select t from Tour t", Tour.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("tours/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTour(@PathParam("id") long id)
    {
        Tour t = em.find(Tour.class, id);
        return Response.ok().entity(t).build();
    }
}
