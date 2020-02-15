package exercises;

import exercises.BingoScanner;

public class BingoUpdate {
	public static void main(String[] args) {
		int[][] array = new int[5][5];
		
		initializeBingoArray(array);
		
		shuffleBingoArray(array);
		
		System.out.println("5 X 5 two-dimensional array : ");
		printBingoArray(array);
		System.out.println(); // Linebreak
		
		int input = BingoScanner.main(null);
		 
		search : for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == input) {
					array[i][j] = 0;
					break search;
				}
			}
		}
		
		printBingoArray(array);
	}
	
	private static void printBingoArray(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void initializeBingoArray(int[][] array) {
		int add = 1;
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array [i][j] = add;
				add++;
			}
		}
	}
	
	private static void shuffleBingoArray(int[][] array)
	{
		int a = 0, b = 0, temp = 0;
		
		for(int i = 0; i < 100; i++) {
			a = (int) (Math.random() * 5);
			b = (int) (Math.random() * 5);
			
			temp = array[0][0];
			array[0][0] = array[a][b];
			array[a][b] = temp;
		}
	}
}