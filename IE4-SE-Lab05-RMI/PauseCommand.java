/**
 * Pause command class, implements the ICommand interface.
 * 
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.12
 */
public class PauseCommand implements ICommand {
    private String command;
    private boolean state = false;
    
    /**
     * Constructor for objects of class PauseCommand
     */
    public PauseCommand(String command) {
        this.command = command;
        executeCommand();   
    }

    /**
     * Creates an object of class CommandTransmittor
     * Precondition: User's chooses a valid command.
     * Postcondition: appropriate object is created.
     */
    public void executeCommand() {
        System.out.println("Creating chosen command: " + command + "\n");
        System.out.println("Executing command: " + command + "\n");
        System.out.println("Robot has stopped");
        state = true;
    }
     
    public boolean getState() {
        return state;
    }
}