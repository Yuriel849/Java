/**
 * Creates Return command object and transfer the command.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public class ReturnHomeCommandFactory implements ICommandFactory {
    /**
     * Constructor for objects of class ReturnHomeCommandFactory
     */
    public ReturnHomeCommandFactory() {}

    /**
     * 
     * Post Condition: ICommandRobot object is created 
     */
    public boolean createICommand() {
        ICommand returnHome = new ReturnHomeCommand("Return Home");
        return false;
    }
}