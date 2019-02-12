package study;

class Point {
	int x;
	int y;
	
	Point() { }
}

public class ClassClass {
	public static void main(String[] args) throws ClassNotFoundException { // forName ������ ���� �߰�
		Point p = new Point();
		
		// ��ü p�� ���赵 ��ü(Class ��ü)�� ���´�.
		Class cObj = p.getClass();
		Class cObj2 = Point.class; // Ŭ���������� �ƴ϶� Ŭ���� ���ͷ��̴�!!! --> <Ŭ������>.class ��ü�� �����!!!
		Class cObj3 = Class.forName("Point"); // Ŭ���� �̸����κ��� Ŭ���� ��ü�� ��´�.
		
		System.out.println("className = " + cObj.getName());
		System.out.println("packageName = " + cObj.getPackage());
		
		// Class Ŭ������ Ư�� Ŭ������ ��ü�� ����� ���� �ش� Ŭ������ ��� ����� �˰� ����� �� �ִ�.
		// �ҽ��ڵ带 ���� �ȵǳ�? --> �׻� Ư�� Ŭ������ �ҽ��ڵ带 ��� �� �ִ� ���� �ƴϴ� (ex) ��3�ڰ� �������� Ŭ����)
	}
}
