/**
 * Pause command class, implements the ICommand interface.
 * 
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.12
 */
public class PauseCommand implements ICommand {
    private String command;
    
    /**
     * Constructor for objects of class PauseCommand
     */
    public PauseCommand(String command) {
        this.command = command;
    }

    /**
     * Creates an object of class CommandTransmittor
     * Precondition: User's chooses a valid command.
     * Postcondition: appropriate object is created.
     */
    public void executeCommand(Status status) {
        System.out.println("Creating chosen command: " + command + "\n");
        System.out.println("Executing command: " + command + "\n");
        status.setMsg("Robot has stopped");
    }
}