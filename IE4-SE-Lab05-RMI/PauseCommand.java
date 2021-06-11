/**
 * Pause command class, implements the ICommandRobot interface.
 * 
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class PauseCommand implements ICommand {
    // instance variables 
    private String commandToTransmit;
    
    /**
     * Constructor for objects of class PauseCommand
     */
    public PauseCommand(String commandToTransmit) {
        // initialise instance variables
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