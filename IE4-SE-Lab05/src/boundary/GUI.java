package boundary;

import control.Controller;
import map.CleanMap;
import map.Map;
import map.RegionMap;
import map.RoomMap;
import model.Coordinates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The GUI of the App.
 * The user can select the cleaning mode, the area to be cleaned,
 * and instruct the Robot to start cleaning with the mode and area.
 * The Robot’s cleaning progress is also provided.
 */
public class GUI {
    String cleanMode;
    Map map = null;
    boolean modeChosen = false;
    boolean areaChosen = false;

    /**
     * The user chooses the cleaning mode from among "auto", "room", and "region".
     * Precondition: User enters valid input. Otherwise nothing happens.
     * Postcondition: A new CleanMap object is instantiated.
     */
    public void chooseMode(String mode) {
        cleanMode = mode;

        if((cleanMode.equals("room")) || (cleanMode.equals("region")) || (cleanMode.equals("auto"))) {
            map = new CleanMap();
            modeChosen = true;
            if(cleanMode.equals("auto")) { areaChosen = true; }
        } else {
            System.out.println("Choose a valid cleaning mode.");
        }
    }

    /**
     * The user chooses the cleaning area according to the chosen cleaning mode.
     * Precondition: User must already have chosen "room" or "region" cleaning mode.
     * Postcondition: For "room" mode, the user chooses which recommended cleaning plan to follow.
     *                For "region" mode, the user specifies which areas to clean.
     */
    public void chooseCleanArea() {
        Scanner reader = new Scanner(System.in);

        if(modeChosen == false) {
            System.out.println("Choose a cleaning mode first.");
            return;
        }
        if(cleanMode.equals("auto")) {
            System.out.println("The robot cleans autonomously in this cleaning mode.");
            return;
        }

        if(cleanMode.equals("room")) {
            map = new RoomMap(map);

            while(true) {
                System.out.println("Choose your preferred cleaning plan. (enter 'done' to quit): ");
                System.out.println("Cleaning recommendations based on your past cleaning actions...");
                ArrayList<String> rooms = ((RoomMap) map).roomRecommend();
                Iterator roomIter = rooms.iterator();
                while(roomIter.hasNext()) {
                    System.out.println(roomIter.next());
                }
                String input = reader.nextLine().trim().toLowerCase();
                if(input.equals("done")) { break; }
                if(rooms.contains(input)) {
                    ((RoomMap) map).setRoom(input);
                    break;
                }
            }
            if((((RoomMap) map).getRoom().isEmpty()) || (((RoomMap) map).getRoom() == null)) {
                return;
            }
        } else if(cleanMode.equals("region")) {
            map = new RegionMap(map);

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
                    return;
                }
            }

            if(map.getCoord().isEmpty()) {
                return;
            }
        }
        areaChosen = true;
    }

    /**
     * The user chooses to start the Robot's cleaning.
     * Precondition: User must already have chosen a cleaning mode and cleaning area.
     * Postcondition: User's chosen cleaning mode and area passed on to the controller.
     */
    public void start() {
        if((modeChosen == true) && (areaChosen == true)) {
            System.out.println(new Controller(cleanMode, map).startCleaner());
        } else {
            System.out.println("Choose the cleaning mode and area before starting.");
        }
    }

    /**
     * User requests cleaning progress update from the Robot.
     */
    public void updateProgress() {
        System.out.println(Controller.updateProgress());
    }
}
