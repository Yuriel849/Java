package exercises;

import java.util.Scanner;

// BingoScanner used by BingoUpdate

public class BingoScanner {
	public static int main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		do {
			System.out.println("Enter one number between 1 and 25 >>");
			System.out.print("Enter a negative number to quit.");
			
			input = scan.nextInt();

			if (input < 0) {
				System.out.println("Quitting.");
				break;
			}
		} while (input < 1 || input > 25);
	
		scan.close();
		
		return input;
	}
}