/**
 * Demonstrate how to use the clientside.
 *
 * @author Divyesh Joshi
 * @author Myungjun Kim
 * @version 2021.06.11
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "Auto Mode";
        System.out.println("Example 1: "+s1);
        AppController mainCont1 = new AppController(s1);
        
        String s2 = "Pause";
        System.out.println("Example 2: "+s2);
        AppController mainCont2 = new AppController(s2);
        
        String s3 = "Return Home";
        System.out.println("Example 3: "+s3);
        AppController mainCont3 = new AppController(s3);
        
        String s4 = "abc";
        System.out.println("Example 4: "+s4);
        AppController mainCont4 = new AppController(s4);
    }
}