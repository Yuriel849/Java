package implementation;

import java.util.ArrayList;
import java.util.HashMap;

import common.*;

/**
 * Write a description of class GameEngine here.
 *
 * @author Mo and Yuriel
 * @version 2020.06.06
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
    
    private static final HashMap<String, String> outputMessages = new HashMap<String, String>();
    
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine(Player player, ArrayList<Room> gameMap,UserInterfaceable gameInterface) {
       // Initialize outMessages array
       initOutputMessages();
       
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
        gameInterface.enable();
        boolean finishedTypingChallenge;
        gameInterface.printLower(outputMessages.get("welcome"));
        
        finishedTypingChallenge = false;
        finished = false;
        
        // Start typing challenge
        //gameInterface.printLower("You are now restrained to the bed and need to type \"break\" as fast as possible to break free\n");
        //while(!finishedTypingChallenge) {
        //    Command command = gameInterface.getCommand(); // get command from UI
        //    finishedTypingChallenge = processCommandStartChallenge(command); // process command according to typing challenge
        //}
        
        // Main gameplay
        // Enter the main command loop. Here we repeatedly read commands and execute them until the game is over.
        if (!finished) {
            gameInterface.printUpper(player.getCurrentRoom().getLongDescription());
        }
        
        while(!finished) {
            Command command = gameInterface.getCommand();
            finished = processCommand(command);
        }
        gameInterface.printLower(outputMessages.get("bye"));
    }
 
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        String commandWord = command.getCommandWord();
        
        if (command.isUnknown()) {
            return false;
        }
        else if (commandWord.equals("UNKW")) {
            gameInterface.printLower(outputMessages.get("unknownCommand"));
            return false;
        }
        else if (commandWord.equals("read")) {
            gameInterface.printLower(outputMessages.get("memo"));
            player.move(new Command("go", "out", ""));
            gameInterface.printUpper(player.getCurrentRoom().getLongDescription());
        }
        else if (player.getCurrentRoom().getIdCode() == 0 && commandWord.equals("go")) {
            gameInterface.printLower(outputMessages.get("quickDeath"));
            wantToQuit = true;
        }
        else if (commandWord.equals("help")) {
            gameInterface.printLower(outputMessages.get("help"));
        }
        else if (commandWord.equals("go") || commandWord.equals("run")) {
            String result = player.move(command);
            
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
                gameInterface.printLower(outputMessages.get("win"));
                wantToQuit = true;
            }
            else
            {
                gameInterface.printUpper(player.getCurrentRoom().getLongDescription());
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
        final Command emptyCommand = new Command(null, null, null);
        boolean wantToQuit = false;

        if(command.equals(emptyCommand)) {
            return false;
        }
        else if(command.isUnknown()) {
            System.out.println();
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            gameInterface.printLower(outputMessages.get("help"));
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
                    System.out.println("You failed :( You need to try again to start moving.\n");
                    typingStartTime = 0;
                    typingCounter = 0;
                }
                else {
                    System.out.println("You broke free! You can now start moving.\n");
                    return true;
                }
            }
        }
        // else command not recognised.
        return wantToQuit;
    }
    
    
    /** 
     * "Quit" was entered. Check the rest of the command to see whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            gameInterface.printUpper("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /**
     * Print out the opening message for the player.
     */
    private void initOutputMessages() {
        outputMessages.put("welcome", String.format("%s%s%s%s%s%s%s%s"
                                    , "\n"
                                    , "......harsh white light pierces your eyes as you struggle out of a deep slumber.\n"
                                    , "...what happened? ...where am I? ...who am I?\n"
                                    , "Turning your head, you find a memo on the bed next to your head.\n"
                                    , "Do you want to read it? Type 'read' or just leave with the command 'go out'.\n"
                                    , "\n"
                                    , "<Type 'help' if you need help>\n"
                                    , "P.S. Do not type help if you can help it. There's no help for you in this hell.\n"
                                    )
                           );
        outputMessages.put("memo", String.format("%s%s"
                                    , "Memo read."
                                    , "You pick up the gun and step out the door."
                                    )
                           );
        outputMessages.put("quickDeath", String.format("%s%s%s%s%s%s"
                                    , "You rush out the door, desperate to find what is this place and why you are here. There has to be some— \n"
                                    , "Something grabs your shoulder and spins you around. You catch a glimpse of a grotesque face before it flashes towards your throat— \n"
                                    , "\n"
                                    , "GAME OVER\n"
                                    , "\n"
                                    , "......well, that was stupid. Try again?\n"
                                    )
                           );        
        outputMessages.put("win", String.format("%s%s%s%s"
                                    , "You're finally here... you reached the elevators... \n"
                                    , "\n"
                                    , "......what? Were you expecting something? Congratulations. You've survived, unfortunately. Yeah~~~~~!!\n"
                                    , "Play again if you want to.\n"
                                    )
                           );      
        outputMessages.put("help", String.format("%s%s%s%s%s%s"
                                    , "Who am I? Where am I? What is going on here? \n"
                                    , "......you have no choice but to follow the instructions on the note.\n"
                                    , "You have to find the way out. Find the elevators.\n"
                                    , "\n"
                                    , "Valid command words are: \n"
                                    , Command.returnAll()
                                    )
                           );
        outputMessages.put("unknownCommand", "I don't know what you mean..\n");
        outputMessages.put("bye", "\nThank you for playing.  Good bye.");
    }
}
