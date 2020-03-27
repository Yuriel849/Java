
/**
 * Write a description of class PowerPlant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PowerPlant
{
    private String name;
    private String country;
    private double capacity;
    private int constructionStart;
    private int connectionYear;
    
    /**
     * Constructor for objects of class PowerPlant
     */
    public PowerPlant(String name, String country, double capacity, int constructionStart)
    {
        this.name = name;
        this.country = country;
        this.capacity = capacity;
        this.constructionStart = constructionStart;
        this.connectionYear = -1;
    }
    
    public PowerPlant(String name, String country, double capacity, int constructionStart, int connectionYear)
    {
        this(name, country, capacity, constructionStart);
        this.connectionYear = connectionYear;
        
    }

    public double getCapacity()
    {
        return capacity;
    }
    
    /**
     * 
     */
    public void print()
    {
        System.out.printf("%-14s %-12s %-20s %-22s %-14s\n", name, capacity, constructionStart, connectionYear, country);
    }
}
