package study;

public class Ex02_Array02 {
	public static void main(String[] args) {
		// �迭�� ����� ������ �� �ٷ� ��
		int[] array1;
		array1 = new int[3];
		
		// �迭�� ����� ������ ���ÿ� ��
		int[] array2 = new int[3];
		
		// �迭�� ����� ������ �ʱ�ȭ�� ���ÿ� ��
		int[] array3 = new int[] {10, 20, 30};
		// new int[] ���� ����
		int[] array4 = {10, 20, 30};
		
		// �迭�� ����� ����, �ʱ�ȭ�� �� �ٿ� ���� ����
		int[] array5 = new int[3];
		// new int[] ������ �� ����
		array5 = new int[] {40, 50, 60};
		
		// ���� for������ ���
		for(int num : array5) {
			System.out.println(num);
		}
	}

}
