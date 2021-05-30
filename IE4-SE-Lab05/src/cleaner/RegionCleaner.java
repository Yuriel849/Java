package cleaner;

import map.Map;

public class RegionCleaner implements Cleaner {
    Map map;

    public RegionCleaner(Map map) {
        this.map = map;
    }

    @Override
    public String updateProgress() {
        return "Robot is cleaning the region designated by the user.";
    }

    public Map getMap() { return map; }

    public void setMap(Map map) { this.map = map; }

}
