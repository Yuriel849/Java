import client.*;
import implementation.*;

/**
 * Write a description of class Application here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Application
{
    public static void main(String[] args) {
        WindFarmTable table = new WindFarmTable("Offshore Wind Farms");
        table.initList();
        table.printTable();
    }
}
