package common;

/**
 * The IWindFarm interface
 *
 * @author Yuriel
 * @date 17.05.2020
 */
public interface IWindFarm
{
    public static void printHeader()
    {
        System.out.printf("| %-20s %-10s %-15s %-10s %-6s |\n",
            "Name", "Capacity", "Country", "Turbines", "Year");
    }
    
    // Abstract methods called in the WindFarmTable class
    void print();
    String getCountry();
    double getCapacity();
}
