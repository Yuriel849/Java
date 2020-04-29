/**
 * Class Player
 *
 * @author Yuriel
 * @version 2020.04.29
 */
public class Player extends Character
{
    // A pack being carried by the player as an inventory (maximum 10 items)
    private Pack pack;
    
    /**
     * Default constructor for objects of class Zombie.
     */
    public Player()
    {
        super("The Player", "Obviously I am I.");
        pack = new Pack();
    }
}