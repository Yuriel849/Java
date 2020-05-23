package implementation;


/**
 * Write a description of class SolarPark here.
 *
 * @author Yuriel
 * @version 20.05.2020
 */
public class SolarPark extends GenericFacility
{
    private int landSize;
    private int connectionYear;

    /**
     * Constructor for objects of class SolarPark
     */
    public SolarPark(String name, String country, double capacity, int landSize, int connectionYear)
    {
        super(name, country, capacity);
        this.landSize = landSize;
        this.connectionYear = connectionYear;
    }
}
