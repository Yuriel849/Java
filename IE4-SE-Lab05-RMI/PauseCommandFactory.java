/**
 * Creates pause command object and transfer the command.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.13
 */
public class PauseCommandFactory implements ICommandFactory {
    
    /**
     * Constructor for objects of class PauseCommandFactory
     */
    public PauseCommandFactory() {}

    /**
     * Creates a PauseCommand object and executes.
     * Post Condition: ICommandRobot object is created
     * @param status
     */
    public void createICommand(Status status) {
        ICommand pause = new PauseCommand("Pause");
        pause.executeCommand(status);
    }
}
