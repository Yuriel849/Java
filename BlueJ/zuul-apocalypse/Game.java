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
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
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
                temp.setDescription(i + "");
            }
            else if(i == 26)
            {
                temp = gameMap.get(26);
                temp.setDescription("elevator");
            }
            else if(i % 5 == 1)
            {
                temp = gameMap.get(i);
                temp.setExit("east", gameMap.get(i + 1));
                temp.setDescription(i + "");
            }
            else if((i % 5 == 2) || (i % 5 == 3) || (i % 5 == 4))
            {
                temp = gameMap.get(i);
                temp.setExit("east", gameMap.get(i + 1));
                temp.setExit("west", gameMap.get(i - 1));
                temp.setDescription(i + "");
            }
            else if(i % 5 == 0)
            {
                temp = gameMap.get(i);
                temp.setExit("west", gameMap.get(i - 1));
                temp.setDescription(i + "");
            }
            
            if(i == 1)
            {
                for(int j = 0; j < 5; j++)
                {
                    temp = gameMap.get(i + j);
                    temp.setExit("south", gameMap.get(i + j + 5));
                }
            }
            else if(i == 6 || i == 11 || i == 16)
            {
                for(int j = 0; j < 5; j++)
                {
                    temp = gameMap.get(i + j);
                    temp.setExit("north", gameMap.get(i + j - 5));
                    temp.setExit("south", gameMap.get(i + j + 5));
                }
            }
            else if(i == 21)
            {
                for(int j = 0; j < 5;j++)
                {
                    temp = gameMap.get(i + j);
                    temp.setExit("north", gameMap.get(i + j - 5));
                }
            }
        }
        
        currentRoom = gameMap.get(0);
        
        System.out.println(currentRoom.getLongDescription());

    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
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