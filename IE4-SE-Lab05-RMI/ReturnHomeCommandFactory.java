import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Creates Return command object and transfer the command.
 *
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class ReturnHomeCommandFactory extends UnicastRemoteObject implements ICommandFactory
{
    /**
     * Constructor for objects of class ReturnHomeCommandFactory
     */
    public ReturnHomeCommandFactory() throws RemoteException {}

    /**
     * 
     * Post Condition: ICommandRobot object is created 
     */
    public void createICommand() throws RemoteException
    {
        ICommandRobot returnHome = new ReturnHomeCommand("Return Home");
    }
}