package implementation;

import java.util.Stack;
import java.awt.Image;
import javax.imageio.*;
import java.io.*;

import common.*;

/**
 * Class Player
 *
 * @author Yuriel and Mo
 * @version 2020.06.06
 */
public class Player extends Character {
    // A pack being carried by the player as an inventory (maximum 10 items).
    private Pack pack;
    // The room where the player is currently located.
    private Room currentRoom;
    // The Stack holding the previous states of the player.
    private Stack<Room> previousRooms;
    // The GUI of the game
    private UserInterfaceable gameInterface;
    
    /**
     * Default constructor for objects of class Player.
     */
    public Player(UserInterfaceable gameInterface) {
        super("The Player", "Obviously I am I.");
        
        this.gameInterface = gameInterface;
        
        pack = new Pack();
        previousRooms = new Stack<Room>();
    }
    
    /** 
     * The player moves in one direction. If there is an exit in that direction,
     * move to the new room; otherwise print an error message.
     */
    public String move(Command command) {
        int numberEnemies = 0;
        String result = "";
        
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            gameInterface.printLower("Go where?\n");
        }
        else {
            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = currentRoom.getExit(direction);
            if (nextRoom == null) {
                gameInterface.printLower("There is no door!\n");
            }
            else {
                // Save current room to previousStates stack
                previousRooms.push(currentRoom);
                currentRoom = nextRoom;
                gameInterface.changeImage(getImage("./images/" + currentRoom.getFilename() + ".jpg"));
                                
                numberEnemies = currentRoom.getAllZombies().size();
                if(numberEnemies != 0)
                {
                    gameInterface.printLower("Enemies encountered! There are" + numberEnemies +  "enemies. Starting battle...\n");
                    result = Battle.fight(this, gameInterface);
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
            gameInterface.printLower("There is no such object here!\n");
        }
        else if(pack.putInPack(target) != true)
        {
            gameInterface.printLower("Your pack is already full! You cannot add another item!\n");
        }
    }

    /**
     * Remove the designated item from the player's pack and put it back in the room.
     */
    public void leaveItem(Command command) {
        Item target = pack.getFromPack(command.getSecondWord());
        
        if(target == null)
        {
            gameInterface.printLower("Which object do you mean? I can't find it in the pack...\n");
        }
        else if(currentRoom.addToList(target) != true)
        {
            gameInterface.printLower("The room is already full. Your item was thrown away!\n");
        }
    }

    /**
     * The player goes back to the room(s) where he came from.
     */
    public void goBack(Command command) {
        // Field to hold the previous state of the player
        Room previousRoom;
        
        if (command.hasThirdWord()) {
            previousRoom = previousRooms.pop(); // Pop the last item on the previousStates stack.
            
            if (previousRooms.empty()) {
                gameInterface.printLower("You can't go back.\n");
            }
            else {
                currentRoom = previousRoom;
                gameInterface.changeImage(getImage("./images/" + currentRoom.getFilename() + ".jpg"));
                gameInterface.printUpper(currentRoom.getLongDescription());
            }
        }
        else if (command.hasSecondWord()) {
            previousRooms.pop(); // pop and throw previous room
            previousRoom = previousRooms.pop(); // Pop the last item on the previousStates stack.
            
            if (previousRooms.empty()) {
                gameInterface.printLower("You can't go back two rooms.\n");
            }
            else {
                currentRoom = previousRoom;
                gameInterface.changeImage(getImage("./images/" + currentRoom.getFilename() + ".jpg"));
                gameInterface.printUpper(currentRoom.getLongDescription());
            }
        }
        else {
            previousRooms.pop(); // pop and throw previous room
            previousRooms.pop(); // pop and throw previous room
            previousRoom = previousRooms.pop(); // Pop the last item on the previousStates stack.
            
            if (previousRooms.empty()) {
                gameInterface.printLower("You can't go back three rooms.\n");
            }
            else {
                currentRoom = previousRoom;
                gameInterface.changeImage(getImage("./images/" + currentRoom.getFilename() + ".jpg"));
                gameInterface.printUpper(currentRoom.getLongDescription());
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
    
    /**
     * Gets the Image object corresponding to the given file name (path).
     * 
     * @param filename The path of the image.
     * @return The image at the given path.
     */
    private Image getImage(String filename) {
        Image image = null;
        
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return image;
    }
}