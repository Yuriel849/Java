package collectionsFramework;

import java.util.Set;
import java.util.TreeSet;

// TreeSet�� ��ü�� Comparable�� �����ϴ��� ������ Comparator�� �ʿ��ϴ�
// 	>> �� ���·δ� ���� �� ����!

class Ex05_TreeSetTest {
	public static void main(String[] args) {
		Set set = new TreeSet();
		
		set.add(new Student("ȫ�浿", 50, 15));
		set.add(new Temp()); // ����! --> Temp�� Comparable�� ��� �ְų�, ������ Comparator�� �����ؾ� �Ѵ�.
	} // main() ��.
} // Student Ŭ���� ��.

class Temp { }

