package at.htl.assignment06.rest.endpoints;

import at.htl.assignment06.model.objects.Exhibit;
import at.htl.assignment06.model.objects.Fossil;
import at.htl.assignment06.model.objects.Mineral;

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

@Path("exhibits")
@Stateless
public class ExhibitEndpoint
{
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        TypedQuery<Exhibit> tq = em.createQuery("select e from Exhibit e", Exhibit.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExhibit(@PathParam("id")long id)
    {
        Exhibit e = em.find(Exhibit.class, id);
        return  Response.ok().entity(e).build();
    }

    @GET
    @Path("minerals")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMinerals()
    {
        TypedQuery<Mineral> tq = em.createQuery("select m from Mineral m", Mineral.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("minerals/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMineral(@PathParam("id")int id)
    {
        Mineral m = em.find(Mineral.class, id);
        return  Response.ok().entity(m).build();
    }


    @GET
    @Path("fossils")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFossils()
    {
        TypedQuery<Fossil> tq = em.createQuery("select f from Fossil f", Fossil.class);
        return Response.ok().entity(tq.getResultList()).build();
    }

    @GET
    @Path("fossils/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFossil(@PathParam("id") long id)
    {
        Fossil f = em.find(Fossil.class, id);
        return Response.ok().entity(f).build();
    }
}
