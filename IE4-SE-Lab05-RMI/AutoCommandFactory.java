/**
 * Creates auto command object and transfer the command.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.13
 */
public class AutoCommandFactory implements ICommandFactory {
    /**
     * Constructor for objects of class AutoCommandFactory
     */
    public AutoCommandFactory() {}

    /**
     * Creates a AutoCommand object and executes.
     * Post Condition: ICommandRobot object is created
     * @param status
     */
    public void createICommand(Status status) {
        ICommand auto = new AutoCommand("Auto Mode");
        auto.executeCommand(status);
    }
}
