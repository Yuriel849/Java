import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ICommandFactory Interface.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface ICommandFactory extends Remote
{
    /**
     * TO be implemented by all classes implementing this interface
     */
    void createICommand() throws RemoteException;
}
