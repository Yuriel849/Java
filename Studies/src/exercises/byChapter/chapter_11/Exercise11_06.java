package exercises.byChapter.chapter_11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

// ��������� �������� �л� ���� ����.
// TreeSet�� ����� �������� �����ϵ��� compare()��
// 		��������� ������ �ָ� �ش� ������ ���� �л��� ���� ��ȯ�ϴ� getGroupCount()�� �ۼ��϶�.

@SuppressWarnings({ "rawtypes", "unchecked" })
class Exercise11_06 {
	static int getGroupCount(TreeSet tset, int from, int to) {
		Student2 s1 = new Student2("", 0, 0, from, from, from);
		Student2 s2 = new Student2("", 0, 0, to, to, to);
		return tset.subSet(s1, s2).size();
	} // getGroupCount() ��.
	
	public static void main(String[] args) {
		TreeSet set = new TreeSet(new Comparator() { // �͸�Ŭ����
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Student2 && o2 instanceof Student2) {
					Student2 s1 = (Student2)o1;
					Student2 s2 = (Student2)o2;
					return (int)(s1.getAverage() - s2.getAverage());
				} // ��������� ���ı������� ���� ������, �� �ߺ��� ��������� ���� �ߺ����� �ƴ��� �Ǵ��Ѵ�. (set�� �ߺ��� ���� ������� �ʴ´�!)
				return -1;
			}
		});

		set.add(new Student2("ȫ�浿",1,1,100,100,100));
		set.add(new Student2("���ڹ�",1,2,90,70,80));
		set.add(new Student2("���ڹ�",1,3,80,80,90));
		set.add(new Student2("���ڹ�",1,4,70,90,70));
		set.add(new Student2("���ڹ�",1,5,60,100,80)); // ���ڹٿ� ���ڹ��� ��������� ���⿡ �ߺ������� ���
													  // 	--> ���� ����� ���ڹٴ� ����ǰ� ���ڹٴ� ������� �ʴ´�.
		
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("[60~69] :" + getGroupCount(set,60,70));;
		System.out.println("[70~79] :" + getGroupCount(set,70,80));;
		System.out.println("[80~89] :" + getGroupCount(set,80,90));;
		System.out.println("[90~99] :" + getGroupCount(set,90,101));;
	} // main() ��.
} // Ŭ���� ��.

@SuppressWarnings("rawtypes")
class Student2 implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student2(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int)((getTotal() / 3f) * 10 + 0.5) / 10f;
	}
	
	public String toString() {
		return name
				+ "," + ban
				+ "," + no
				+ "," + kor
				+ "," + eng
				+ "," + math
				+ "," + getTotal()
				+ "," + getAverage();
	}
	
	public int compareTo(Object o) {
		if(o instanceof Student2) {
			Student2 tmp = (Student2) o;
			return name.compareTo(tmp.name);
		}
		return -1;
	}
} // Ŭ���� ��.