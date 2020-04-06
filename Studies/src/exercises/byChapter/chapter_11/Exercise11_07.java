package exercises.byChapter.chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// ArrayList�� Student�ν��Ͻ��� ��(ban) & ��ȣ(no)�� �������� ���ĵǰ� �϶�.
// 		���� ���� ��� ��ȣ�� ���ؼ� �����Ѵ�.

class Exercise11_07 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student3("���ڹ�",2,1,70,90,70));
		list.add(new Student3("���ڹ�",2,2,60,100,80));
		list.add(new Student3("ȫ�浿",1,3,100,100,100));
		list.add(new Student3("���ڹ�",1,1,90,70,80));
		list.add(new Student3("���ڹ�",1,2,80,80,90));

		Collections.sort(list, new BanNoAscending());
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main() ��.
} // Ŭ���� ��.

class Student3 {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student3(String name, int ban, int no, int kor, int eng, int math) {
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
} // Ŭ���� ��.

@SuppressWarnings("rawtypes")
class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student3 && o2 instanceof Student3) {
			Student3 s1 = (Student3) o1;
			Student3 s2 = (Student3) o2;
			if(s1.ban != s2.ban) {
				return s1.ban - s2.ban;
			} else if(s1.ban == s2.ban) {
				return s1.no - s2.no;
			}
		}
		return -1;
	} // compare() ��.
} // Ŭ���� ��.