package boundary;

import cleaner.Cleaner;

/**
 * A simple class representing the external actor, the Robot.
 * Has two simple functionalities and receives commands sent from the App's controller
 * and returns cleaning progress updates.
 */
public class Robot {
    static Cleaner currentCleaner;

    /**
     * Receives commands transmitted by the App.
     * Returns true to indicate successful receipt.
     */
    static boolean sendCommand(Cleaner cleaner) {
        currentCleaner = cleaner;
        return true;
    }

    /**
     * Receives a request for a cleaning status update from the App.
     * Queries the current Cleaner object for an update to return to the App.
     */
    static String requestUpdate() { return currentCleaner.updateProgress(); }
}
