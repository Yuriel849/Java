/**
 * Write a description of class PowerPlant here.
 *
 * Mo
 * 01/04/2020
 */
public class PowerPlant implements IWindFarm
{
    // instance variables - replace the example below with your own
    private String name;
    private String country;
    private double capacity;
    private int constructionStart;
    private int connectionYear;

    /**
     * Constructor for objects of class PowerPlant
     */
    public PowerPlant(String name, String country, double capacity, int constructionStart, int connectionYear) 
    {
        // initialise instance variables
        this.name = name;
        this.country = country;
        this.capacity = capacity;
        this.constructionStart = constructionStart;
        this.connectionYear = connectionYear;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void print()
    {
        //String heading = String.format("%-20s | %-15s | %-12s | %-15s | %-15s", "Name", "Country", "Capacity", "Contstruction Date", "Connection Date");
        String row = String.format("| %-20s %-10s %-15s %-10s %-6s |\n",
        this.name, this.capacity, this.country, this.constructionStart, this.connectionYear);
        
        // print list
        System.out.println(row);
    }
    
    /**
     * returns private  field  capcity when called
     *
     * @param  
     * @return capacity
     */
    public double getCapacity()
    {
        return this.capacity;
    }
}
