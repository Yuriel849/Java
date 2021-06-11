import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Creates auto command object and transfer the command.
 *
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class AutoCommandFactory extends UnicastRemoteObject implements ICommandFactory
{
    
    /**
     * Constructor for objects of class AutoCommandFactory
     */
    public AutoCommandFactory() throws RemoteException {}

    /**
     * 
     * Post Condition: ICommandRobot object is created 
     */
    public void createICommand() throws RemoteException
    {
        ICommandRobot auto = new AutoCommand("Auto Mode");
    }
}
