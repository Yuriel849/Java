/**
 * Auto Mode command class, implements the ICommand interface.
 * 
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.13
 */
public class AutoCommand implements ICommand {
    private String command;
    
    /**
     * Constructor for objects of class AutoCommand
     */
    public AutoCommand(String command) {
        this.command = command;
    }

    /**
     * If the robot's battery has more than 50 percent charge, will start cleaning in automatic mode.
     * If not, will not start cleaning and will respond that battery levels are insufficient.
     * @param status
     */
    public void executeCommand(Status status) {
        System.out.println("Creating chosen command: " + command + "\n");
        try {
            if(status.getBatteryLvl() > 50) {
                System.out.println("Executing command: " + command + "\n");
                status.setBatteryLvl(status.getBatteryLvl() - 10);
                status.setMsg("Starting automatic cleaning");
            } else {
                status.setMsg("Insufficient battery levels to execute your command.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}