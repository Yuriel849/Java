package study;

public class Ex01_Array01 {
	public static void main(String[] args) {
		// �迭 (����) ����
		int number; // data ������� Ȯ�� --> ���� ����
				// --> ������ ���� int�� int �ڷ��� ������ 1���� �� ���ִٴ� ���
		int[] array; // data�� �ּ� ������� Ȯ��, ���� �迭 ���� X --> �迭 (���۷���) ���� ����
				// --> ������ ���� int[]�� int�� �����͸� ������ �� �ִ� 1���� �迭�̶�� ���
		int[][] array2; // data�� �ּ� ������� Ȯ��, ���� �迭 ���� X --> �迭 (���۷���) ���� ����
				// --> ������ ���� int[][]�� int�� �����͸� ������ �� �ִ� 2���� �迭�̶�� ���
		
		/* int type �迭 ����
		 * 		>> �迭 ������ �迭�� �޸𸮿� �����ϴ� ��
		 * 		>> �迭 ������ �޸𸮿� �迭�� ��������� Ȯ���ϰ�
		 * 			(���ÿ� �ʱ�ȭ�� ���� �ְ�) �� �ּҰ��� �迭�� �����ϴ� ��
		 * 
		 * int[3]
		 * 		>> int data 3���� ��� ���� Ȯ��
		 * 		>> int �迭 ���� 3���� ���� �⺻���� 0���� �ʱ�ȭ��
		 */
		array = new int[3];
		
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		
		// array; --> �迭 ��ü�� �ּ�
		// array[0]; --> �迭 ��� �ϳ��� �ּ�
		
		
		System.out.printf("array[%d] = %d%n",  0, array[0]);
		System.out.printf("array[%d] = %d%n",  1, array[1]);
		System.out.printf("array[%d] = %d%n",  2, array[2]);
		
		System.out.println();
		for(int i = 0; i < 3; i++) {
			System.out.printf("array[%d] = %d%n", i, array[i]);
		}
		
		System.out.println();
		for(int i = 0; i < 3; i++) {
			array[i] = 10;
			System.out.printf("array[%d] = %d%n", i, array[i]);
		}
		
		int value = 10;
		System.out.println();
		for(int i = 0; i < 3; i++) {
			array[i] = (i+1) * value;
			System.out.printf("array[%d] = %d%n", i, array[i]);
		}
	}

}
