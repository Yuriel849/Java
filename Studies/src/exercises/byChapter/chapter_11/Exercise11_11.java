package exercises.byChapter.chapter_11;

import java.util.HashSet;

// SutdaCard Ŭ������ HashSet�� �����ϰ� ����϶�.
// 		�ߺ��� ī�尡 ������� �ʵ��� hashCode()�� �������̵��϶�.
class SutdaCard2 {
	int num;
	boolean isKwang;
	
	SutdaCard2() {
		this(1, true);
	}
	
	SutdaCard2(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SutdaCard2) {
			SutdaCard2 c = (SutdaCard2) obj;
			return num == c.num && isKwang == c.isKwang;
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.num + (isKwang ? 1 : 0);
	}
	
	
	public String toString() {
		return num + ( isKwang ? "K" : "");
	}
} // Ŭ���� ��.

class Exercise11_11 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		SutdaCard2 c1 = new SutdaCard2(3, true);
		SutdaCard2 c2 = new SutdaCard2(3, true);
		SutdaCard2 c3 = new SutdaCard2(1, true);
		
		HashSet set = new HashSet();
		set.add(c1);
		set.add(c2);
		set.add(c3);
		
		System.out.println(set);
	} // main() ��.
} // Ŭ���� ��.