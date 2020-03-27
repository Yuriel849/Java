import java.util.*;

/**
 * Write a description of class PowerPlantTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowerPlantTable
{
    private String name;
    private ArrayList<PowerPlant> list;
    
    /**
     * Constructor for objects of class PowerPlantTable
     */
    public PowerPlantTable(String name)
    {
        this.name = name;
        list = new ArrayList<>();
    }

    /**
     * 
     */
    public void addPowerStation(PowerPlant powerStation)
    {
        list.add(powerStation);
    }
    
    public double getTotalPower()
    {
        double totalPower = 0;
        
        for(PowerPlant plant : list)
        {
            totalPower += plant.getCapacity();
        }
        
        return totalPower;
    }
    
    public void printTable()
    {
        System.out.printf("%-14s %-12s %-20s %-22s %-14s\n", "Power Station", "Capacity", "Construction Start", "Connection Year", "Country");
        
        for(PowerPlant plant : list)
        {
            plant.print();
        }
    }
}
