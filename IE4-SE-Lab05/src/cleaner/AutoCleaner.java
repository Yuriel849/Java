package cleaner;

public class AutoCleaner implements Cleaner {
    @Override
    public String updateProgress() {
        return "Robot is cleaning autonomously.";
    }
}
