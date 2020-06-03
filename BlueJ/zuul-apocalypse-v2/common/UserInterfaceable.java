package common;

/**
 * Interface UserInterfaceable
 * Once enabled, will display text and change images in the GUI.
 *
 * @author Yuriel and Mo
 * @version 2020.06.03
 */
public interface UserInterfaceable {
//    void showCommands();
//    Command getCommand();
    
    /**
     * Displays text about the game in a JTextArea in the GUI.
     *
     * @param msg The text to be displayed.
     */
    void print(String text);
    
    /**
     * Changes the image displayed in the GUI.
     * 
     * @param fileName The name of the image file to be displayed.
     */
    void changeImage(String fileName);
    
    /**
     * Start the user interface for interaction with the user.
     *
     */
    void enable();
}
