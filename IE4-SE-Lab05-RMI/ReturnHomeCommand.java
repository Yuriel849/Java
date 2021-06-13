/**
 * Return Home command class, implements the ICommand interface.
 * 
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.13
 */
public class ReturnHomeCommand implements ICommand {
    private String command;

    /**
     * Constructor for objects of class ReturnHomeCommand gets the command to transmit as a string
     */
    public ReturnHomeCommand(String command) {
        this.command = command;    
    }

    /**
     * If the robot's battery has more than 30 percent charge, the robot will return hom to the charging dock.
     * If not, the robot will give feedback that the battery levels are too low to execute the user's command.
     * @param status
     */
    public void executeCommand(Status status) {
        System.out.println("Creating chosen command: " + command + "\n");
        
        try {
            if(status.getBatteryLvl() > 30) {
                System.out.println("Executing command: " + command + "\n");
                System.out.println("Robot returning home to the charging dock");
                status.setBatteryLvl(status.getBatteryLvl() - 10);
                status.setMsg("Returning to the charging dock.");
            } else {
                status.setMsg("Battery levels are too low to return home.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}