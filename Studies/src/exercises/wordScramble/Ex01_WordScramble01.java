package exercises.wordScramble;

public class Ex01_WordScramble01 {
    public static void main(String[] args) { 
        String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 

        String answer = getAnswer(strArr); 
        String question = getScrambledWord(answer); 

        System.out.println("Question:"+question); 
        System.out.println("Answer:"+answer); 
  } // main 

    // getAnswer(String[] strArr)�� �迭strArr�� ������� �ϳ��� ���Ƿ� ��� ��ȯ�Ѵ�
    public static String getAnswer(String[] strArr) { 
       String str[] = strArr;
       int index = (int)(Math.random() * str.length);
       return str[index];
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