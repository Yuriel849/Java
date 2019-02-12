package enumAndAnnotation;

import java.util.Date;

class Parent {
	void method01() {
		System.out.println("Parent method()");
	}
}

class Child extends Parent {
	@Override // "@Override"�� �޼��� �տ� ���̸� �����Ϸ����� �������̵��� ����� �ߴ��� ���������� Ȯ�����ش�.
	@Deprecated // �ٷ� �Ʒ� �޼���(method01())�� deprecated��� �˸��� ����
	@SuppressWarnings("deprecation") // ��� �޼��� ������, ��ȣ �� ������ ���� ��� �ϸ��� �ʴ´�
	void method01() {
		System.out.println("Child Method");
	}
}

class Ex02_Annotation {
	public static void main(String[] args) {
		Child c = new Child();
		c.method01(); // @SupressWarnings ���� @Deprecated�� �ϸ� ���⼭ ��� ���
		Date d = new Date();
		d.getDate(); // Deprecated�ϴٰ� ��Ҽ� ������ ��� �����. --> ������ ����������
	}
}
