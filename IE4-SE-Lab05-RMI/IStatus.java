import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface used by the cleaning robot to give feedback about its current status to the app.
 *
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public interface IStatus extends Remote {
    String getMode() throws RemoteException;
    int getBatteryLvl() throws RemoteException;    
}
