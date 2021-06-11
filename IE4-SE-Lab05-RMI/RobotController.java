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
    String cmd;
    Status status;
    boolean success = false;
    ICommandFactory command;

    public RobotController() throws RemoteException {
        status = new Status(null, 100);
    }
    
    public IStatus commandRobot(String cmd) throws RemoteException {
        this.cmd = cmd;
        if(cmd.equals("Auto Mode")) {
            success = autoMode();
            if(success) {
                status.setMode(cmd);
            }
        }
        else if(cmd.equals("Pause")) {
            success = pauseMode();
            if(success) {
                status.setMode(cmd);
            }
        }
        else if(cmd.equals("Return Home")) {
            success = returnHome();
            if(success) {
                status.setMode(cmd);
            }
        }
        
        return status;
    }
    
    /**
     * Auto Mode method
     */
    private boolean autoMode() {
        command = new AutoCommandFactory();
        return command.createICommand();
    }
    
    /**
     * Pause method
     */
    private boolean pauseMode() {
        command = new PauseCommandFactory();
        return command.createICommand();
    }
    
    /**
     * Return Home method
     */
    private boolean returnHome() {
        command = new ReturnHomeCommandFactory();
        return command.createICommand();
    }
}