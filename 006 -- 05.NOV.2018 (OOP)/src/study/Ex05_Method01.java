package study;

public class Ex05_Method01 {
	static void test01() {
		System.out.println("test01() ����1");
		return; // return;�� ���� �ʾƵ� (�������� ������) �޼ҵ��� ���� �����Ѵ�
		/* System.out.println("test01() ����2");
		 * 		>> return;���� �޼ҵ�� �ڵ������ϱ⿡ �� ���Ŀ� ��ġ�� �ڵ�� ���� 
		 */
	}
	
	// main �޼ҵ�� ��ȯ���� ���� --> void�� ��ȯ�Ѵ� --> void �޼ҵ��
	public static void main(String[] args) {
		System.out.println("���α׷� ����");
		test01();
		test01(4F); // �Ǽ� 4�� ��ȯ ������ ��򰡿� ������� �ʱ⿡ ��������
		System.out.println("test01(4F)�� �ι�° ����");
		System.out.println(test01(4F));
		System.out.println("���α׷� ����");
	}
	
	static float test01(float number) {
		System.out.println("test01(int number) ����1");
		/* �Ű������� ���޹��� �����͸� �ᵵ �� �ᵵ ��� ����
		 * ������ �Ű������� ���� ���� ���� ������ �������� �ȵȴ�
		 */		
		System.out.println(number);
		return number * 4.2F; // void �޼ҵ�� void���� ��ȯ�� �� �ִ�!!!
		// return ���� ���� return keyword��� �θ��� (==��ȯ��)
	}

}
