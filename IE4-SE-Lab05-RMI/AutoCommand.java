/**
 * Auto Mode command class, implements the ICommandRobot interface.
 * 
 * @author Divyesh Joshi
 * @version 2021.06.11
 */
public class AutoCommand implements ICommand {
    private String commandToTransmit;
    
    /**
     * Constructor for objects of class AutoCommand
     */
    public AutoCommand(String commandToTransmit) {
        this.commandToTransmit = commandToTransmit;
        updateProgress();
        executeCommand();
    }

    /**
     * Creates an object of class CommandTransmittor
     * Precondition: User's chooses a valid command.
     * Postcondition: appropriate object is created.
     */
    public void executeCommand() {
    }
    
    public void updateProgress() {
        System.out.println("Creating chosen command: "+commandToTransmit+"\n");
    }
}