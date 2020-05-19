package implementation;

import common.*;

/**
 * The Facility class is a generic class holding information on a facility, for example a wind farm.
 * Fields are name, country (location), generation capacity, and year of commissioning.
 *
 * @author Yuriel
 * @date 19.05.2020
 */
public class Facility implements IWindFarm
{
    // Name of the wind farm
    protected String name;
    // Name of the country (location of wind farm)
    protected String country;
    // Wind farm's generation capacity in MW
    protected double capacity;
    
    /**
     * Constructor for objects of class Facility
     * 
     * @param name The name of the facility
     * @param country The country in which the facility is located
     * @param capacity The generation capacity of the facility, calculated as number of turbines * each turbine's generation capability
     * @param year The year the facility was commissioned
     */
    public Facility(String name, String country, double capacity)
    {
        this.name = name;
        this.country = country;
        this.capacity = capacity;
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

    @Override
    public double getCapacity()
    {
        return capacity;
    }
    
    public void setCapacity(double capacity)
    {
        this.capacity = capacity;
    }
    
    /**
     * Print out information on this facility to the terminal.
     */
    @Override
    public void print()
    {
        System.out.printf("| %-20s %-10.0f %-15s |\n",
            name, capacity, country);
    }
}