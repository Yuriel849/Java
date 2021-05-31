import boundary.GUI;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        System.out.println("Example 1: Start auto cleaning mode");
        gui.chooseMode("auto");
        gui.start();
        gui.updateProgress();
        System.out.println();

        System.out.println("Example 2: Start room cleaning mode");
        gui = new GUI();
        gui.chooseCleanArea(); // Failure; must first choose cleaning mode
        gui.start();           // Failure; must first choose cleaning mode and area
        gui.chooseMode("room");
        gui.chooseCleanArea(); // Input "kitchen cleanup";
        gui.start();
        gui.updateProgress();

        System.out.println("Example 3: Start region cleaning mode");
        gui = new GUI();
        gui.chooseCleanArea(); // Failure; must first choose cleaning mode
        gui.start();           // Failure; must first choose cleaning mode and area
        gui.chooseMode("region");
        gui.chooseCleanArea(); // Input 1234.5678, 7897.3453, then "done" to quit
        gui.start();
        gui.updateProgress();
    }
}
