package study;

public class Ex_TypeConversion {
	public static void main(String[] args) {
		// f�� 8�ڸ� ���� �Է� --> float�� ���е��� 7�ڸ������� --> 8�ڸ����� ���ڴ� �ŷ��� �� ���� ����
		float f = 9.1234567f;
		// �̹� f���� �ŷ��� �� ���� ���� f�� ���µ�, �̰��� double�� ����ȯ�ص� ���� ����� �Էµ��� �ʴ´�
		double d = (double) f;
		// d2�� 8�ڸ� ���� �Է� --> double�� ���е��� 15�ڸ����� --> ����� �Էµ�
		double d2 = 9.1234567;
		// d�� float�� ����ȯ�ϸ� f�� �Ǽ��� ������ ���� ���� ������ �߻��Ͽ� ������ ���ڰ� ���Եȴ�
		float f2 = (float) d;
		
		System.out.printf("f  = %20.18f%n", f);
		System.out.printf("f2 = %20.18f%n", f2);
		System.out.printf("d  = %20.18f%n", d);
		System.out.printf("d2 = %20.18f%n", d2);
	
	}
}
