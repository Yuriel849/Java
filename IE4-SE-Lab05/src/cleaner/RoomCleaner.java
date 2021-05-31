package cleaner;

import map.Map;
import map.RoomMap;

/**
 * A Cleaner object for the Room Mode.
 * The map is created and appropriately decorated when the user chooses
 * the recommendation deciding which area to clean.
 */
public class RoomCleaner implements Cleaner {
    Map map;

    public RoomCleaner(Map map) {
        this.map = map;
    }

    /**
     * Returns a cleaning progress update as a String.
     */
    @Override
    public String updateProgress() {
        return "Robot is cleaning according to the plan, " + ((RoomMap) map).getRoom() + ".";
    }

    /**
     * Returns the Map object inside this Cleaner.
     */
    public Map getMap() { return map; }

    /**
     * Switches the previous Map with the new Map object.
     */
    public void setMap(Map map) { this.map = map; }

}
