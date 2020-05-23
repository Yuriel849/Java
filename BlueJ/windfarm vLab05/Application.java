import client.*;
//import common.*;
import implementation.*;


/**
 * 
 */

/**
 * @author Mohamed Elghamrawy
 *
 */
public class Application {
	
	// Class fields
	private static FacilityTable table;
	// Boolean to indicate for method initList() whether the list has already been initialized or not
    private static boolean initialized = false;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Instantiate object of FacilityTabel
		table = new FacilityTable("Facilities Table");
		initList();
		
		table.printTable();
	}
    
	/**
     * Initialize the list with dummy data
     */
    public static void initList()
    {
    	
        if(initialized == false)
        {	
        	// Add wind farms
        	table.addPowerStation(new WindFarm("Thortonbank", "Belgium", 325.0, 54, 2013));
        	table.addPowerStation(new WindFarm("Sheringham Shoal", "United Kingdom", 315.0, 88, 2012));
        	table.addPowerStation(new WindFarm("Thanet", "United Kingdom", 300.0, 100, 2010));
        	table.addPowerStation(new WindFarm("Walney", "United Kingdom", 659.0, 87, 2012));
        	table.addPowerStation(new WindFarm("London Array", "United Kingdom", 630.0, 175, 2013));
        	table.addPowerStation(new WindFarm("Gemini Wind Farm", "Netherlands", 600.0, 150, 2017));
        	table.addPowerStation(new WindFarm("Greater Gabbard", "United Kingdom", 504.0, 140, 2012));
        	table.addPowerStation(new WindFarm("Anholt", "Denmark", 400.0, 111, 2013));
        	table.addPowerStation(new WindFarm("BARD Offshore 1", "Germany", 400.0, 80, 2013));
        	table.addPowerStation(new WindFarm("Rampion Wind Farm", "United Kingdom", 400.0, 116, 2018));
            
        	// Add nuclear plants
        	table.addPowerStation(new PowerPlant("Barakah","UAE", 538.0, 2012, 2020));
        	table.addPowerStation(new PowerPlant("Hinkley Point C", "UK", 330.0, 2018, 2026));
        	table.addPowerStation(new PowerPlant("Vogtle", "USA", 223.4, 2013, 2021));
        	table.addPowerStation(new PowerPlant("Belarusian", "Belarus", 221.8, 2012, 2020));
        	table.addPowerStation(new PowerPlant("Rooppur", "Bangladesh", 216.0, 2017, 2023));
        	table.addPowerStation(new PowerPlant("Karachi", "Pakistan", 211.8, 2013, 2021));
        	table.addPowerStation(new PowerPlant("Bushehr", "Iran", 183.0, 2019, 2024));
        	table.addPowerStation(new PowerPlant("Mochovce", "Slovakia", 175.2, 1987, 2020));
        	table.addPowerStation(new PowerPlant("Kakrapar", "India", 166.4, 2010, 2022));
        	table.addPowerStation(new PowerPlant("Shimane", "Japan", 137.3, 2007, -1));
        	table.addPowerStation(new PowerPlant("Oma", "Japan", 132.5, 2010, 2025));
        	table.addPowerStation(new PowerPlant("Zhangzhou", "China", 112.6, 2019, 2024));
        	table.addPowerStation(new PowerPlant("Akkuyu", "Turkey", 101.4, 2015, 2023));
        	
        	// Add solar parks
        	table.addPowerStation(new SolarPark("Bhadla","India",2245,2020,40));
        	table.addPowerStation(new SolarPark("Pavagada","India",2,05,2019));
        	table.addPowerStation(new SolarPark("Tengger Desert","China",1547,2016,43));
        	table.addPowerStation(new SolarPark("Benban", "Egypt",15,2019,37));
        	table.addPowerStation(new SolarPark("Noor", "UAE",1177,2019,8));
        	table.addPowerStation(new SolarPark("Kurnool","India",1,2017,24));
        	table.addPowerStation(new SolarPark("Datong","China",1,2016,-1));
        	table.addPowerStation(new SolarPark("NP Kunta","India",900,2020,-1));
        	table.addPowerStation(new SolarPark("Longyangxia Dam","China",850,2015,23));
        	table.addPowerStation(new SolarPark("Villanueva","Mexico",828,2018,28));
        	table.addPowerStation(new SolarPark("Rewa","India",750,2018,-1));
        	table.addPowerStation(new SolarPark("Charanka","India",690,2012,20));
        	table.addPowerStation(new SolarPark("Kamuthi","India",648,2017,13));
        	table.addPowerStation(new SolarPark("Al Maktoum", "UAE",613,2019,-1));
        	table.addPowerStation(new SolarPark("Solar Star", "US",579,2015,13));
        	table.addPowerStation(new SolarPark("Copper Mountain","US",552,2016,16));
        	table.addPowerStation(new SolarPark("Desert Sunlight","US",550,2015,16));
        	table.addPowerStation(new SolarPark("Topaz","US",550,2014,19));
        	table.addPowerStation(new SolarPark("Huanghe","China",500,2014,23));
        	table.addPowerStation(new SolarPark("Three Gorges","China",500,2018,-1));
        	table.addPowerStation(new SolarPark("Three Gorges","China",500,2018,-1));
        	table.addPowerStation(new SolarPark("Núñez de Balboa","Spain",500,2020,10));
        	
            System.out.println("FacilityTable object initialized");
            
            initialized = true;
        }
        else
        {
            System.out.println("Already initialized");
        }
    }



}
