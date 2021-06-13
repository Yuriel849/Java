import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Robot System.
 * 
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public class RobotController extends UnicastRemoteObject implements IRobotController {
    Status status;
    ICommandFactory command;

    public RobotController() throws RemoteException {
        status = new Status(null, 100);
    }
    
    public IStatus commandRobot(String cmd) throws RemoteException {
        status.setMode(cmd);
        
        if(cmd.equals("Auto Mode")) {
            autoMode();
        } else if(cmd.equals("Pause")) {
            pauseMode();
        } else if(cmd.equals("Return Home")) {
            returnHome();
        } else {
            status.setMsg("Wrong command");
        }
        
        return status;
    }
    
    /**
     * Auto Mode method
     */
    private void autoMode() {
        command = new AutoCommandFactory();
        command.createICommand(status);
    }
    
    /**
     * Pause method
     */
    private void pauseMode() {
        command = new PauseCommandFactory();
        command.createICommand(status);
    }
    
    /**
     * Return Home method
     */
    private void returnHome() {
        command = new ReturnHomeCommandFactory();
        command.createICommand(status);
    }
}