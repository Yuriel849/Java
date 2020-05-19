public class WindFarm implements IWindFarm
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
    
    public void print()
    {
        System.out.printf("| %-20s %-10.0f %-15s %-10d %-6d |\n",
            name, capacity, country, numberTurbines, year);
    }
}