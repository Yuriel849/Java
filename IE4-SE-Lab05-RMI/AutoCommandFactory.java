/**
 * Creates auto command object and transfer the command.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public class AutoCommandFactory implements ICommandFactory {
    /**
     * Constructor for objects of class AutoCommandFactory
     */
    public AutoCommandFactory() {}

    /**
     * 
     * Post Condition: ICommandRobot object is created 
     */
    public void createICommand(Status status) {
        ICommand auto = new AutoCommand("Auto Mode");
        auto.executeCommand(status);
    }
}
