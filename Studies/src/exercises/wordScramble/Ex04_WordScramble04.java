package exercises.wordScramble;

import java.util.Scanner;

public class Ex04_WordScramble04 {
    public static void main(String[] args) { 
        String[] strArr = { "BERLIN IS THE CAPITAL OF GERMANY", "BOSTON IS A CITY IN AMERICA", "ROME IS THE CRADLE OF WESTERN CIVILIZATION", "APPLE IS NOT A GOOD APPLE"}; 
        
        String answer = ""; 
        String question = ""; 

        Scanner scan = new Scanner(System.in);
        String input = "";
        
        // ����� �Է��� �޾Ƽ� 'q' or 'Q'�� �����ϰ�, �ƴϸ� ����ڰ� ���� ������ ���ѹݺ��Ѵ�
        // ����ڰ� ���� �Ŀ��� ������ ������ ���ο� ������ �����ش�
        while (true) {
        	answer = getAnswer(strArr);
        	question = getScrambledWord(answer);
        	char[] hint = new char[answer.length()];
        	
        	// hint�� "_"�� �ʱ�ȭ�Ѵ�. ������ LOVE��� hint�� "____"�� �ȴ�.
        	for(int i = 0; i < hint.length; i++) { hint[i] = '_'; }
        	
        	while(true) {
        		System.out.println("Question : " + question);
        		System.out.println("Your answer is : ");
        		System.out.println("Enter 'Q' to quit");
        		input = scan.nextLine();
        		if (input.equalsIgnoreCase("q")) {
        			System.out.println("Terminating...");
        			System.exit(0);
        		} else if (input.equalsIgnoreCase(answer)) {
        			System.out.println("Successful!!");
        			break;
        		} else {
        			System.out.println("Wrong answer... try again");
        			System.out.println("Hint : " + getHint(answer, hint));
        		}
        	} // inner while
        } // outer while
    } // main 

    // getAnswer(String[] strArr)�� �迭strArr�� ������� �ϳ��� ���Ƿ� ��� ��ȯ�Ѵ�
    public static String getAnswer(String[] strArr) { 
       int index = (int)(Math.random() * strArr.length);
       return strArr[index];
    }
    
    // getScrambledWord(String str)�� �־��� ���ڿ� str�� �� ������ ������ �ڼ��� ����, ���ο� ���ڿ��� ��ȯ�Ѵ�
    public static String getScrambledWord(String str) { 
        char[] scr = str.toCharArray();
        
        char temp;
        for(int i = 0; i < 10; i++) {
        	int r = (int)(Math.random() * scr.length);
        	temp = scr[0];
        	scr[0] = scr[r];
        	scr[r] = temp;
        }

        return new String(scr);
    } // scramble(String str) 
    
    public static String getHint(String answer, char[] hint) {
    	 int count = 0; // ��Ʈ�� ���Ե� '_'�� ����
    	 
    	 for(int i = 0; i < hint.length; i++) {
    		 if (hint[i] == '_') { count++; }
    	 }
    	 
    	 if (count > 2) {
    		 int r;
    		 do {
        		 r = (int)(Math.random() * hint.length); 
        	 } while (hint[r] != '_');
    		 hint[r] = answer.charAt(r);
    	 }

    	 return new String(hint);    	 
    } // getHint()
    
    
}