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
    // Boolean to indicate for method initList() whether the list has already been initialized or not
    private boolean initialized = false;
    
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
     * Add all WindFarm instances located in the given country to a set that is returned.
     * 
     * @param String The string to match with the country field of wind farm objects.
     * @return HashSet containing wind farm objects where the country field matches the parameter.
     */
    public HashSet<WindFarm> findWindFarms(String country)
    {
        HashSet<WindFarm> result = new HashSet<>();
        
        for(WindFarm farm : array)
        {
            if(farm.getCountry().equals(country))
            {
                result.add(farm);
            }
        }
        
        return result;
    }

    
    /**
     * Prints all WindFarm instances located in the given country to the terminal window.
     * 
     * @param String The string to match with the country field of wind farm objects.
     */
    public void listWindFarms(String country)
    {
        HashSet<WindFarm> result = findWindFarms(country);
        
        printTableHeader();
        WindFarm.printHeader();
        printLine();
        for(WindFarm farm : result)
        {
            farm.print();
        }
        printLine();
    }
    
    /**
     * Print the wind farm table information to the terminal window
     * and delegates the printing of the rows to the WindFarm objects stored in the ArrayList<WindFarm>.
     */
    public void printTable()
    {
        printTableHeader();
        WindFarm.printHeader();
        printLine();
        for(WindFarm farm : array)
        {
            farm.print();
        }
        printLine();
    }
    
    /**
     * Print the table header
     */
    private void printTableHeader()
    {
        System.out.println("_____________________________________________________________________");
        System.out.printf("|                      < %-20s >                     |\n", name.toUpperCase());
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
