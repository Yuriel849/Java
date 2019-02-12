package study;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ex02_BingoCheckTest01 {
	/* 2���� �迭�� �޾Ƽ� bingo�� ������ ���� ��ȯ
	 * �޼��� �̸� : bingoCheck
	 * �Ű�����(�Է�) : 2���� int �迭
	 * ��ȯ�� : bingo�� ����
	 */

	int bingoCheck(int[][] arr) {
		int[][] bingo = arr;
		
		int num = 0;
		
		// 1st --> ��, ��, �밢�� 2���� ���� ���� Ȯ���ϴ� �ڵ� �ۼ�
//		// check left-top --> right-bottom bingo
//		for(int i = 0; i < 5; i++) {
//			if(bingo[i][i] != 0) { check1++; } 
//		}
//		if (check1 == 5) { num++; }
//		
//		// check left-bottom --> right-top bingo
//		for(int i = 0; i < 5; i++) {
//			if(bingo[i][4-i] != 0) { check2++; } 
//		}
//		if (check2 == 5) { num++; }
//		
//		// check rows for bingo
//		for(int i = 0; i < 5; i++) {
//			if(bingo[i][0] == 1 && bingo[i][1] == 1 && bingo[i][2] == 1 && bingo[i][3] == 1 && bingo[i][4] == 1) {
//				num++;
//			}
//		}
//		
//		// check columns for bingo
//		for(int i = 0; i < 5; i++) {
//			if(bingo[0][i] == 1 && bingo[1][i] == 1 && bingo[2][i] == 1 && bingo[3][i] == 1 && bingo[4][i] == 1) {
//				num++;
//			}
//		}
		
		// 2nd --> ���� �ڵ� �ۼ� �� ��ġ��
		// ��� 01 >>
//		for(int i = 0; i < 5; i++) {
//			if(bingo[i][0] == 1 && bingo[i][1] == 1 && bingo[i][2] == 1 && bingo[i][3] == 1 && bingo[i][4] == 1) {
//				num++;
//			}
//			if(bingo[0][i] == 1 && bingo[1][i] == 1 && bingo[2][i] == 1 && bingo[3][i] == 1 && bingo[4][i] == 1) {
//				num++;
//			}
//		}
//		if(bingo[0][0] == 1 && bingo[1][1] == 1 && bingo[2][2] == 1 && bingo[3][3] == 1 && bingo[4][4] == 1) {
//			num++;
//		}
//		if(bingo[0][4] == 1 && bingo[1][3] == 1 && bingo[2][2] == 1 && bingo[3][1] == 1 && bingo[4][0] == 1) {
//			num++;
//		}

		// ��� 02 >>
//		int check1 = 0, check2 = 0;
//		for(int i = 0; i < 5; i++) {
//			for(int j = 0; j < 5; j++) {
//				if (bingo[i][j] == 0) { break; }
//				if (j == 4) { num++; }
//			}
//			for(int j = 0; j < 5; j++) {
//				if (bingo[j][i] == 0) { break; }
//				if (j == 4) { num++; }
//			}
//			if(bingo[i][i] == 1) { check1++; }
//			if(bingo[i][4-i] == 1) { check2++; }
//		}
//		if (check1 == 5) { num++; }
//		if (check2 == 5) { num++; }
		
		// ��� 03 >> ��� 02�� ������
		for(int i = 0, k = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if (bingo[i][j] == 0) { break; }
				if (j == 4) { num++; }
			}
			for(int j = 0; j < 5; j++) {
				if (bingo[j][i] == 0) { break; }
				if (j == 4) { num++; }
			}
			while (i == 0) {
				if (bingo[k][k] == 0) { break; }
				if (k == 4) {
					num++;
					k = 0;
					break;
					}
				k++;
			}
			while (i == 0) {
				if (bingo[k][4-k] == 0) { break; }
				if (k == 4) {
					num++;
					break;
					}
				k++;
			}
		}
		
		return num;
	}

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
