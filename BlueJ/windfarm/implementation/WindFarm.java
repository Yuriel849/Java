package implementation;

/**
 * The WindFarm class holds information on one wind farm.
 * Specifically, the name, country (location), generation capacity, number of turbines, and year of commissioning.
 *
 * @author Yuriel
 * @date 17.05.2020
 */
public class WindFarm extends Facility
{
    // Number of turbines
    private int numberTurbines;
    
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
        super(name, country, capacity, year);
        this.numberTurbines = numberTurbines;
    }

    public int getNumberTurbines()
    {
        return numberTurbines;
    }
    
    public void setNumberTurbines(int numberTurbines)
    {
        this.numberTurbines = numberTurbines;
    }
    
    /**
     * Print out information on this wind farm to the terminal.
     */
    public void print()
    {
        System.out.printf("| %-20s %-10.0f %-15s %-10d %-6d |\n",
            name, capacity, country, numberTurbines, year);
    }
}