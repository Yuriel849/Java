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
     * Stores in a map the country (key) with the total power of all wind farms in that country (value).
     * Therefore, iterates through all wind farms and adds for each country all the wind farm capacities to the double value. 
     * 
     * @return HashMap containing as entries the pair of one country and the total power of all wind farms in that country.
     */
    public HashMap<String, Double> powerByCountry()
    {
        HashMap<String, Double> result = new HashMap<>();
        String country;
        double capacity;
        
        for(WindFarm farm : array)
        {
            country = farm.getCountry();
            capacity = result.getOrDefault(country, 0.0);
            result.put(country, capacity + farm.getCapacity());
        }
        
        return result;
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
     * Iterates through the list, printing the country name before printing the full information on each wind farm.
     */
    public void listByCountry()
    {
        printTableHeader();
        WindFarm.printHeader();
        
        for(WindFarm farm : array)
        {
            printLine();
            System.out.printf("|                     >> %-20s <<                    |\n", farm.getCountry().toLowerCase());
            printLine();
            farm.print();
        }
        printLine();
    }
    
    /**
     * Add all the wind farms to the map.
     * The key is the country and the value is the set of all wind farms in that country.
     * 
     * @return HashMap containing a country as the key and a set of all the wind farms in that country as the value.
     */
    public HashMap<String, HashSet<WindFarm>> mapByCountry()
    {
        HashMap<String, HashSet<WindFarm>> countryMap = new HashMap<>();
        String country;
        HashSet<WindFarm> farmSet;
        
        for(WindFarm farm : array)
        {
            country = farm.getCountry();
            farmSet = countryMap.getOrDefault(country, new HashSet<WindFarm>());
            farmSet.add(farm);
            
            countryMap.put(country, farmSet);
        }
        
        return countryMap;
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
     * Print the table of countries together with the total power of wind farms of your list in each country.
     * 
     * @param HashMap containing a country as the key and the total capacity of that country's wind farms as the value.
     */
    public void printCapacity(HashMap<String, Double> powerMap)
    {
        printTableHeader();
        System.out.printf("|    %-20s :   %-38s|\n", "COUNTRY", "CAPACITY");
        printLine();
        
        for(String country : powerMap.keySet())
        {
            System.out.printf("|    %-20s :   %-38.1f|\n", country.toLowerCase(), powerMap.get(country));
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
