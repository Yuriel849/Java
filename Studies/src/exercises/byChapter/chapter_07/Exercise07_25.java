package exercises.byChapter.chapter_07;

// OuterŬ������ Inner ����Ŭ������ ������� iv�� ���� ���϶�.

class Outer {
	class Inner {
		int iv = 100;
	} // ����Ŭ���� Inner ��.
	
	static class Inside {
		int iv = 200;
	} // ����Ŭ���� Inside ��.
} // �ܺ�Ŭ���� Outer ��.


class Exercise07_25 {
	public static void main(String[] args) {
		// Outer Ŭ������ ���� Ŭ���� Inside�� ������� iv�� ����Ѵ�.
		Outer.Inside inside = new Outer.Inside(); // Inside ����Ŭ������ static�̱⿡ �ܺ�Ŭ���� ��ü������ ���ʿ��ϴ�
		System.out.println(inside.iv);			  // 	>> ������ iv�� �ν��Ͻ������̱⿡ iv�� �����Ϸ��� ��ü ������ �ؾ��Ѵ�
		
		// Outer Ŭ������ ���� Ŭ���� Inner�� ������� iv�� ����Ѵ�.
		Outer out = new Outer(); 		  // 1. �ܺ� Ŭ���� ��ü�� ����
		Outer.Inner in = out.new Inner(); // 2. ���� Ŭ���� ��ü�� ����
		System.out.println(in.iv);		  // 	>> �������� Ÿ���� <�ܺ�>.<����>, ���� �� <�ܺ� ��ü��>.new <���� ������>
	} // main() ��.
} // Ŭ���� ��.
