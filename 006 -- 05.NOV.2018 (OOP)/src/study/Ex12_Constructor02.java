package study;

// !!! left+ctrl + ȣ�⹮ ==> ȣ��Ǵ� �� �ڵ�� �̵� !!!

class A {
	public A() {
		this(10); // ���� Ŭ���� ���� �ٸ� ������ ȣ��
				  //  	--> �����ڴ� ���ȣ�� �Ұ����ϱ⿡ ��ȣ Ȥ �ڷ����� �޼ҵ� �ڷ����� ������ ����
		System.out.println("public A()");
	}
	public A(int i) {
		this(10F);
		System.out.println("public A(int i)");
	}
	public A(float f) {
		this(10.0);
		System.out.println("public A(float f)");
	}
	public A(double d) {
		System.out.println("public A(double d)");
	}
	
	public void display() { // �Ϲ� �޼ҵ�
		// this(23.54); --> ���� --> �Ϲ� �޼ҵ忡�� this�� ������ ȣ�� �Ұ���
	}
}

public class Ex12_Constructor02 {
	public static void main(String[] args) {
		System.out.println("���α׷� ����\n");
		new A(); // �⺻ ������ ȣ��
			/* ȣ���ϸ�...
			 * 		--> �⺻ ������ ȣ��
			 * 		--> int �Ű����� �޴� ������ ���ȣ��
			 * 		--> float �Ű����� �޴� ������ ���ȣ��
			 * 		--> double �Ű����� �޴� ������ ���ȣ��
			 * 		--> ���ȣ���� �ڵ� ������ ������ ���ȣ���� �������� ���ư��� ���� �ڵ� ���� 
			 */		
		System.out.println("\n���α׷� ����");
	}
}