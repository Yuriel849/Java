/**
 * Creates pause command object and transfer the command.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public class PauseCommandFactory implements ICommandFactory {
    
    /**
     * Constructor for objects of class PauseCommandFactory
     */
    public PauseCommandFactory() {}

    /**
     * 
     * Post Condition: ICommandRobot object is created 
     */
    public void createICommand(Status status) {
        ICommand pause = new PauseCommand("Pause");
        pause.executeCommand(status);
    }
}
