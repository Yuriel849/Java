 

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Write a description of interface IRobotController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IRobotController extends Remote
{
    void commandRobot(String cmd) throws RemoteException;
}
