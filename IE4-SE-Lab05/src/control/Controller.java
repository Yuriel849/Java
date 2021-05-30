package control;

import boundary.CommandRelay;
import cleaner.AutoCleaner;
import cleaner.Cleaner;
import cleaner.RegionCleaner;
import cleaner.RoomCleaner;
import map.Map;

public class Controller {
    String cleanMode;
    Cleaner cleaner;
    Map map;
    String status = "N/A";

    public Controller(String cleanMode, Map map) {
        this.cleanMode = cleanMode;
        this.map = map;
    }

    public String startCleaner() {
        prepCleaner(cleanMode, map);
        if(CommandRelay.sendCommand(cleaner)) {
            status = "Robot sent new commands.";
        } else {
            status = "An error occurred while executing your commands. Please try again.";
        }
        return status;
    }

    static public String updateProgress() {
        return CommandRelay.updateProgress();
    }

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
