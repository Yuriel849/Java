import java.util.ArrayList;

import implementation.*;
import common.*;
import client.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author (Original) Michael Kölling and David J. Barnes
 * @version (Original) 2016.02.29
 * 
 * @author (Custom) Yuriel and Mo
 * @version (Custom) 2020.06.06
 */

public class Game {   
    private static Player player;
    private static ArrayList<Room> gameMap;
    private static UserInterfaceable gameInterface;
    private static GameEngine gameEngine;
   
    private static final int maxItems = 5;
    private static final int maxZombies = 3;

    /**
     * Create the game and initialize its internal map.
     */
    public static void main(String[] args) 
    {
        gameInterface = new GameUI();
        player = new Player(gameInterface); // Must first instantiate the GameUI!
        createRooms();
        
        gameEngine = new GameEngine(player, gameMap, gameInterface);
        gameEngine.play();
    }

    /**
     * Create all the rooms and link their exits together, and randomly set a description for each room and add items to each room.
     * Each room will be randomly allocated up to five items and three zombies, with the exception of hallways, which will have only zombies.
     */
    private static void createRooms()
    {
        ArrayList<Room> gameMap = new ArrayList<>();
        Room temp;

        // 5x5 sized map with two extra rooms for the start and end
        for(int i = 0; i < 27; i++)
        {
            gameMap.add(new Room(i));
        }

        // Connect the rooms together into the desired map
        for(int i = 0; i < 27; i++)
        {
            if(i == 0)
            {
                temp = gameMap.get(0);
                temp.setExit("out", gameMap.get(1));
                temp.setDescription("starting room");
            }
            else if(i == 25)
            {
                temp = gameMap.get(25);
                temp.setExit("out", gameMap.get(26));
            }
            else if(i == 26)
            {
                temp = gameMap.get(26);
                temp.setDescription("elevator");
            }
            
            if(i == 1 || i == 6 || i == 11 || i == 16 || i == 21)
            {
                for(int j = 0; j < 4; j++)
                {
                    temp = gameMap.get(i + j);
                    temp.setExit("east", gameMap.get(i + j + 1));
                }
            }
            else if(i == 5 || i == 10 || i == 15 || i == 20 || i == 25)
            {
                for(int j = 3; j>= 0; j--)
                {
                    temp = gameMap.get(i - j);
                    temp.setExit("west", gameMap.get(i - j - 1));
                }
            }
            
            if(i == 1 || i == 6 || i == 11 || i == 16)
            {
                for(int j = 0; j < 5; j++)
                {
                    temp = gameMap.get(i + j);
                    temp.setExit("south", gameMap.get(i + j + 5));
                }
            }
            if(i == 6 || i == 11 || i == 16 || i == 21)
            {
                for(int j = 0; j < 5;j++)
                {
                    temp = gameMap.get(i + j);
                    temp.setExit("north", gameMap.get(i + j - 5));
                }
            }
        }
        
        setDescriptions(gameMap);
        populateRooms(gameMap);
        
        player.setCurrentRoom(gameMap.get(0));
    }
    
    /**
     * Initialize descriptions for all the rooms.
     * @param gameMap The ArrayList holding all the rooms.
     */
    private static void setDescriptions(ArrayList<Room> gameMap)
    {
        // A constant array that holds all valid Room descriptions
        final String[] descriptions = {
            "laboratory", "security station", "storeroom", "control room", "mechanical room", "hallway"
        };
        
        int counter = 9; // Set 9 Rooms as hallways (Route from the starting room to the end room)
        
        // Designate hallways
        gameMap.get(1).setDescription(descriptions[5]);
        gameMap.get(2).setDescription(descriptions[5]);
        gameMap.get(7).setDescription(descriptions[5]);
        gameMap.get(8).setDescription(descriptions[5]);
        gameMap.get(13).setDescription(descriptions[5]);
        gameMap.get(18).setDescription(descriptions[5]);
        gameMap.get(19).setDescription(descriptions[5]);
        gameMap.get(24).setDescription(descriptions[5]);
        gameMap.get(25).setDescription(descriptions[5]);
        
        // Randomly set descriptions for the Rooms, unless it already has a description (hallways already have descriptions)
        while(counter != 25)
        {
            int randomRoom = (int)(Math.random() * 25) + 1;
            int randomDescription = (int)(Math.random() * 5);
            Room temp = gameMap.get(randomRoom);
            
            if(temp.getShortDescription() == null)
            {
                temp.setDescription(descriptions[randomDescription]);
                counter++;
            }
        }
    }
    
    /**
     * Create random items and zombies and randomly put the items and zombies in different rooms.
     * Each room may hold a maximum of five items and/or three zombies.
     * Hallways may hold only zombies.
     * @param gameMap The ArrayList holding all the rooms.
     */
    private static void populateRooms(ArrayList<Room> gameMap)
    {
        // A constant array that holds all valid item descriptions
        final String[] names = {
            "gun", "round", "medpack"
        };
        final String[] descriptions = {
            "a weapon to kill someone or something", "ammunition for your gun", "item so you can recover health"
        };
        
        int itemCounter = 20, zombieCounter = 25, index = -1;
        Room temp = null;
        
        while(itemCounter-- != 0)
        {
            temp = gameMap.get((int) (Math.random() * 25) + 1);
            if(temp.getShortDescription().equals("hallway")) // No items are put in rooms described as "hallway"
            {
                itemCounter++;
                continue;
            }
            
            index = (int) (Math.random() * 3);
            temp.addToList(new Item(names[index], descriptions[index]));
        }
        
        while(zombieCounter-- != 0)
        {
            gameMap.get((int) (Math.random() * 25) + 1).addToList(new Zombie()); // Add new Zombie object to a randomly selected room
        }
    }
}