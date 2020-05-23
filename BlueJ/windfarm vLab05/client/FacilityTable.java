package client;

import java.util.*;
import common.*;
//import implementation.*;

/**
 * The WindFarmTable class holds multiple WindFarm objects and can print
 * all the information as a single table about the wind farms saved in this object.
 *
 * @author Yuriel and Mo
 * @date 19.05.2020
 */
public class FacilityTable
{
    // Name of the table
    private String name;
    // Array with data on wind farms
    private ArrayList<Facility> array;
    

    /**
     * Constructor for objects of class WindFarmTable
     */
    public FacilityTable(String name)
    {
        this.name = name;
        array = new ArrayList<Facility>();
    }
    
    /**
     * Adds the given wind farm to an ArrayList
     */
    public void addPowerStation(Facility powerStation)
    {
        array.add(powerStation);
    }
    
    /**
     * Gets the total power of all the wind farms
     */
    public double getTotalPower()
    {
        double totalPower = 0;
        
        for(Facility farm : array)
        {
            totalPower += farm.getCapacity();
        }
        
        return totalPower;
    }
    
    /**
     * Print the wind farm table information to the terminal window
     * by delegating the printing of the rows to the WindFarm objects stored in the ArrayList<WindFarm>.
     */
    
    public void printTable()
    {
        //System.out.println("_____________________________________________________________________");
        //System.out.printf("|                        < %-15s >                       |\n", name.toUpperCase());
        //printLine();
        Facility.printHeader(name.toUpperCase());
        Facility.dashedLine();
        for(Facility farm : array)
        {
            farm.print();
        }
        Facility.dashedLine();
    }

}