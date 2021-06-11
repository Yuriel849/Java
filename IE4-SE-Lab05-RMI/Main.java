
/**
 * Example class to show different options.
 *
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class Main
{
    
    public static void main(String[] args)
    {
        String s1 = "Auto Mode";
        System.out.println("Example 1: "+s1);
        MainController mainCont1 = new MainController(s1);
        
        String s2 = "Pause";
        System.out.println("Example 2: "+s2);
        MainController mainCont2 = new MainController(s2);
        
        String s3 = "Return Home";
        System.out.println("Example 3: "+s3);
        MainController mainCont3 = new MainController(s3);
        
        String s4 = "abc";
        System.out.println("Example 4: "+s4);
        MainController mainCont4 = new MainController(s4);
        
    }
}
