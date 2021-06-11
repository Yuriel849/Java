import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * interface ICommandRobot.
 *
 * @author (Divyesh Joshi)
 * @version (1.0)
 */
public interface ICommandRobot extends Remote
{
    /**
     * To be implemented by classes
     */
    void executeCommand() throws RemoteException;
}
