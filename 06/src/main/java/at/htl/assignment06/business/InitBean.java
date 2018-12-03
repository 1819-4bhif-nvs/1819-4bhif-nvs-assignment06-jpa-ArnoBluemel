package at.htl.assignment06.business;

import at.htl.assignment06.model.building.ExhibitionRoom;
import at.htl.assignment06.model.objects.Mineral;
import at.htl.assignment06.model.people.Scientist;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Startup
@Singleton
public class InitBean
{
    @PersistenceContext
    private EntityManager em;

    public InitBean()
    {

    }

    @PostConstruct
    private void init()
    {
        Scientist scientist1 = new Scientist("Alan Grant", 56L, 3056.40D, "Paleontology", "Prof.", "");
        ExhibitionRoom exRoom1 = new ExhibitionRoom("Jewels", scientist1);
        Mineral mineral1 = new Mineral("Diamond", "Ruanda", exRoom1, "Carbon", "C", 3520D);

        em.persist(scientist1);
        em.persist(exRoom1);
        em.persist(mineral1);
    }
}
