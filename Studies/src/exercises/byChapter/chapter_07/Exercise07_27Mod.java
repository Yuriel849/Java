package exercises.byChapter.chapter_07;

// 3���� ������� value�� ���� ���϶�.

public class Exercise07_27Mod {
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		Outer2.Inner2 inner = outer.new Inner2();
		inner.method1();
	} // main() ��.
} // InnerClass2 ��.

class Outer3 {
	int value = 10;
	
	class Inner3 {
		int value = 20;
		void method1() {
			int value = 30;
			System.out.println("           value : " + value); // method1 �޼����� value --> method1�� value�� ������ this.value�� ����.
			System.out.println("      this.value : " + this.value);	// ���� Ŭ������ value
			System.out.println("Outer.this.value : " + Outer3.this.value); // �ܺ� Ŭ������ value
		}
	} // Inner Ŭ���� ��.
} // Outer Ŭ���� ��.