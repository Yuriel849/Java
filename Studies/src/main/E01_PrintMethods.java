package main;

public class E01_PrintMethods {
	public static void main(String args[]) { // Check scope by double-clicking on curly brackets
		// "sysout" then ctrl + space --> System.out.println();
		System.out.println();

		/* Move to line and type ctrl + "/" --> Comment or de-comment the line
		 * ctrl + "+" & ctrl + "-" --> Increase and decrease text size in Eclipse/Spring STS
		 * Move to line and type ctrl + "D" --> Delete the current line
		 * Move to line and type alt + arrow key --> Move the current line up or down
		 */
		
		// Java's standard output methods --> print(), println(), printf()
		
		// 1. print() - no linebreak
		// Hello Java !!!
		System.out.print("1. Hello");
		System.out.print(" Java !!!\n");
				
		// 2. println() - auto-linebreak
		System.out.println("2. Hello");
		System.out.println("Java !!!");
		
		// 3. printf - output to console with formatting, no linebreak (may use "%n" instead of "\n")
		System.out.printf("\n3. %s 과목은 %d 점입니다.", "\"국어\"", 100);
		System.out.printf("%n4. %s 과목은 %d 점입니다.\n", "\"영어\"", 200);
		System.out.printf("%n5. %-5s 과목은 %-+5d 점입니다.%n", 888, -200); // %s - may receive non-Strings, will convert automatically into Strings
	}	
}