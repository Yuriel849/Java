package boundary;

import cleaner.Cleaner;

public class Robot {
    static Cleaner currentCleaner;

    static boolean sendCommand(Cleaner cleaner) {
        currentCleaner = cleaner;
        return false;
    }

    static String requestUpdate() {
        return currentCleaner.updateProgress();
    }
}
