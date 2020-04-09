package exercises.byChapter.chapter_08;

import java.util.InputMismatchException;
import java.util.Scanner;

class Exercise08_08 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int answer = (int)(Math.random() * 100) + 1; // Random int between 1 ~ 100
		int input = 0;
		int count = 0;
		
		do {
			count++;
			System.out.println("Type an integer between 1 and 100.");
			
			try {
				input = new Scanner(System.in).nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Please enter an integer between 1 and 100.");
				continue; // Continue the do-while loop
			}
			
			if(answer > input) {
				System.out.println("Your number is too low.");
			} else if(answer < input) {
				System.out.println("Your number is too high.");
			} else {
				System.out.println("Correct.");
				System.out.println("It took you " + count + " tries to guess correctly.");
				break; // Break the do-while loop
			}
		} while(true);
	}
}