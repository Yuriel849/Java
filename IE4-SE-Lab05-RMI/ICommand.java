/**
 * Interface ICommandRobot.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.13
 */
public interface ICommand {
    /**
     * To be implemented by classes
     */
    void executeCommand(Status status);
}
