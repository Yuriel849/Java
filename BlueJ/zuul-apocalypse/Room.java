import java.util.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;             // String description of this room.
    private int identificationCode;         // Identification code to differentiate different Room type objects.
    private HashMap<String, Room> exits;    // Stores exits of this room.
    private ArrayList<Item> items;          // Stores the items put in this room. Maximum 5 items per room.
    private ArrayList<Zombie> zombies;      // Stores the zombies in this room. Maximum 3 zombies per room.

    /**
     * Create a room with no description and the designated ID code. Initially there are no exits.
     * @param identificationCode The room's ID code, a two-digit number.
     */
    public Room(int identificationCode)
    {
        this(null, identificationCode);
    }
    
    /**
     * Create a room with the desginated description and ID code. Initially, there are no exits.
     * The "description" is something like "a kitchen" or "an open court yard".
     * @param description The room's description.
     * @param identificationCode The room's ID code, a two-digit number.
     */
    public Room(String description, int identificationCode)
    {
        this.description = description;
        this.identificationCode = identificationCode;
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room along with which room the exit leads to.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Return a string describing the room's exits, in the form of "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in the designated direction.
     * If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
        /**
     * Define the description of this room.
     * @param description The description for this room.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Get the description of the room.
     * @return The short description of the room.
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form of:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    
    /**
     * Add an item to the room. The maximum number of items in a room is 5. If there are already 5 items in the room, no more items will be added.
     * @param item The item to put in the room.
     * @return True, if the item was successfully added to the room. False, if the limit was reached and the item was not added.
     */
    public boolean addToList(Item item)
    {
        boolean result = false;
        
        if(items.size() < 5)
        {
            items.add(item);
            result = true;
        }
        
        return result;
    }

    /**
     * Add a zombie to the room. The maximum number of zombies in a room is 3. If there are already 3 zombies in the room, no more zombies will be added.
     * @param zombie The zombie to put in the room.
     * @return True, if the zombie was successfully added to the room. False, if the limit was reached and the zombie was not added.
     */
    public boolean addToList(Zombie zombie)
    {
        boolean result = false;
        
        if(zombies.size() < 3)
        {
            zombies.add(zombie);
            result = true;
        }
        
        return result;
    }
        
    // get all items (list)
    // get and remove item from items
}