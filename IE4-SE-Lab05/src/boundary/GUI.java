package boundary;

import control.Controller;
import map.CleanMap;
import map.Map;
import map.RegionMap;
import map.RoomMap;
import model.Coordinates;

import java.util.Scanner;

public class GUI {
    String cleanMode = "auto"; // Default cleaning mode is "auto" mode.
    Map map = null;

    public void chooseMode(String mode) {
        cleanMode = mode;

        if((cleanMode.equals("room")) || (cleanMode.equals("region")) || (cleanMode.equals("auto"))) {
            map = new CleanMap();
        } else {
            System.out.println("Choose a valid cleaning mode.");
        }
    }

    public void chooseCleanArea() {
        Scanner reader = new Scanner(System.in);

        if(map == null) {
            System.out.println("Choose a cleaning mode first.");
        }

        if(cleanMode.equals("room")) {
            map = new RoomMap(map);
        } else if(cleanMode.equals("region")) {
            map = new RegionMap(map);
        }

        while(true) {
            try {
                System.out.println("Enter cleaning coordinates (enter 'done' to quit): ");
                String[] inputs = reader.nextLine().trim().toLowerCase().split(",");
                if(inputs[0].equals("done")) { break; }
                double x = Double.parseDouble(inputs[0]);
                double y = Double.parseDouble(inputs[1]);
                map.setCoord(new Coordinates(x, y));
            } catch(Exception e) {
                System.out.println("Invalid coordinates entered.");
                break;
            }
        }
    }

    public void start() {
        if(map != null) {
            System.out.println(new Controller(cleanMode, map).startCleaner());
        } else {
            System.out.println("Choose the cleaning mode and area before starting.");
        }
    }

    public void updateProgress() {
        System.out.println(Controller.updateProgress());
    }
}
