package study;

// Object Ŭ������ equals() �޼��带 �������̵��Ѵٸ� hashCode() �޼��嵵 �������̵��ؾ� �Ѵ�
public class HashCode {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();
		
		System.out.println("<�Ϲ� ������Ʈ>");
		System.out.println(obj1.hashCode()); // <��ü��>.hashCode() --> ���� �޸� �ּҰ��� ��ȯ
		System.out.println(obj2.hashCode()); // 	--> �ּҰ� �ٸ��ٴ� ���� �ٸ� ��ü��� �ǹ�
		System.out.println(obj3.hashCode());
		
		// BUT
		System.out.println("\n<���ڿ�>");
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1.hashCode()); // String�� �ּҰ��� ���� --> ���� ���ڿ� Ÿ�� ��ü�̴�
		System.out.println(str2.hashCode()); // 	--> why?? --> String Ŭ�������� Object Ŭ���� hashCode()�޼��带 �������̵� �ߴ�
	}
}
