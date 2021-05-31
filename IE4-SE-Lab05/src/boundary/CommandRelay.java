package boundary;

import cleaner.Cleaner;

/**
 * The boundary object responsible for communicating with the Robot.
 * This class uses static methods to send commands from the App to the Robot and
 * requests updates for displaying the progress of the Robot’s cleaning.
 */
public class CommandRelay {
    /**
     * Passes on commands from the App's controller to the Robot.
     * Postcondition: Returns true, if the commands were successfully received by the Robot.
     *                Returns false, by default or if the Robot returns a failure.
     */
    static public boolean sendCommand(Cleaner cleaner) {
        boolean response = false;

        if(Robot.sendCommand(cleaner)) { response = true; }

        return response;
    }

    /**
     * Requests a cleaning progress update from the Robot.
     */
    static public String updateProgress() {
        return Robot.requestUpdate();
    }
}
