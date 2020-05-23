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
        //String x = "| %-20s | %-20s | %-15s | %-15s | %-18s | %-18s | %-18s | %-9s |\n"
    	
    	String row = String.format("| %-20s | %-20s | %-15s | %-15s | %-18s | %-18s | %-18s | %-9s |\n",
        		getName(), getCountry(), getCapacity(), "N/A", "N/A", constructionStart, connectionYear, "N/A");
        
        // print list
        System.out.print(row);
    }
}