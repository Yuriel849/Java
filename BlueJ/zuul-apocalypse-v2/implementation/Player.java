package implementation;

// import libraries
import java.util.Stack;
// import packages
import common.*;

/**
 * Class Player
 *
 * @author Yuriel and Mo
 * @version 2020.06.02
 */
public class Player extends Character {
    // A pack being carried by the player as an inventory (maximum 10 items).
    private Pack pack;
    // The room where the player is currently located.
    private Room currentRoom;
    // The Stack holding the previous states of the player.
    private Stack<Room> previousRooms;
    
    /**
     * Default constructor for objects of class Player.
     */
    public Player() {
        super("The Player", "Obviously I am I.");
        pack = new Pack();
        previousRooms = new Stack();
    }
    
    /** 
     * The player moves in one direction. If there is an exit in that direction,
     * move to the new room; otherwise print an error message.
     */
    public String move(Command command, UserInterfaceable parser) {
        int numberEnemies = 0;
        String result = "";
        
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
        }
        else {
            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = currentRoom.getExit(direction);
            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                // Save current room to previousStates stack
                previousRooms.push(currentRoom);
                currentRoom = nextRoom;
            
                if((numberEnemies = currentRoom.getAllZombies().size()) != 0)
                {
                    System.out.println("Enemies encountered! There are " + numberEnemies + " enemies. Starting battle...");
                    result = Battle.fight(this, parser);
                }
                else if(currentRoom.getIdCode() == 26)
                {
                    result = "winGame";
                }
            }
        }
        
        return result;
    }
    
    /**
     * Take the designated item from the room and put it in the player's pack (inventory).
     */
    public void takeItem(Command command) {
        Item target = currentRoom.takeItem(command.getSecondWord()); // Returns null if the designated item is not in the room.
        
        if(target == null)
        {
            System.out.println("There is no such object here!");
        }
        else if(pack.putInPack(target) != true)
        {
            System.out.println("Your pack is already full! You cannot add another item!");
        }
    }

    /**
     * Remove the designated item from the player's pack and put it back in the room.
     */
    public void leaveItem(Command command) {
        Item target = pack.getFromPack(command.getSecondWord());
        
        if(target == null)
        {
            System.out.println("Which object do you mean? I can't find it in the pack...");
        }
        else if(currentRoom.addToList(target) != true)
        {
            System.out.println("The room is already full. Your item was thrown away!");
        }
    }
    
    /**
     * Go back to the previous room
     *
     * @param command
     * @return
     */
    public void goBack(Command command) {
        // Field to hold the previous state of the player
        Room previousRoom;
        
        if (command.hasThirdWord()) {
            
            previousRoom = previousRooms.pop(); // Pop the last item on the previousStates stack.
            
            if (previousRooms.empty()) {
                System.out.println("You can't go back");
            }
            else {
                currentRoom = previousRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        else if (command.hasSecondWord()) {
            
            previousRooms.pop(); // pop and throw previous room
            previousRoom = previousRooms.pop(); // Pop the last item on the previousStates stack.
            
            if (previousRooms.empty()) {
                System.out.println("You can't go back two rooms.");
            }
            else {
                currentRoom = previousRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        else {

            previousRooms.pop(); // pop and throw previous room
            previousRooms.pop(); // pop and throw previous room
            previousRoom = previousRooms.pop(); // Pop the last item on the previousStates stack.
            
            if (previousRooms.empty()) {
                System.out.println("You can't go back three rooms.");
            }
            else {
                currentRoom = previousRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
    }
    
    /**
     * Return the size of the stack (the number of rooms the player has already moved through).
     * @return The size of the stack as an int.
     */
    public int getSizePreviousRooms() {
        return previousRooms.size();
    }
    
    /**
     * Return the room where the player is right now.
     * @return The current room.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * Set the room where the player is right now.
     * @param room The current room.
     */
    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }
}