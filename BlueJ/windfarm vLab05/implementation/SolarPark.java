package implementation;


/**
 * Write a description of class SolarPark here.
 *
 * @author Yuriel
 * @version 20.05.2020
 */
public class SolarPark extends GenericFacility
{
    private int landSize;
    private int connectionYear;

    /**
     * Constructor for objects of class SolarPark
     */
    public SolarPark(String name, String country, double capacity, int connectionYear, int landSize)
    {
        super(name, country, capacity);
        this.landSize = landSize;
        this.connectionYear = connectionYear;
    }
    
    public void print()
    {
        //String x = "| %-20s | %-20s | %-15s | %-15s | %-18s | %-18s | %-18s | %-9s |\n"
    	
    	String row = String.format("| %-20s | %-20s | %-15s | %-15s | %-18s | %-18s | %-18s | %-9s |\n",
        		getName(), getCountry(), getCapacity(), "N/A", "N/A", "N/A", this.connectionYear, this.landSize);
        
        // print list
        System.out.print(row);
    }
}
