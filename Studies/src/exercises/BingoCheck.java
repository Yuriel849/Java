package exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BingoCheck {
	// Return the number of bingos in a two-dimensional array
	int bingoCheck(int[][] bingoArray) {		
		int num, row, col, leftD, rightD;
		num = row = col = leftD = rightD = 0;
		
		for(int i = 0; i < 5; i++, row = 0, col = 0) {
			for(int j = 0; j < 5; j++) {
				if (bingoArray[i][j] == 1) {
					row++;
					if (row == 5) { num++; } // 가로빙고 세기 끝.
				}
				if (bingoArray[j][i] == 1) {
					col++;
					if (col == 5) { num++; } // 세로빙고 세기 끝.
				}
				if (j == 0 && bingoArray[i][i] == 1) {
					leftD++;
					if (leftD == 5) { num++; }
				}
				if (j == 0 && bingoArray[i][4-i] == 1) {
					rightD++;
					if (rightD == 5) { num++; }
				}
			}
		}
		return num;
	}
		
//	int bingoCheck(int[][] arr) {
//		int gcnt = 0; // 가로 빙고를 센다
//		int scnt = 0; // 세로 빙고를 센다
//		int dcnt = 0;
//		int rcnt = 0;
//		int bingoCnt = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr.length; j++) {
//				if(arr[i][j] == 1) { gcnt++; }
//				if(arr[j][i] == 1) { scnt++; }
//				if(arr[i][j] == 1 && i == j) { dcnt++; }
//				if(arr[i][j] == 1 && i+j==4) { rcnt++; }
//			}
//			if(gcnt == 5) { bingoCnt++; }
//			if(scnt == 5) { bingoCnt++; }
//			if(dcnt == 5) {bingoCnt++; }
//			if(rcnt == 5) {bingoCnt++; }
//			gcnt = 0;
//			scnt = 0;
//		}
//
//		// 대각선 빙고 갯수를 센다.
//		int dcnt = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				if(arr[i][j] == 1 && i == j) { dcnt++; }
//			}
//		}
//		if(dcnt == 5) {bingoCnt++; }
//		
//		// 역대각선 빙고 갯수를 센다.
//		int rcnt = 0;
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				if(arr[i][j] == 1 && i+j==4) { rcnt++; }
//			}
//		}
//		if(rcnt == 5) {bingoCnt++; }
//		
//	return bingoCnt;
//	}

	@Test
	void test() {
		int[][] arr = {
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1}
		};
		
		assertTrue(bingoCheck(arr) == 12);
	}
	
	@Test
	void test2() {
		int[][] arr = {
				{1,1,1,1,1},
				{1,1,0,0,0},
				{1,0,1,0,0},
				{1,0,0,1,0},
				{1,0,0,0,1}
		};
		
		assertTrue(bingoCheck(arr) == 3);
	}
	
	@Test
	void test3() {
		int[][] arr = {
				{1,1,1,1,1},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
		};
		
		assertTrue(bingoCheck(arr) == 1);
	}
	
	@Test
	void test4() {
		int[][] arr = {
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,1,0,0},
				{1,0,0,1,0},
				{1,0,0,0,1}
		};
		
		assertTrue(bingoCheck(arr) == 1);
	}
}