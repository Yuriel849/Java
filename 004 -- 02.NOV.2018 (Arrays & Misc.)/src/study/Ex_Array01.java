package study;

public class Ex_Array01 {
	public static void main(String[] args) {
		// 1. 5X5 2���� �迭 ����� --> bingo[0][0] - bingo [4][4]
		int[][] bingo = new int[5][5]; 
		
		// 2. 1 ~ 25 �� ���ڷ� �ʱ�ȭ
		int cnt = 0;
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				bingo[i][j] = ++cnt; // cnt ����ϴ� ��� --> i*5+j+1
			}
		}
		
		// 3. �迭�� ��� ��Ҹ� ���
		for(int i = 0; i < bingo.length; i++) {
			/* 2��° for�� & print(bingo[i][j]) ����ϴ� ��� 2���� �迭�� 1���� �迭�� �����̶�� Ư�� ���
			 * 		>> System.out.println(Arrays.toString(bingo[i]));
			 */
			for(int j = 0; j < bingo[i].length; j++) {
				System.out.printf("%2d ", bingo[i][j]);
			}
			System.out.println();
		}
		
		// 4. �� ����� ������ �ٲ۴� (���´�)
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				int x = (int)(Math.random()*5);
				int y = (int)(Math.random()*5);
				
				int tmp = bingo[i][j];
				bingo[i][j] = bingo [x][y];
				bingo[x][y] = tmp;
			}
		}
		
		// 5. �迭�� ��� ��� �ٽ� ���
		System.out.println();
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				System.out.printf("%2d ", bingo[i][j]);
			}
			System.out.println();
		}
	}

}
