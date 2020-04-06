package exercises.byChapter.chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// StudentŬ������ Comparable �������̽��� �����϶�.
// �⺻���ı����� name�� �ǵ����϶�.

class Exercise11_05 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("ȫ�浿",1,1,100,100,100));
		list.add(new Student("���ڹ�",1,2,90,70,80));
		list.add(new Student("���ڹ�",1,3,80,80,90));
		list.add(new Student("���ڹ�",1,4,60,90,70));
		list.add(new Student("���ڹ�",1,5,70,50,50));
		
		Collections.sort(list);
		Iterator it = list.iterator();
		
		System.out.println("�̸�, ��, ��ȣ, ����, ����, ����, ����, ���");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main() ��.
} // Ŭ���� ��.

@SuppressWarnings("rawtypes")
class Student implements Comparable {
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
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
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
	}
	
	public int compareTo(Object o) {
		String myName = this.name;
		String yourName = "";
		if(o instanceof Student) {
			yourName = ((Student) o).name;
		}
		return myName.compareTo(yourName);
	}
} // Ŭ���� ��.