package exercises.byChapter.chapter_05;

// Rotate the shape printed with asterisks 90-degrees clockwise

class Exercise05_09 {
	public static void main(String[] args) {
		char[][] star = {
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', '*', '*', '*'},
				{'*', '*', '*', '*', '*'},
		};
		
		char[][] result = new char[star[0].length][star.length];
		
		// Print the shape.
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		} // for loop
		
		System.out.println();
		
		// Rotate the shape clockwise by 90 degrees
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[i].length; j++) {
				result[j][star.length-(1+i)] = star[i][j];
			}
		} // for loop

		// Print the rotated shape
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		} // for loop
	}
}