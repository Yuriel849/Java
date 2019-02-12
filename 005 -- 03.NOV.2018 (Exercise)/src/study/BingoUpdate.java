package study;

public class BingoUpdate {
	public static void main(String[] args) {
		// 1. 5X5 2���� �迭 ����
		int[][] array = new int[5][5]; 
		
		// 2. �迭�� 1 ~ 25 �� �Է� (�ʱ�ȭ)
		int add = 1;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array [i][j] = add;
				add++;
			}
		}
		
		// 3. 2���� ���·� �迭 ���
		System.out.println("5 X 5 2���� �迭 : ");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		// 4. ����
		int a = 0, b = 0;
		int temp = 0;
		for(int i = 0; i < 100; i++) {
			a = (int) (Math.random() * 5);
			b = (int) (Math.random() * 5);
			temp = array[0][0];
			array[0][0] = array[a][b];
			array[a][b] = temp;
		}
		
		// 5. ����� �Է� �ޱ�
		int input = BingoScanner.main(null);
		
		// 6. ����ڰ� �Է��� ���� ��ġ�ϴ� ���� ã�Ƽ� 0���� �ٲٱ� 
		search : for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == input) {
					array[i][j] = 0;
					break search;
				}
			}
		}
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println();
		}
	}

}
