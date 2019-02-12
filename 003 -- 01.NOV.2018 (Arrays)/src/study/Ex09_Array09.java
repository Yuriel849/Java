package study;

public class Ex09_Array09 {
	public static void main(String[] args) {
		// 45���� �������� �����ϱ� ���� �迭 ����.
		int[] ball = new int[45];
		
		// �迭�� �� ��ҿ� 1 ~ 45�� ���� �����Ѵ�.
		for(int i = 0; i< ball.length; i++) {
			ball[i] = i + 1;
		}
		
		int temp = 0; // �� ���� �ٲٴµ� ����� �ӽú���
		int j = 0; // ������ ���� �� ������ ����
		
		for(int i = 0; i < 100; i++) {
			j = (int) (Math.random() * 45); // �迭�� ����(0~44)���� ������ ���� ��´�.
			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
		}
		
		// �迭 ball�� �տ������� 6���� ��Ҹ� ����Ѵ�.
		for(int i = 1; i < 46; i++) {
			System.out.printf("%3d ", ball[i-1]);
			if(i % 5 == 0) {
				System.out.println();
			}
		}
	}

}
