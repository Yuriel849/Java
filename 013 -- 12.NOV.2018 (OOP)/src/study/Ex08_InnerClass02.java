package study;

class Ex08_InnerClass02 {
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		Outer2.Inner2 inner = outer.new Inner2();
		inner.method1();
	} // main() ��.
} // InnerClass2 ��.

class Outer2 {
	int value = 10;
	
	class Inner2 {
		int value = 20;
		void method1() {
			int value = 30;
			System.out.println("           value : " + value); // method1 �޼����� value --> method1�� value�� ������ this.value�� ����.
			System.out.println("      this.value : " + this.value);	// ���� Ŭ������ value
			System.out.println("Outer.this.value : " + Outer2.this.value); // �ܺ� Ŭ������ value
		}
	} // Inner Ŭ���� ��.
} // Outer Ŭ���� ��.
