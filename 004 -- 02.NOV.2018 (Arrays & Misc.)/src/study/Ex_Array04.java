package study;

// ����(Shuffle) --> �迭�� ����� ������ �ݺ��ؼ� �ٲ۴� (ī�弯��, �ζǹ�ȣ����)
public class Ex_Array04 {
	public static void main(String[] args) {
		Shuffle01();
		Shuffle02();
	}
	
	private static void Shuffle01() {
		int[] numArr = new int[10];
		
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = i;
			System.out.print(numArr[i]);
		}
		System.out.println();
		
		for(int i = 0; i < 100; i++) {
			int n = (int)(Math.random() * 10);
			int tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}
		
		for(int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i]);
		}
		System.out.println();
		System.out.println();
	}
	
	private static void Shuffle02() {
		int[] ball = new int[45];
		
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i + 1;
		}
		
		int temp = 0;
		int j = 0;
		
		for(int i = 0; i < 6; i++) {
			j = (int)(Math.random() * 45);
			temp = ball[i];
			ball[i] = ball[j];
			ball[j] = temp;
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.printf("ball[%d} = %d%n", i, ball[i]);
		}
	}

}