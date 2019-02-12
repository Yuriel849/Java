package study;

public class Ex02_CallStack {
	public static void main(String[] args) { // --> �޼ҵ� ����� == ���Ǻ� == signature
	
	/* Call Stack �޸�
	 *	>> ���α׷� ���� �� ������������ ����Ǵ� ��ġ
	 *		(������ ����...)
	 *		�������� --> ���α׷� ���� ���� �̹� ����� ������
	 *		�������� --> ���α׷� ���� ���� ���Ӱ� ��������� �������� ������
	 *	1) ���������� ����ȴ� (�������� == �޼ҵ� (�߰�ȣ {}) ���ο��� ����� ����)
	 *	2) �޼ҵ尡 ����� �� ����ϴ� �޸� ����
	 *	3) �ڵ��ʱ�ȭ�� �������� ���� --> ��������� �ʱ�ȭ������� �Ѵ�
	 *	4) �Ű�����(parameter)�� ����ȴ� (�Ű����� == �޼ҵ� ������� ��ȣ �ȿ��� ����� ����)
	 *		>> �߰�ȣ ���ο��� ����� ������ �ƴ�����, �޼ҵ��� �޸� ���� �ȿ� ��ġ�ϱ⿡ �������� ���!!!
	 *		>> public static void main(String[] args) --> "String[] args"�� �Ű�����
	 *		>> �Ű������� �޼ҵ� ���� �� �Է°��� �޾ƿ��� ���� (���� ����+�ٿ��ֱ�� �޾ƿ�)
	 */
		
		// �μ����� ���Ѵ� -> 2�� add �޼ҵ� �� �Ű����� ���� add�� ���� -> "add() �޼ҵ�" & "c : 10 + 20" ���
		add();
		
		// �μ����� �Ѵ� -> 2�� add �޼ҵ� �� �Ű����� �ִ� add�� ���� -> "2" ���
		add(2);
		
		/* add(2, 3);
		 * ����!
		 * 	>> add(int i)�� ����ο��� ������ �ڷ����� ������ ������ �μ��� �����ؾ� ���� ����
		 * 	>> �� �ϳ��� int�� �μ��� �����ؾ�, �� �׷��� ����
		 */
	}

	// �޼ҵ� ������ �Ǵٸ� �޼ҵ带 ���� �� ����!!!
	// Java�� �޼ҵ��� ������ �߿����� �ʴ� --> main() method�� �� ó���� �ƴϾ �������!!!
	
	// �Ű����� ���� �ܺο��� �����͸� ���� �ʰ� ���� ����
	public static void add() {
		System.out.println("add() �޼ҵ�");
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.println("c : " + a + " + " + b);
	}
	// int�� ������ 1���� �Ű������� �޾ƾ� ���� ����
	public static void add(int n1) {
		System.out.println(n1);
	}
	
	/* ������ ���� �̸��� ������ 2�� �̻� ������ �� ���� --> ������ ������ �� �ִ� ������ �̸� �ۿ� ���� �����̴� 
	 * �޼ҵ�� ��ȣ () �� �Ű��������� ���̰� �ִٸ� �޼ҵ� �̸��� ���Ƶ� �ȴ�!!!
	 * 	>> "Method Overloading" ��Ī
	 * 		>> �޼ҵ��� �̸��� ���Ƶ� �Ű������� �ٸ��� �ٸ� �޼ҵ�� �ν��ϴ� ����
	 * 		>> �Ű������� �ٸ��ٴ� �ǹ̴� �Ű������� Ÿ��(����), ����, ������ �ٸ��ٴ� ���̴�
	 * 		>> the following are examples
	 */
	
	// �Ű������� Ÿ��
	public static void add(int n1, int n2) {
		System.out.println(n1);
	}
	public static void add(int n1, float n2) {
		System.out.println(n1);
	}
	
	// �Ű������� ����
	public static void add02(int n1, int n2) {
		System.out.println(n1);
	}
	public static void add02(int n1, int n2, int n3) {
		System.out.println(n1);
	}
	
	// �Ű������� ����
	public static void add02(int n1, float n2) {
		System.out.println(n1);
	}
	public static void add02(float n1, int n2) {
		System.out.println(n1);
	}
}
