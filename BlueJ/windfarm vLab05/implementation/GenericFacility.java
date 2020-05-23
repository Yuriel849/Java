package implementation;

import common.*;

/**
 * The GenericFacility class is a generic class holding information on a facility, for example a wind farm.
 * Fields are name, country (location), and generation capacity.
 *
 * @author Yuriel & Mo
 * @date 23.05.2020
 */
public abstract class GenericFacility implements Facility
{
    // Name of the wind farm
    private String name;
    // Name of the country (location of wind farm)
    private String country;
    // Wind farm's generation capacity in MW
    private double capacity;
    
    /**
     * Constructor for objects of class Facility
     * 
     * @param name The name of the facility
     * @param country The country in which the facility is located
     * @param capacity The generation capacity of the facility, calculated as number of turbines * each turbine's generation capability
     */
    public GenericFacility(String name, String country, double capacity)
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
}