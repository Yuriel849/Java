package study;

import java.util.EmptyStackException;
import java.util.Stack;

public class Ex04_BracketValidCheck {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage : java Ex04_BracketValidCheck \"EXPRESSION\"");
			System.out.println("Example : java Ex04_BracketValidCheck \"((2+3)*1)+3\"");
			System.exit(0);
		}
		/* Ŀ�ǵ���� �Է��� eclipse���� �Ϸ���...
		 * 	>> "Run" >> "Run Configurations" >> "Arguments" >> "Program Arguments" >> "Apply" & "Run"
		 */
		
		Stack st = new Stack();
		String expression = args[0];
		
		System.out.println("expression : " + expression);
		
		try {
			for(int i = 0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				
				if(ch == '(') { st.push(ch+""); }
				else if(ch == ')') { st.pop(); }
			}
			
			if(st.isEmpty()) { System.out.println("��ȣ�� ��ġ�մϴ�."); }
			else { System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�."); }			
		} catch (EmptyStackException e) {
			System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.");
		} // try-catch�� ��.
	} // main() ��.
} // Ŭ���� ��.
