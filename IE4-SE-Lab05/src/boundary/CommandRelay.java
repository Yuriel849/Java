package boundary;

import cleaner.Cleaner;

public class CommandRelay {
    static public boolean sendCommand(Cleaner cleaner) {
        boolean response = false;

        if(Robot.sendCommand(cleaner)) { response = true; }

        return response;
    }

    static public String updateProgress() {
        return Robot.requestUpdate();
    }
}
