
/**
 * Class Application with the main method.
 *
 * @author Yuriel
 * @version 2020.05.31
 */
public class Application {
    private static PlayerGUI interact;
    
    public static void main(String[] args) {
        interact = new PlayerGUI();
        showInterface();
    }
    
    private static void showInterface()
    {
        interact.setVisible(true);
    }
}