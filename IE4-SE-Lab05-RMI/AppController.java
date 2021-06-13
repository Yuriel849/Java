import java.rmi.Naming;

/**
 * The central controller class for managing the interaction with other classes.
 * When the controller receives the user's chosen command, it creates the command.
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public class AppController {
    String cmd;
    IStatus status;
    
    /**
     * Constructor for objects of class MainController
     */
    public AppController(String cmd) {     
        this.cmd = cmd;
    }

    public IStatus createCommand() {
        try {
            IRobotController server = (IRobotController) Naming.lookup("rmi://127.0.0.1/server");
            System.out.println("Transmitting to the Robot: "+cmd+"\n");
            return server.commandRobot(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}