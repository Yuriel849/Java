import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Robot System.
 * the methods are just a prototype 
 * @version (2.0)
 */
public class RobotController extends UnicastRemoteObject implements IRobotController
{
    // instance variables - replace the example below with your own
    String cmd;

    public RobotController() throws RemoteException {}
    
    public void commandRobot(String cmd) throws RemoteException {
        // initialise instance variables
        this.cmd = cmd;
        if(cmd.equals("Auto Mode"))
                autoMode();
        else if(cmd.equals("Pause"))
                pauseMode();
        else if(cmd.equals("Return Home"))       
                returnHome();
    }
    
    /**
     * Return Home method
     */
    private void returnHome()
    {
        // put your code here
        System.out.println("Activated: "+cmd+"\n");
    }
    
    /**
     * Auto Mode method
     */
    private void autoMode()
    {
        System.out.println("Activated: "+cmd+"\n");
    }
    
    /**
     * Pause method
     */
    private void pauseMode()
    {
        System.out.println("Activated: "+cmd+"\n");
    }
}