package exercises.byChapter.chapter_05;

import java.util.Scanner;

// Guess what the scrambled words are

class Exercise05_13 {
	public static void main(String[] args) {
		String[] words = { "television", "computer", "mouse", "phone" };

		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray(); // String.toCharArray();
			
			for(int j = 0; j < question.length; j++) {
				int k = (int)(Math.random() * question.length);
				char tmp = question[0];
				question[0] = question[k];
				question[k] = tmp;
			}
			
			System.out.printf("Q%d. What is this word : %s >>", i+1, new String(question));
			String answer = scan.nextLine();
			
			// Use String.trim() on the user input to remove whitespaces
			if(words[i].equals(answer.trim())) {
				System.out.printf("  Correct.%n%n");
			} else {
				System.out.printf("Incorrect.%n%n");
			}
		} // for loop
		
		scan.close();
	}
}