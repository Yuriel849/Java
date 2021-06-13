/**
 * Pause command class, implements the ICommand interface.
 * 
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.13
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
     * The robot will pause whatever it is doing.
     * @param status
     */
    public void executeCommand(Status status) {
        System.out.println("Creating chosen command: " + command + "\n");
        System.out.println("Executing command: " + command + "\n");
        status.setMsg("Robot has stopped");
    }
}