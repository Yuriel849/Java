import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;

/**
 * Class used by the cleaning robot to give feedback about its current status to the app.
 * Contains information about the current cleaning mode, battery level, etc.
 * The fields may only be set in the server, the client can only read the fields.
 *
 * @author Myungjun Kim
 * @version 2021.06.13
 */
public class Status extends UnicastRemoteObject implements IStatus, Serializable {
    private String mode;
    private String msg;
    private int batteryLvl;
    
    /**
     * Constructor for objects of class Status
     */
    public Status(String mode, int batteryLvl) throws RemoteException {
        this.mode = mode;
        this.batteryLvl = batteryLvl;
    }

    /**
     * Set the current cleaning mode of the robot.
     * @param mode the current mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    /**
     * Get the current cleaning mode of the robot.
     * @return the current mode
     */
    public String getMode() throws RemoteException {
        return mode;
    }
    
    /**
     * Set a message about the current status of the robot.
     * @param msg the message
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    /**
     * Get the message about the current status of the robot.
     * @return the message
     */
    public String getMsg() throws RemoteException {
        if(msg != null) {
            return msg;
        } else {
            return "There is no message.";
        }
    }
    
    /**
     * Set the current battery level of the robot.
     * @param batteryLvl the battery level
     */
    public void setBatteryLvl(int batteryLvl) {
        this.batteryLvl = batteryLvl;
    }

    /**
     * Get the current battery level of the robot.
     * @return the battery level
     */
    public int getBatteryLvl() throws RemoteException {
        return batteryLvl;
    }
}
