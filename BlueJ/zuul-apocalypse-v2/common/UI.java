package common;

/**
 * Interface UI
 * Once enabled, will display text and change images in the GUI.
 *
 * @author Yuriel
 * @version 2020.06.03.
 */
public interface UI
{
    /**
     * Displays text in a JTextArea in the GUI.
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