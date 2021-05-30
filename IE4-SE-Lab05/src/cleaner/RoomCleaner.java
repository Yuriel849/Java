package cleaner;

import map.Map;

public class RoomCleaner implements Cleaner {
    Map map;

    public RoomCleaner(Map map) {

    }

    @Override
    public String updateProgress() {
        return "Robot is cleaning the rooms in order.";
    }

    public Map getMap() { return map; }

    public void setMap(Map map) { this.map = map; }

}
