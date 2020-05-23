package implementation;

import common.*;

/**
 * The WindFarm class holds information on one wind farm.
 * Specifically, the name, country (location), generation capacity, number of turbines, and year of commissioning.
 *
 * @author Yuriel & Mo
 * @date 23.05.2020
 */
public class WindFarm extends GenericFacility
{
    // Number of turbines
    private int numberTurbines;
    // Year of commissioning
    private int year;
    
    /**
     * Constructor for objects of class WindFarm
     * 
     * @param name The name of the wind farm
     * @param country The country in which the wind farm is located
     * @param capacity The generation capacity of the wind farm, calculated as number of turbines * each turbine's generation capability
     * @param numberTurbines The number of turbines in the wind farm
     * @param year The year the wind farm was commissioned
     */
    public WindFarm(String name, String country, double capacity, int numberTurbines, int year)
    {
        super(name, country, capacity);
        this.numberTurbines = numberTurbines;
        this.year = year;
    }
    
    public int getNumberTurbines()
    {
        return numberTurbines;
    }
    
    public void setNumberTurbines(int numberTurbines)
    {
        this.numberTurbines = numberTurbines;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * Print out information on this wind farm to the terminal.
     */
    public void print()
    {
    	String row = String.format("| %-20s | %-20s | %-15s | %-15s | %-18s | %-18s | %-18s | %-9s |\n",
            getName(), getCountry(), getCapacity(), numberTurbines, year, "N/A", "N/A", "N/A");
    	
    	System.out.print(row);
    }
}