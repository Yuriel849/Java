package implementation;
// import libraries
import java.util.ArrayList;
// import Packages
import common.*;

/**
 * Write a description of class GameEngine here.
 *
 * @author Mo
 * @version 2020.06.02
 */
public class GameEngine {
    private Player player;
    private ArrayList<Room> gameMap;
    private UserInterfaceable gameInterface;
    private boolean finished;
    
    // Time challenge variables
    private static long typingStartTime;
    private static long typingEndTime;
    private static int typingCounter;
    private static long typingDuration;
    
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine(Player player, ArrayList<Room> gameMap,UserInterfaceable gameInterface) {
       this.player = player;
       this.gameMap = gameMap;
       this.gameInterface = gameInterface;
       
       typingStartTime = 0;
       typingCounter = 0;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {            
        boolean finishedTypingChallenge;
        printWelcome();
        
        finishedTypingChallenge = false;
        finished = false;
        
        // Start typing challenge
        System.out.println("You are now restrained to the bed and need to type \"break\" as fast as possible to break free");
        while(!finishedTypingChallenge) {
            Command command = gameInterface.getCommand(); // get command from parser
            finishedTypingChallenge = processCommandStartChallenge(command); // process command according to typing challenge
        }
        
        // Main gameplay
        // Enter the main command loop. Here we repeatedly read commands and execute them until the game is over.
        if (!finished) {
            System.out.println();
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
        
        while(!finished) {
            Command command = gameInterface.getCommand();
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
        System.out.println("......harsh white light pierces your eyes as you struggle out of a deep slumber.");
        System.out.println("...what happened? ...where am I? ...who am I?");
        System.out.println("Turning your head, you find a memo on the bed next to your head.");
        System.out.println("Do you want to read it? Type 'read' or just leave with the command 'go out'.");
        System.out.println();
        System.out.println("<Type 'help' if you need help>");
        System.out.println("P.S. Do not type help if you can help it. There's no help for you in this hell.");
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
        if (commandWord.equals("read")) {
            readMemo();
            player.move(new Command("go", "out", ""), gameInterface);
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
        else if (player.getCurrentRoom().getIdCode() == 0 && commandWord.equals("go")) {
            quickDeath();
            wantToQuit = true;
        }
        else if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go") || commandWord.equals("run")) {
            String result = player.move(command, gameInterface);
            
            if(result.equals("back"))
            {
                player.goBack(new Command("back", "", "")); // Go back to the previous room.
            }
            else if(result.equals("dead"))
            {
                wantToQuit = true;
            }
            else if(result.equals("winGame"))
            {
                winGame();
                wantToQuit = true;
            }
            else
            {
                System.out.println(player.getCurrentRoom().getLongDescription());
            }
        }
        else if (commandWord.equals("take")) {
            player.takeItem(command);
        }
        else if (commandWord.equals("leave")) {
            player.leaveItem(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("back")) {
            player.goBack(command);
        }
        // else command not recognised.
        return wantToQuit;
    }
    
    /**
     * Given a command, process (that is: execute) the command for the starting challenge.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommandStartChallenge(Command command) 
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
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
            finished = wantToQuit;
        }
        else if (commandWord.equals("break")) {
            if (typingCounter == 0) {
                typingStartTime = System.currentTimeMillis();
                typingCounter++;
            }
            else if (typingCounter == 1) {
                typingCounter++;
            }
            else if (typingCounter == 2) {
                typingEndTime = System.currentTimeMillis();
                typingDuration = typingEndTime - typingStartTime;
                if (typingDuration > 4100) {
                    System.out.println("You failed :(. You need to try again to start moving");
                    typingStartTime = 0;
                    typingCounter = 0;
                }
                else {
                    System.out.println("You broke free! You can now start moving");
                    return true;
                }
            }
        }
        // else command not recognised.
        return wantToQuit;
    }
    
    /**
     * Read the memo before leaving the first room.
     */
    private void readMemo()
    {
        System.out.println("Memo read.");
        System.out.println("You pick up the gun and step out the door.");
    }
    
    /**
     * Leave the first room without reading the memo, and die immediately.
     */
    private void quickDeath()
    {
        System.out.println("You rush out the door, desperate to find what is this place and why you are here. There has to be some— ");
        System.out.println("Something grabs your shoulder and spins you around. You catch a glimpse of a grotesque face before it flashes towards your throat— ");
        System.out.println();
        System.out.println("GAME OVER");
        System.out.println();
        System.out.println("......well, that was stupid. Try again?");
    }
    
    /**
     * Reach the elevator and win the game.
     */
    private void winGame()
    {
        System.out.println("You're finally here... you reached the elevators...");
        System.out.println();
        System.out.println("......what? Were you expecting something? Congratulations. You've survived, unfortunately. Yeah~~~~~!!");
        System.out.println("Play again if you want to.");
    }
    
    /**
     * Print out some help information, and a list of the command words the player can use.
     */
    private void printHelp() 
    {
        System.out.println("Who am I? Where am I? What is going on here?");
        System.out.println("......you have no choice but to follow the instructions on the note.");
        System.out.println("You have to find the way out. Find the elevators.");
        System.out.println();
        System.out.println("Valid command words are: ");
        gameInterface.showCommands();
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private static boolean quit(Command command) 
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
