package study;

public class Ex10_Static {
	int iv;
	static int cv;
	
	void instanceMethod01() {	}
	static void staticMethod01() { 	}
	
	void instanceMethod02() {
		System.out.println(iv); // �ν��Ͻ� �޼ҵ�� ��ü ���� �Ŀ��� ��밡���ϴϱ� �ν��Ͻ� ��� ��뿡 ���� ����
		System.out.println(cv);
		instanceMethod01();
		staticMethod01();
	}
	
	static void staticMethod02() {
		// System.out.println(iv); --> ��ü ���� �� �����Ϸ��ϴϱ� ����
		System.out.println(cv);
		// instanceMethod01(); --> ��ü ���� �� �����Ϸ��ϴϱ� ����
		staticMethod01();
		Ex10_Static st = new Ex10_Static();
		System.out.println(st.iv);
		st.instanceMethod01();
	}

}
