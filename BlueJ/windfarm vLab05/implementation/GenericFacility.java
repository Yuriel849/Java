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

    @Override
    public double getCapacity()
    {
        return capacity;
    }
    
    /**
     * Method to print the name, country, and capacity of a facility.
     * To be called by the subclass before printing the information specific to .
     */
    protected void printGeneric()
    {
        String printName = name;
        if(printName.length() > 20) {
            printName = printName.substring(0, 17) + "...";
        }
        
        System.out.print(String.format("| %-20s | %-20s | %-15s |", printName, country, capacity));
    }
}