import client.*;
import implementation.*;

/**
 * The Application class holds the static method main().
 * The main() method creates, initializes, and prints a WindFarmTable.
 *
 * @author Yuriel
 * @date 17.05.2020
 */
public class Application
{
    public static void main(String[] args) {
        WindFarmTable table = new WindFarmTable("Offshore Wind Farms");
        table.initList();
        table.printTable();
    }
}
