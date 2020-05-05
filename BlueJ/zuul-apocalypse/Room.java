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
 * @author (Original) Michael Kölling and David J. Barnes
 * @version (Original) 2016.02.29
 * 
 * @author (Custom) Yuriel
 * @version (Custom) 2020.05.05
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
        description = null;
        this.identificationCode = identificationCode;
        exits = new HashMap<>();
        items = new ArrayList<>();
        zombies = new ArrayList<>();
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
    
    public int getIdCode()
    {
        return identificationCode;
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
        return "You are in a " + description + getAllString() + ".\n" + getExitString();
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

    /**
     * Return a string describing the items and zombies in the room, in the form of "Items: gun food \n Zombies: two walkers".
     * @return Details of the items and zombies in the room.
     */
    private String getAllString()
    {
        String returnString = "";
        
        if(items.size() > 0)
        {
            returnString += "\nItems:";

            for(Item item : items)
            {
                returnString += " " + item.getName();
            }
        }
        
        if(zombies.size() > 0)
        {
            returnString += "\nZombies:";

            for(Zombie zombie : zombies) {
                returnString += " " + zombie.getName();
            }
        }
        
        return returnString;
    }
    
    /**
     * Get an item in the room and return it. The taken item is removed from the room.
     * @param name The name of the item to be retrieved.
     * @return The desired item taken from the room.
     */
    public Item takeItem(String name)
    {
        Item result = null, temp = null;
        
        Iterator<Item> iterator = items.iterator();
        while(iterator.hasNext())
        {
            temp = iterator.next();
            
            if(temp.getName().equals(name))
            {
                result = temp;
                iterator.remove();
                break;
            }            
        }
        
        return result;
    }
    
    /**
     * Get the list of all zombies in the room.
     * @return The list of all zombies in the room.
     */
    public ArrayList<Zombie> getAllZombies()
    {
        return zombies;
    }
    
    /**
     * Get a zombie from the room and return it. The returned zombie is not removed from the room.
     * @param name The name of the zombie to be returned. The first occurrence of a zombie with the designated name is returned.
     * @return The zombie in the room that is returned.
     */
    public Zombie getZombie(String name)
    {
        Zombie result = null;
        
        for(Zombie zombie : zombies)
        {
            if(zombie.getName().equals(name))
            {
                result = zombie;
                break;
            }
        }
        
        return result;
    }
    
    /**
     * Remove a specific zombie from the room.
     * @param toRemove The specific Zombie type object to be removed. The zombie to be removed must be one of the zombies that are in that room.
     *                 Nothing is done if the zombie to be removed is not among the zombies in the room.
     */
    public void removeZombie(Zombie toRemove)
    {
        Zombie temp = null;
        
        Iterator<Zombie> iterator = zombies.iterator();
        while(iterator.hasNext())
        {
            temp = iterator.next();
            
            if(temp == toRemove)
            {
                iterator.remove();
                break;
            }            
        }
    }
}