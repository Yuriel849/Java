package cleaner;

/**
 * A Cleaner object for the Auto Mode.
 * Does not contain a map, because in Auto Mode the Robot autonomously generates a map
 * for cleaning the house.
 */
public class AutoCleaner implements Cleaner {
    /**
     * Returns a cleaning progress update as a String.
     */
    @Override
    public String updateProgress() {
        return "Robot is cleaning autonomously.";
    }
}
