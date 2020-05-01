
/**
 * Class PlayerState is used to hold information about the player's state
 * just before leaving a room.
 *
 * @author Mo
 * @version 2020.04.29
 */
public class PlayerState
{
    // fi
    public Room room;

    /**
     * Constructor for objects of class PlayerState
     */
    public PlayerState(Room currentRoom)
    {
        
        this.room = currentRoom;
    }
}
