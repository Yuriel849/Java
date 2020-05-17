package implementation;

import common.*;


/**
 * Write a description of class Facility here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Facility implements IWindFarm
{
    // Name of the wind farm
    protected String name;
    // Name of the country (location of wind farm)
    protected String country;
    // Wind farm's generation capacity in MW
    protected double capacity;
    // Year of commissioning
    protected int year;
    
    /**
     * Constructor for objects of class WindFarm
     * 
     * @param name The name of the wind farm
     * @param country The country in which the wind farm is located
     * @param capacity The generation capacity of the wind farm, calculated as number of turbines * each turbine's generation capability
     * @param year The year the wind farm was commissioned
     */
    public Facility(String name, String country, double capacity, int year)
    {
        this.name = name;
        this.country = country;
        this.capacity = capacity;
        this.year = year;
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public void setCountry(String country)
    {
        this.country = country;
    }
    
    public double getCapacity()
    {
        return capacity;
    }
    
    public void setCapacity(double capacity)
    {
        this.capacity = capacity;
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
        System.out.printf("| %-20s %-10.0f %-15s %-6d |\n",
            name, capacity, country, year);
    }
}