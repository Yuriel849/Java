import java.rmi.RemoteException;

/**
 * Pause command class, implements the ICommandRobot interface.
 * 
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class PauseCommand implements ICommandRobot
{
    // instance variables 
    private String commandToTransmit;
    /**
     * Constructor for objects of class PauseCommand
     */
    public PauseCommand(String commandToTransmit) throws RemoteException
    {
        // initialise instance variables
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