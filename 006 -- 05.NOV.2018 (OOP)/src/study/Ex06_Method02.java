package study;

/* Call by Value & Call by Reference
 * 	>> Java������ call by value�� C���� ����
 * 	>> Java������ call by reference�� �ٸ���
 */

public class Ex06_Method02 {
	// Call by Value ���� ���� ȣ��
	public static void method(int number) {
		number = 332;
	}
	public static void main(String[] args) {
		int number = 10;
		
		System.out.println("number : " + number);
		
		method(number); // number == 10�� �μ������ϸ鼭 method �޼ҵ带 ȣ��
		System.out.println("number : " + number);
	}

}
