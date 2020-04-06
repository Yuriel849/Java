package exercises.byChapter.chapter_09;

// SutdaCard Ŭ������ equals()�� ������� num & isKwang�� ���� ���ϵ��� �������̵��϶�.

class Exercise09_01 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c1.equals(c2) : " + c1.equals(c2));
	} // main() ��.
} // Ŭ���� ��.

class SutdaCard {
	final int NUM; // SutdaCard Ŭ���� �ܺο��� ī���� ���ڿ� ���Ḧ ������ �� ���� ����.
	final boolean IS_KWANG;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.NUM = num;
		this.IS_KWANG = isKwang;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SutdaCard) {
			SutdaCard sutdaC = (SutdaCard) obj;
			return (this.IS_KWANG == sutdaC.IS_KWANG && this.NUM == sutdaC.NUM);
		}
		return false;
	}
	
	public String toString() {
		return NUM + ( IS_KWANG ? "K" : "");
	}
} // SutdaCard Ŭ���� ��.