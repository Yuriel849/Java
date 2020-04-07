package exercises.byChapter.chapter_05;

import java.util.Scanner;

class Exercise05_12 {
	public static void main(String[] args) {
		String[][] words = {
				{"chair", "Stuhl"},    // words[0][0], words[0][1]
				{"dog", "Hund"}, 	   // words[1][0], words[1][1]
				{"integer", "Integer"} // words[2][0], words[2][1]
		};
		
		int cnt = 0; // Keeps count of how many times the user was correct
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < words.length; i++) {
			System.out.printf("Q%d. What is %s in German? ", i+1, words[i][0]);
			
			String tmp = scan.nextLine();
			
			if(tmp.equals(words[i][1])) {
				System.out.printf("You are correct%n%n");
				cnt++;
			} else {
				System.out.printf("Incorrect. You are wrong.%n%n", words[i][1]);
			}
		} // for loop
		
		System.out.printf("You got %d out of 3 correct.", cnt);
		
		scan.close();
	}
}