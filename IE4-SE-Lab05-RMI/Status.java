import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Class used by the cleaning robot to give feedback about its current status to the app.
 * Contains information about the current cleaning mode, battery level, etc.
 * The fields may only be set in the server, the client can only read the fields.
 *
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public class Status extends UnicastRemoteObject implements IStatus {
    private String mode;
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
