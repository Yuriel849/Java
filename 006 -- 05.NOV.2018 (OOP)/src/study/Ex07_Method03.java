package study;

/* Call by Value & Call by Reference
 * 	>> Java������ call by value�� C���� ����
 * 	>> Java������ call by reference�� �ٸ���
 */

public class Ex07_Method03 {
	// Call by Reference ������ ���� ȣ��
	public static void method(int[] number) {
		number[2] = 332;
	}
	public static void main(String[] args) {
		int[] number = {10, 20, 30, 40, 50};
		
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
		System.out.println("\n\n===============\n");
		method(number);
		/* �迭�� ���...
		 * "number"�� number �迭�� �ּҸ� �ǹ�
		 * number[A]�� �ؾ��� �迭�� ���� �ǹ�
		 */

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
	}

}
