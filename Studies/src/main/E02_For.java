package main;


public class E02_For {
	public static void main(String[] args) {		
		/* Desired console output
		 * 1	10 	  1	   1
		 * 2	 9	  1	   2
		 * 3	 8	  1	   3
		 * 4	 7	  2	   1
		 * 5	 6	  2	   2
		 * 6	 5	  2	   3
		 * 7	 4	  3	   1
		 * 8	 3 	  3	   2
		 * 9	 2	  3	   3
		 * 10	 1	  4	   1
		 */
		for(int i = 1, k = 0, j = 1; i <= 10; i++, k++) {
			System.out.printf("%d\t%d\t%d\t%d\n", i, 11-i, (i % 3 == 0) ? j++ : j, (i % 3 == 0) ? 3 : i % 3);
		}
		System.out.println();
		
		// Print the multiplication table
		for(int i = 2; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%-2dX%2d = %-4d", j, i, j*i);
			}
			System.out.println();
		}
	}
}