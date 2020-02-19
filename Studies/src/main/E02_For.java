package main;

public class E02_For {
	public static void main(String[] args) {		
		int i, j, k;
		
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
		for(i = 1, k = 0, j = 1; i <= 10; i++, k++) {
			System.out.printf("%d\t%d\t%d\t%d\n", i, 11-i, (i % 3 == 0) ? j++ : j, (i % 3 == 0) ? 3 : i % 3);
		}
		System.out.println();
		
		// Print the multiplication table
		for(i = 2; i <= 9; i++) {
			for(j = 2; j <= 9; j++) {
				System.out.printf("%-2dX%2d = %-4d", j, i, j*i);
			}
			System.out.println();
		}

		System.out.println(" 1번 : 별 5개씩 5줄 출력하기");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				System.out.print(" * ");	
			}
			System.out.println();
		}

		System.out.println("\n 2번 : 왼쪽에서 오른쪽으로 열 이동하면서 별 1개씩 출력하기");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (i == j) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}

		System.out.println("\n 3번 : 오른쪽에서 왼쪽으로 열 이동하면서 별 1개씩 출력하기");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (i + j == 6) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}

		System.out.println("\n 4번 : 별로 X자 만들어 출력하기");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (j == i || j + i == 6) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}

		System.out.println("\n 5번 : 왼쪽에서 오른쪽으로 내리막길");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (i >= j) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}

		System.out.println("\n 6번 : 왼쪽에서 오른쪽으로 낮아지는 지붕");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (j < i) {
					System.out.print("   ");
				} else {
					System.out.print(" * ");
				}
			}
			System.out.println();
		}
		
		/*
		 *  ******	   --> 1행   6개
		 *  *******	   --> 2행   7개
		 *  ********   --> 3행   8개
		 *  *********  --> 4행   9개
		 *  ********** --> 5행 10개
		 */
		System.out.println("\n 7번 : 5X5판 + 5번");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= i+5; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println("\n 8번 : 피라미드 방법 01");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= i+4; j++) {
				if(i + j >= 6) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}		

		System.out.println("\n 8번 : 피라미드 방법 02");
		for(i = 1, k = 4; i <= 5; i++, k--) {
			for(j = 1; j <= 9; j++) {
				if (j <= k || j > (9-k)) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		
		System.out.println("\n 9번 : 방법 01");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (i > j && i + j > 6) {
					System.out.print("   ");
				} else if (i < j && i + j < 6) {
					System.out.print("   ");
				} else {
					System.out.print(" * ");
				}
			}
			System.out.println();
		}
		
		System.out.println("\n 9번 : 방법 02");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (i >= j && i + j <= 6) {
					System.out.print(" * ");
				} else if (i <= j && i + j >= 6) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
		
		System.out.println("\n 9번 : 방법 03");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (!((i + j < 6 && i < j) || (i > j && i + j > 6))) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
				
			}
			System.out.println();
		}

		System.out.println("\n10번 : 방법 01 ");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if (i >= j && i + j >= 6) {
					System.out.print(" * ");
				} else if (i <= j && i + j <= 6) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
				
			}
			System.out.println();
		}
		
		System.out.println("\n10번 : 방법 02 ");
		for(i = 1; i <= 5; i++) {
			for(j = 1; j <= 5; j++) {
				if ((i + j <= 6 && i <= j) || (i >= j && i+j >= 6)) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
				
			}
			System.out.println();
		}
	}
}