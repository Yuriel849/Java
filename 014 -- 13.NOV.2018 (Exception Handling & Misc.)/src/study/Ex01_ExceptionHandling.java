package study;

// �ڵ� �� �� �̻��� ���̶���Ʈ�ϰ� alt + shift + z�ϸ� try-catch, if, for, while �� ���� ������ �� �ִ�
// source �ǿ� toString, getter & setter ������ �� �ִ�

//public class Ex01_ExceptionHandling {
//	public static void main(String[] args) {
//		System.out.println(1);
//		System.out.println(2);
//		
//		try {
//			System.out.println(3);
//			System.out.println(4);
//		} catch (Exception e) {
//			System.out.println(5);
//		} // try-catch�� ��.
//		System.out.println(6);
//	} //main()�� ��.
//} // Ŭ������ ��.

class Ex01_ExceptionHandling {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0); // ��°���� 1 2 5 6
			System.out.println(4);   // 	>> ���ٿ��� ����ó�� ���ϱ� �Ʒ� �ڵ�� ������� �ʴ´�
									 // 	>> ����ó�� ���� catch�� ���ܸ� �ϳ��� Ȯ���Ͽ� ��ġ�ϴ� ������ ã��
									 // 	>> ã���� �� ���� �ڵ���� �����ϰ� try-catch �ι��� ����
		} catch (ArithmeticException ae) {
			System.out.println(5);
		} // try-catch�� ��.
		System.out.println(6);
	} //main()�� ��.
} // Ŭ������ ��.