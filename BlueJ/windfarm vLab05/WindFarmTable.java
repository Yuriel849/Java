import java.util.*;

/**
 * The WindFarmTable class holds multiple WindFarm objects and can print
 * all the information as a single table about the wind farms saved in this object.
 *
 * @author Yuriel
 * @date 19.05.2020
 */
public class WindFarmTable
{
    // Name of the table
    private String name;
    // Array with data on wind farms
    private ArrayList<IWindFarm> array;
    // Boolean to indicate for method initList() whether the list has already been initialized or not
    private boolean initialized = false;

    /**
     * Constructor for objects of class WindFarmTable
     */
    public WindFarmTable(String name)
    {
        this.name = name;
        array = new ArrayList<IWindFarm>();
    }
    
    /**
     * Initialize the list with dummy data
     */
    public void initList()
    {
        if(initialized == false)
        {
            addPowerStation(new WindFarm("Thortonbank", "Belgium", 325.0, 54, 2013));
            addPowerStation(new WindFarm("Sheringham Shoal", "United Kingdom", 315, 88, 2012));
            addPowerStation(new WindFarm("Thanet", "United Kingdom", 300, 100, 2010));
            addPowerStation(new WindFarm("Walney", "United Kingdom", 659, 87, 2012));
            addPowerStation(new WindFarm("London Array", "United Kingdom", 630, 175, 2013));
            addPowerStation(new WindFarm("Gemini Wind Farm", "Netherlands", 600, 150, 2017));
            addPowerStation(new WindFarm("Greater Gabbard", "United Kingdom", 504, 140, 2012));
            addPowerStation(new WindFarm("Anholt", "Denmark", 400, 111, 2013));
            addPowerStation(new WindFarm("BARD Offshore 1", "Germany", 400, 80, 2013));
            addPowerStation(new WindFarm("Rampion Wind Farm", "United Kingdom", 400, 116, 2018));
            
            System.out.println("WindFarmTable object initialized");
            
            initialized = true;
        }
        else
        {
            System.out.println("Already initialized");
        }
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