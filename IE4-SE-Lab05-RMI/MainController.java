import java.rmi.Naming;

/**
 * The central controller class for managing the interaction with other classes.
 * When the controller receives the user’s chosen command,
 * it creates the command.
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class MainController
{
    // instance variables - replace the example below with your own
    String cmd;
    boolean status;
    /**
     * Constructor for objects of class MainController
     */
    public MainController(String cmd)
    {     
        // initialise instance variables
        this.cmd = cmd;
        status = createCommand();
        if(!status)
            System.out.println("Enter appropriate command");
    }

    public boolean createCommand()
    {
        try {
            IRobotController robot = (IRobotController) Naming.lookup("rmi://127.0.0.1/robotController");
            System.out.println("Transmitting to the Robot: "+cmd+"\n");
            robot.commandRobot(cmd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
