package at.htl.assignment06.rest.endpoints;

import at.htl.assignment06.model.people.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("persons")
@Stateless
public class PersonEndpoint
{
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Person> tq = em.createQuery("select p from Person p", Person.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") long id)
    {
        Person p = em.find(Person.class, id);
        return Response.ok().entity(p).build();
    }

    @GET
    @Path("staff")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStaff()
    {
        TypedQuery<Staff> tq = em.createQuery("select s from Staff s", Staff.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("staff/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaff(@PathParam("id") long id)
    {
        Staff s = em.find(Staff.class, id);
        return Response.ok().entity(s).build();
    }

    @GET
    @Path("staff/guides")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGuides()
    {
        TypedQuery<Guide> tq = em.createQuery("select g from Guide g", Guide.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("staff/guides/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGuide(@PathParam("id") long id)
    {
        Guide g = em.find(Guide.class, id);
        return Response.ok().entity(g).build();
    }



    @GET
    @Path("staff/scientists")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllScientists()
    {
        TypedQuery<Scientist> tq = em.createQuery("select s from Scientist s", Scientist.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("staff/scientists/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getScientist(@PathParam("id") long id)
    {
        Scientist s = em.find(Scientist.class, id);
        return Response.ok().entity(s).build();
    }

    @GET
    @Path("visitors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllVisitors()
    {
        TypedQuery<Visitor> tq = em.createQuery("select v from Visitor v", Visitor.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("visitors/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") long id)
    {
        Visitor v = em.find(Visitor.class, id);
        return Response.ok().entity(v).build();
    }
}
