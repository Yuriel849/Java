import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface used to access the server of the robot.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public interface IRobotController extends Remote {
    IStatus commandRobot(String cmd) throws RemoteException;
}
