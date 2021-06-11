/**
 * Return Home command class, implements the ICommand interface.
 * 
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.12
 */
public class ReturnHomeCommand implements ICommand {
    private String command;
    private boolean state = false;

    /**
     * Constructor for objects of class ReturnHomeCommand gets the command to transmit as a string
     */
    public ReturnHomeCommand(String command) {
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
        System.out.println("Robot returning home to the charging dock");
        state = true;
    }
     
    public boolean getState() {
        return state;
    }
}