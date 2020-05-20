package implementation;

import common.*;

/**
 * Write a description of class PowerPlant here.
 *
 * Mo
 * 01/04/2020
 */
public class PowerPlant extends GenericFacility
{
    private int constructionStart;
    private int connectionYear;

    /**
     * Constructor for objects of class PowerPlant
     */
    public PowerPlant(String name, String country, double capacity, int constructionStart, int connectionYear) 
    {
        super(name, country, capacity);
        this.constructionStart = constructionStart;
        this.connectionYear = connectionYear;
    }
    
    public void print()
    {
        //String heading = String.format("%-20s | %-15s | %-12s | %-15s | %-15s", "Name", "Country", "Capacity", "Contstruction Date", "Connection Date");
        String row = String.format("| %-20s %-10s %-15s %-10s %-6s |\n",
        getName(), getCapacity(), getCountry(), constructionStart, connectionYear);
        
        // print list
        System.out.println(row);
    }
}