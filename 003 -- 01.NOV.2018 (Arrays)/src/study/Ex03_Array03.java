package study;

public class Ex03_Array03 {
	public static void main(String args[]) {
		// �迭 (���۷���) ���� 3���� �� �ٿ� �����ϱ�
		int[] num1, num2, num3;
		num1 = new int[3];
		num2 = new int[5];
		num3 = new int[3];
		
		int num4[], num5, num6;
		
		// int[] num; == int num[];
		num4 = new int[5];
		num5 = 50;
		num6 = 60;
		
		num4 = new int[]{10,20,30,40,50}; // 5ĭ¥�� 1���� �迭�� ���Ӱ� �����ؼ� num4�� �����Ѵ�.
										  // ������ num4�� �����ϴ� �迭�� ���̻� num4���� �������� �ʴ´�.
		for(int num : num4) {
			System.out.println(num);
		}
		
		num4 = new int[]{10,20}; // 2ĭ¥�� 1���� �迭�� ���Ӱ� �����ؼ� num4�� �����Ѵ�.
		  						 // ������ num4�� �����ϴ� �迭�� ���̻� num4���� �������� �ʴ´�.
		for(int num : num4) {
			System.out.println(num);
		}
	}
}