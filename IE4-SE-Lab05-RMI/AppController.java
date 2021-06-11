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
        status = createCommand();
        if(status == null)
            System.out.println("Enter appropriate command");
    }

    public IStatus createCommand() {
        try {
            IRobotController robot = (IRobotController) Naming.lookup("rmi://127.0.0.1/robotController");
            System.out.println("Transmitting to the Robot: "+cmd+"\n");
            return robot.commandRobot(cmd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}