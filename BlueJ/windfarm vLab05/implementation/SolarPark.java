package implementation;

/**
 * The SolarPark class holds information on one solar park.
 * Specifically, the name, country (location), generation capacity, land size, and (expected) year of connection.
 *
 * @author Yuriel
 * @version 06.06.2020
 */
public class SolarPark extends GenericFacility
{
    private int landSize;
    private int connectionYear;

    /**
     * Constructor for objects of class SolarPark
     * 
     * @param name The name of the solar park
     * @param country The country in which the solar park is located
     * @param capacity The generation capacity of solar park
     * @param landSize The size of the land on which the solar park is built
     * @param connectionYear The (expected) year when the solar park will be connected to the power grid
     */
    public SolarPark(String name, String country, double capacity, int connectionYear, int landSize)
    {
        super(name, country, capacity);
        this.landSize = landSize;
        this.connectionYear = connectionYear;
    }

    /**
     * Print out information on this solar park to the terminal.
     */
    public void print() {
        printGeneric();
        System.out.print(String.format(" %-15s | %-18s | %-18s | %-18s | %-9s |\n",
            "N/A", "N/A", "N/A", connectionYear, landSize == -1 ? "UNKNOWN" : landSize));
    }
}
