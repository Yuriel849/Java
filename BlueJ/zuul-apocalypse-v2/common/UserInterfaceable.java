package common;

import java.awt.Image;

/**
 * Interface UserInterfaceable
 * Once enabled, will display text and change images in the GUI.
 *
 * @author Yuriel and Mo
 * @version 2020.06.04
 */
public interface UserInterfaceable {
    /**
     * Gets valid commands from the GUI to be processed by the GameEngine.
     */
    Command getCommand();
    
    /**
     * Displays text about the game in the upper JTextArea in the GUI.
     *
     * @param msg The text to be displayed.
     */
    void printUpper(String text);

    /**
     * Displays text about the game in the lower JTextArea in the GUI.
     *
     * @param msg The text to be displayed.
     */
    void printLower(String text);    
    
    /**
     * Changes the image displayed in the GUI.
     * 
     * @param newImage The new Image object to be displayed.
     */
    void changeImage(Image newImage);
    
    /**
     * Start the user interface for interaction with the user.
     */
    void enable();
}
