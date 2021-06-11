import java.rmi.RemoteException;

/**
 * Auto Mode command class, implements the ICommandRobot interface.
 * 
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class AutoCommand implements ICommandRobot
{
    private String commandToTransmit;
    
    /**
     * Constructor for objects of class AutoCommand
     */
    public AutoCommand(String commandToTransmit) throws RemoteException
    {
        this.commandToTransmit = commandToTransmit;
        updateProgress();
        executeCommand();
    }

    /**
     * Creates an object of class CommandTransmittor
     * Precondition: User's chooses a valid command.
     * Postcondition: appropriate object is created.
     */
    public void executeCommand() throws RemoteException
    {
        ITransmitter cmd = new Transmitter();
        cmd.setCommand(commandToTransmit);
        cmd.transmit();
    }
    
    public void updateProgress()
    {
        System.out.println("Creating chosen command: "+commandToTransmit+"\n");
    }
}
