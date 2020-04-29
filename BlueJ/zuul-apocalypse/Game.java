import java.util.ArrayList;

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
 * @author (Custom) Yuriel
 * @version (Custom) 2020.04.27
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Pack pack;
    
    private static final int maxItems = 5;
    private static final int maxZombies = 3;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        pack = new Pack();
    }

    /**
     * Create all the rooms and link their exits together, and randomly set a description for each room and add items to each room.
     * Each room will be randomly allocated up to five items and three zombies, with the exception of hallways, which will have only zombies.
     */
    private void createRooms()
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
        
        currentRoom = gameMap.get(0);
    }
    
    /**
     * Initialize descriptions for all the rooms.
     * @param gameMap The ArrayList holding all the rooms.
     */
    private void setDescriptions(ArrayList<Room> gameMap)
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
    private void populateRooms(ArrayList<Room> gameMap)
    {
        // A constant array that holds all valid item descriptions
        final String[] names = {
            "gun", "round", "medpack"
        };
        final String[] descriptions = {
            "a weapon to kill someone or something", "ammunition for your gun", "item so you can recover health"
        };
        
        int itemCounter = 30, zombieCounter = 60, index = -1;
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

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop. Here we repeatedly read commands and execute them until the game is over.
        boolean finished = false;
        while(!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("take")) {
            takeItem(command);
        }
        else if (commandWord.equals("remove")) {
            removeItem(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    /**
     * Take the designated item from the room and put it in the player's pack (inventory).
     */
    private void takeItem(Command command)
    {
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
     * Remove the designated item from the pack and put it back in the room.
     */
    private void removeItem(Command command)
    {
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
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}