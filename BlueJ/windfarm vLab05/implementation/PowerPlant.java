package implementation;

import common.*;

/**
 * The PowerPlant class holds information on one wind farm.
 * Specifically, the name, country (location), generation capacity, year when construction started, and (expected) year of connection.
 *
 * @author Mo & Yuriel
 * @date 23.05.2020
 */
public class PowerPlant extends GenericFacility
{
    private int constructionStart;
    private int connectionYear;

    /**
     * Constructor for objects of class PowerPlant
     * 
     * @param name The name of the power plant
     * @param country The country in which the power plant is located
     * @param capacity The generation capacity of power plant
     * @param constructionStart The year when the construction of the power plant started
     * @param connectionYear The (expected) year when the power plant will be connected to the power grid
     */
    public PowerPlant(String name, String country, double capacity, int constructionStart, int connectionYear) 
    {
        super(name, country, capacity);
        this.constructionStart = constructionStart;
        this.connectionYear = connectionYear;
    }
    
    public int getConstructionStart()
    {
        return constructionStart;
    }
    
    public void setConstructionStart(int constructionStart)
    {
        this.constructionStart = constructionStart;
    }
    
    public int getConnectionYear()
    {
        return connectionYear;
    }
    
    public void setConnectionYear(int connectionYear)
    {
        this.connectionYear = connectionYear;
    }
    
    /**
     * Print out information on this power plant to the terminal.
     */
    public void print()
    {
        printGeneric();
        System.out.print(String.format(" %-15s | %-18s | %-18s | %-18s | %-9s |\n",
            "N/A", "N/A", constructionStart, connectionYear == -1 ? "UNKNOWN" : connectionYear, "N/A"));
    }
}