package control;

import boundary.CommandRelay;
import cleaner.AutoCleaner;
import cleaner.Cleaner;
import cleaner.RegionCleaner;
import cleaner.RoomCleaner;
import map.Map;

/**
 * The central controller class for managing the interaction of the other classes.
 * When the controller receives the user’s chosen cleaning mode and area,
 * along with the start command, it creates the appropriate cleaner and
 * sends a command to the Robot via the CommandRelay to start the cleaning process.
 */
public class Controller {
    String cleanMode;
    Cleaner cleaner;
    Map map;

    public Controller(String cleanMode, Map map) {
        this.cleanMode = cleanMode;
        this.map = map;
    }

    /**
     * Called from the GUI to instruct the App's controller to start the cleaning of the Robot.
     * Precondition: User's chosen cleaning mode and map are provided via the Controller constructor.
     * Postcondition: Returns true, if the cleaner was successfully prepared and
     *                commands were successfully sent to the Robot.
     *                Returns false, if transmission of commands failed.
     */
    public String startCleaner() {
        String status = "N/A";

        prepCleaner(cleanMode, map);
        if(CommandRelay.sendCommand(cleaner)) {
            status = "New commands sent to the Robot.";
        } else {
            status = "An error occurred while executing your commands. Please try again.";
        }
        return status;
    }

    /**
     * Called from the GUI to request an update of the Robot's cleaning progress.
     */
    static public String updateProgress() {
        return CommandRelay.updateProgress();
    }

    /**
     * Instantiates and prepares the relevant Cleaner object for the user's chosen cleaning mode.
     * Precondition: User's chooses a valid cleaning mode, which is provided to the Controller.
     * Postcondition: Controller object's "cleaner" variable is assigned the relevant Cleaner object.
     */
    private void prepCleaner(String cleanMode, Map map) {
        if(cleanMode.equals("auto")) {
            cleaner = new AutoCleaner();
        } else if(cleanMode.equals("room")) {
            cleaner = new RoomCleaner(map);
        } else if(cleanMode.equals("region")) {
            cleaner = new RegionCleaner(map);
        }
    }
}
