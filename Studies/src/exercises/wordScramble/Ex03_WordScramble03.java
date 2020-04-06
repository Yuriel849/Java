package exercises.wordScramble;

import java.util.Scanner;

public class Ex03_WordScramble03 {
    public static void main(String[] args) { 
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 
        
        String answer = ""; 
        String question = ""; 

        Scanner scan = new Scanner(System.in);
        String input = "";
        
        // ����� �Է��� �޾Ƽ� 'q' or 'Q'�� �����ϰ�, �ƴϸ� ����ڰ� ���� ������ ���ѹݺ��Ѵ�
        // ����ڰ� ���� �Ŀ��� ������ ������ ���ο� ������ �����ش�
        loop : while (true) {
        	answer = getAnswer(strArr);
        	question = getScrambledWord(answer);
        	
        	while(true) {
        		System.out.println("Question : " + question);
        		System.out.println("Your answer is : ");
        		System.out.println("Enter 'Q' to quit");
        		input = scan.next();
        		if (input.equalsIgnoreCase("q")) {
        			System.out.println("Terminating...");
        			break loop;
        		} else if (input.equalsIgnoreCase(answer)) {
        			System.out.println("Successful!!");
        			break;
        		} else {
        			System.out.println("Wrong answer... try again");
        		}
        	} // inner while
        } // outer while
        scan.close();
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
}