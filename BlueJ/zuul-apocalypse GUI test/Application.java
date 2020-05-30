
/**
 * Class Application with the main method.
 *
 * @author Yuriel
 * @version 2020.05.30
 */
public class Application {
    private static PlayerGUI interact;
    
    public static void main(String[] args) {
        interact = new PlayerGUI();
        showInterface();
    }
    
    public static void showInterface()
    {
        interact.setVisible(true);
    }
}