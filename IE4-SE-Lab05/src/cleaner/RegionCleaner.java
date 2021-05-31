package cleaner;

import map.Map;

/**
 * A Cleaner object for the Region Mode.
 * The map is created and appropriately decorated when the user chooses which region to clean.
 */
public class RegionCleaner implements Cleaner {
    Map map;

    public RegionCleaner(Map map) {
        this.map = map;
    }

    /**
     * Returns a cleaning progress update as a String.
     */
    @Override
    public String updateProgress() {
        return "Robot is cleaning the region designated by the user.";
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
