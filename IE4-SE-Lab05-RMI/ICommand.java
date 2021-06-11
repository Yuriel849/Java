/**
 * Interface ICommandRobot.
 *
 * @author Divyesh Joshi
 * @version 2021.06.11
 */
public interface ICommand {
    /**
     * To be implemented by classes
     */
    void executeCommand();
    
    boolean getState();
}
