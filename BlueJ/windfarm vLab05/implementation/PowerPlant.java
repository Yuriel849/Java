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
        System.out.printf("| %-20s %-10.0f %-15s %-10d %-6d |\n", 
        		this.name, this.capacity, this.country, this.constructionStart, this.connectionYear);
    }
}