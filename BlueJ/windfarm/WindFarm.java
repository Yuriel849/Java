/**
 * The WindFarm class holds information on one wind farm.
 * Specifically, the name, country (location), generation capacity, number of turbines, and year of commissioning.
 *
 * @author Yuriel
 * @date 25.03.2020
 */
public class WindFarm
{
    // Name of the wind farm
    private String name;
    // Name of the country (location of wind farm)
    private String country;
    // Wind farm's generation capacity in MW
    private double capacity;
    // Number of turbines
    private int numberTurbines;
    // Year of commissioning
    private int year;
    
    /**
     * Constructor for objects of class WindFarm
     * 
     * @param name The name of the wind farm
     * @param country The country in which the wind farm is located
     * @param capacity The generation capacity of the wind farm, calculated as number of turbines * each turbine's generation capability
     * @param numberTurbines The number of turbines in the wind farm
     * @param year The year the wind farm was commissioned
     */
    public WindFarm(String name, String country, double capacity, int numberTurbines, int year)
    {
        this.name = name;
        this.country = country;
        this.capacity = capacity;
        this.numberTurbines = numberTurbines;
        this.year = year;
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
    
    public double getCapacity()
    {
        return capacity;
    }
    
    public void setCapacity(double capacity)
    {
        this.capacity = capacity;
    }
    
    public int getNumberTurbines()
    {
        return numberTurbines;
    }
    
    public void setNumberTurbines(int numberTurbines)
    {
        this.numberTurbines = numberTurbines;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public void setYear(int year)
    {
        this.year = year;
    }
    
    /**
     * Print out information on this wind farm to the terminal.
     */
    public void print()
    {
        System.out.printf("| %-20s %-10.0f %-15s %-10d %-6d |\n",
            name, capacity, country, numberTurbines, year);
    }
    
    /**
     * Print a header for a table displaying information in wind farms to the terminal.
     */
    public static void printHeader()
    {
        System.out.printf("| %-20s %-10s %-15s %-10s %-6s |\n",
            "Name", "Capacity", "Country", "Turbines", "Year");
    }
}