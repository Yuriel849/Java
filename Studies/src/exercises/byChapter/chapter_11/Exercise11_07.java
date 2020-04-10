package exercises.byChapter.chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import pool.Student;

// ArrayList�� Student�ν��Ͻ��� ��(ban) & ��ȣ(no)�� �������� ���ĵǰ� �϶�.
// 		���� ���� ��� ��ȣ�� ���ؼ� �����Ѵ�.

class Exercise11_07 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("Christina",2,1,70,90,70));
		list.add(new Student("Michael",2,2,60,100,80));
		list.add(new Student("Michaela",1,3,100,100,100));
		list.add(new Student("Henry",1,1,90,70,80));
		list.add(new Student("Paul",1,2,80,80,90));

		Collections.sort(list, new BanNoAscending()); // Sort "list" with the given Comparator implementation
		
		Iterator<Student> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main()
}

@SuppressWarnings("rawtypes")
class BanNoAscending implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			if(s1.getBan() != s2.getBan()) { // First sort according to class number, ascending
				return s1.getBan() - s2.getBan();
			} else if(s1.getBan() == s2.getBan()) { // Else sort according to student number, ascending
				return s1.getNo() - s2.getNo();
			}
		}
		return -1;
	} // compare()
}