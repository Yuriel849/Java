
/**
 * Class PlayerState is used to hold information about the player's state
 * just before leaving a room.
 *
 * @author Mo
 * @version 2020.04.29
 */
public class PlayerState
{
    // instance variables
    public int roomID;

    /**
     * Constructor for objects of class PlayerState
     */
    public PlayerState(int currentRoomID)
    {
        
        this.roomID = currentRoomID;
    }
}
