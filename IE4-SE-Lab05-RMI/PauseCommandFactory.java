import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Creates pause command object and transfer the command.
 *
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class PauseCommandFactory extends UnicastRemoteObject implements ICommandFactory
{
    
    /**
     * Constructor for objects of class PauseCommandFactory
     */
    public PauseCommandFactory() throws RemoteException {}

    /**
     * 
     * Post Condition: ICommandRobot object is created 
     */
    public void createICommand() throws RemoteException
    {
        ICommandRobot pause = new PauseCommand("Pause");
    }
}
