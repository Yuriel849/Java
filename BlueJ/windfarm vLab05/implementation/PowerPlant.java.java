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
<<<<<<< HEAD
        System.out.printf("| %-20s %-10.0f %-15s %-10d %-6d |\n", 
        		this.name, this.capacity, this.country, this.constructionStart, this.connectionYear);
=======
        //String heading = String.format("%-20s | %-15s | %-12s | %-15s | %-15s", "Name", "Country", "Capacity", "Contstruction Date", "Connection Date");
        String row = String.format("| %-20s %-10s %-15s %-10s %-6s |\n",
        getName(), getCapacity(), getCountry(), constructionStart, connectionYear);
        
        // print list
        System.out.println(row);
>>>>>>> 7fc2eb31d2916cfab50820cf0bc8814e58ca0693
    }
}