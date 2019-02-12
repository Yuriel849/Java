package study;

class Ex07_InnerClass {
	public static void main(String[] args) {
		Outer o = new Outer(); // Outer Ŭ������ ��ü ����
		System.out.println("o.iv = " + o.iv); // '100' ��� --> Outer Ŭ������ �ν��Ͻ����� iv

		// Inner ����Ŭ������ ����Ϸ��� Outer Ŭ������ ��ü�� ���� �����ؾ� �Ѵ�.
//		Outer.Inner i = o.new Inner(); // Inner��� �ϸ� ���� Ŭ������ ã�� ���Ѵ�.
//									   // ����Ŭ������ �ܺ�Ŭ���� ���ο����� ����ϱ� ���� ���̱⿡ ����ϱⰡ �����ϴ�.
//		System.out.println("i.iv = " + i.iv); // '200' ���

		Outer.StaticInner i = new Outer.StaticInner(); // Inner Ŭ������ static�̱⿡ Outer ��ü ���� ���� ���� �����ϴ�.
		System.out.println("Outer.StaticInner.cv = " + Outer.StaticInner.cv); // '500' ���
		System.out.println();
	}
}

class Outer {
	int iv = 100;

	// Outer ��ü�� ���� �����ؾ� InstanceInner ��ü�� ���� ����
	class InstanceInner {
		int iv = 200;
//		static int cv = 300; // ����! --> Ŭ������ static�� �ƴѵ� (Outer ��ü�� ������ �ʰ�� ����� �� ���µ�), ��� ���ο� static����� �ֳ�?
	}
		
	// Outer ��ü ���� ���� StaticInner ��ü�� ���� �����ϴ�.
	static class StaticInner {
		int iv = 400;
		static int cv = 500;
	}
}