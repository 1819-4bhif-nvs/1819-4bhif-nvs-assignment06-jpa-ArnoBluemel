package at.htl.assignment06.model.objects;

import at.htl.assignment06.model.building.ExhibitionRoom;

import javax.persistence.*;

@Entity
@Table(name = "FOSSILS")
public class Fossil extends Exhibit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "AGE")//null == unknown
    private Long age;
    @Column(name = "SPECIES", nullable = false)
    private String species;
    @Column(name = "GENUS", nullable = false)
    private String genus;
    @Column(name = "FAMILY", nullable = false)
    private String family;
    @Column(name = "ORDER", nullable = false)
    private String order;
    @Column(name = "CLASS", nullable = false)
    private String tax_class; //tax = taxonomy
    @Column(name = "PHYLUM", nullable = false)
    private String phylum;
    @Column(name = "KINGDOM", nullable = false)
    private String kingdom;
    @Column(name = "DOMAIN", nullable = false)
    private String domain;

    public Long getAge()
    {
        return age;
    }

    public void setAge(Long age)
    {
        this.age = age;
    }

    public String getSpecies()
    {
        return species;
    }

    public void setSpecies(String species)
    {
        this.species = species;
    }

    public String getGenus()
    {
        return genus;
    }

    public void setGenus(String genus)
    {
        this.genus = genus;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family)
    {
        this.family = family;
    }

    public String getOrder()
    {
        return order;
    }

    public void setOrder(String order)
    {
        this.order = order;
    }

    public String getTax_class()
    {
        return tax_class;
    }

    public void setTax_class(String tax_class)
    {
        this.tax_class = tax_class;
    }

    public String getPhylum()
    {
        return phylum;
    }

    public void setPhylum(String phylum)
    {
        this.phylum = phylum;
    }

    public String getKingdom()
    {
        return kingdom;
    }

    public void setKingdom(String kingdom)
    {
        this.kingdom = kingdom;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public Fossil(String exhibitName, String origin, ExhibitionRoom room, Long age, String species, String genus, String family, String order, String tax_class, String phylum, String kingdom, String domain)
    {
        super(exhibitName, origin, room);
        this.age = age;
        this.species = species;
        this.genus = genus;
        this.family = family;
        this.order = order;
        this.tax_class = tax_class;
        this.phylum = phylum;
        this.kingdom = kingdom;
        this.domain = domain;
    }
}
