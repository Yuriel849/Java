import java.util.*;

public class WindFarmTable
{
    // Name of the table
    private String name;
    // Array with data on wind farms
    private ArrayList<IWindFarm> array;

    /**
     * Constructor for objects of class WindFarmTable
     */
    public WindFarmTable(String name)
    {
        this.name = name;
        array = new ArrayList<IWindFarm>();
    }

    /**
     * Adds the given wind farm to an ArrayList
     */
    public void addPowerStation(IWindFarm powerStation)
    {
        array.add(powerStation);
    }
    
    /**
     * Gets the total power of all the wind farms
     */
    public double getTotalPower()
    {
        double totalPower = 0;
        
        for(IWindFarm farm : array)
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
        IWindFarm.printHeader();
        printLine();
        for(IWindFarm farm : array)
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