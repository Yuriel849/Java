/**
 * Return Home command class, implements the ICommand interface.
 * 
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.12
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
     * Creates an object of class CommandTransmittor
     * Precondition: User's chooses a valid command.
     * Postcondition: appropriate object is created.
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