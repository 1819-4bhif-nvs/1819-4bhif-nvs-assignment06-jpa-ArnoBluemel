package at.htl.assignment06.model.objects;

import at.htl.assignment06.model.building.ExhibitionRoom;

public class Mineral extends Exhibit
{
    private String chemicalName;
    private String chemicalFormula;
    private Double density;

    public String getChemicalName()
    {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName)
    {
        this.chemicalName = chemicalName;
    }

    public String getChemicalFormula()
    {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula)
    {
        this.chemicalFormula = chemicalFormula;
    }

    public Double getDensity()
    {
        return density;
    }

    public void setDensity(Double density)
    {
        this.density = density;
    }

    public Mineral(String exhibitName, String origin, ExhibitionRoom room, String chemicalName, String chemicalFormula, Double density)
    {
        super(exhibitName, origin, room);
        this.chemicalName = chemicalName;
        this.chemicalFormula = chemicalFormula;
        this.density = density;
    }
}
