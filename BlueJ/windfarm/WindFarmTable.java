import java.util.*;

/**
 * Write a description of class WindFarmTable here.
 *
 * @author Yuriel
 * @date 25.03.2020
 */
public class WindFarmTable
{
    // Name of the table
    private String name;
    // Array with data on wind farms
    private ArrayList<WindFarm> array;

    /**
     * Constructor for objects of class WindFarmTable
     */
    public WindFarmTable(String name)
    {
        this.name = name;
        array = new ArrayList<WindFarm>();
    }

    /**
     * Adds the given wind farm to an ArrayList
     */
    public void addPowerStation(WindFarm powerStation)
    {
        array.add(powerStation);
    }
    
    /**
     * Gets the total power of all the wind farms
     */
    public double getTotalPower()
    {
        double totalPower = 0;
        
        for(WindFarm farm : array)
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
        System.out.println("_____________________________________________________________________");
        System.out.printf("|                      < %-20s >                     |\n",
            name.toUpperCase());
        printLine();
        WindFarm.printHeader();
        printLine();
        for(WindFarm farm : array)
        {
            farm.print();
        }
        printLine();
    }
    
    private void printLine()
    {
        System.out.println("---------------------------------------------------------------------");
    }

}
