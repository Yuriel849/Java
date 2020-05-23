package common;

/**
 * The Facility interface
 *
 * @author Yuriel
 * @date 20.05.2020
 */
public interface Facility
{
    public static void printHeader()
    {
        System.out.printf("| %-20s | %-20s | %-15s | %-15s | %-18s | %-18s | %-18s | %-9s |\n",
            "Name", "Country", "Capacity", "No. of Turbines", "Year commissioned",
            "Construction Start", "Planned Connection", "Land Size");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    // Abstract methods called in the WindFarmTable class
    void print();
    double getCapacity();
}
