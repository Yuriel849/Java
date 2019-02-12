package study;

public class Ex11_Array11 {
	public static void main(String[] args) {
		// 1. 5X5 2���� �迭 ����
		int[][] array = new int[5][5]; 
		
		// 2. �迭�� 1 ~ 25 �� �Է� (�ʱ�ȭ)
		int add = 1;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				array [i][j] = add;
				add++;
			}
		}
		
		// 3. 2���� ���·� �迭 ���
		System.out.println("5 X 5 2���� �迭 : ");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
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
		System.out.println("5 X 5 �迭 ���� ��: ");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("%2d ", array[i][j]);
			}
			System.out.println();
		}
	}

}
