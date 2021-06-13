/**
 * Creates Return command object and transfer the command.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.13
 */
public class ReturnHomeCommandFactory implements ICommandFactory {
    /**
     * Constructor for objects of class ReturnHomeCommandFactory
     */
    public ReturnHomeCommandFactory() {}

    /**
     * Creates a ReturnHomeCommand object and executes.
     * Post Condition: ICommandRobot object is created
     * @param status
     */
    public void createICommand(Status status) {
        ICommand returnHome = new ReturnHomeCommand("Return Home");
        returnHome.executeCommand(status);
    }
}