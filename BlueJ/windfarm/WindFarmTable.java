import java.util.*;

/**
 * The WindFarmTable class holds multiple WindFarm objects and can print
 * all the information as a single table about the wind farms saved in this object.
 *
 * @author Yuriel
 * @date 25.03.2020
 */
public class WindFarmTable
{
    // Name of the wind farm
    private String name;
    // ArrayList with data on wind farms
    private ArrayList<WindFarm> array;

    /**
     * Constructor for objects of class WindFarmTable
     * 
     * @param name The name of the wind farm
     */
    public WindFarmTable(String name)
    {
        this.name = name;
        array = new ArrayList<WindFarm>();
    }

    /**
     * Adds the given wind farm to an ArrayList
     * 
     * @param powerStation One WindFarm object
     */
    public void addPowerStation(WindFarm powerStation)
    {
        array.add(powerStation);
    }
    
    /**
     * Gets the total power of all the wind farms by adding up the capacities of each individual wind farm
     * 
     * @return Total power of all wind farms in the ArrayList
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
     * and delegates the printing of the rows to the WindFarm objects stored in the ArrayList<WindFarm>.
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
    
    /**
     * Print hyphens to form a long line.
     */
    private void printLine()
    {
        System.out.println("---------------------------------------------------------------------");
    }

}
