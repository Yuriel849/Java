package exercises.byChapter.chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import pool.Student;

class Exercise11_09 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void calculateClassRank(List list) {
		Collections.sort(list, new ClassTotalComparator());
		
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		for(int i = 0, n = 0; i < length; i++, n++) {
			if(list.get(i) instanceof Student) {
				Student std = (Student) list.get(i);

				if(std.getBan() != prevBan) { // Reset prevRank, prevTotal, n when class number changes
					prevRank = -1;
					prevTotal = -1;
					n = 0;
				}
				
				if(std.getTotal() == prevTotal) { std.setClassRank(prevRank); }
				else { std.setClassRank(n + 1); }

				prevBan = std.getBan();
				prevTotal = std.getTotal();
				prevRank = std.getClassRank();
			}
		} // for loop
	} // calculateClassRank()
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateSchoolRank(List list) {
		Collections.sort(list, new ClassTotalComparator());
		
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
		for(int i = 0; i < length; i++) {
			if(list.get(i) instanceof Student) {
				Student std = (Student) list.get(i);

				if(std.getTotal() == prevTotal) { std.setSchoolRank(prevRank); }
				else { std.setSchoolRank(i + 1); }

				prevTotal = std.getTotal();
				prevRank = std.getSchoolRank();
			}
		} // for loop
	} // calculateSchoolRank()
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("Mike",2,1,70,90,70));
		list.add(new Student("Kat",2,2,60,100,80));
		list.add(new Student("Eli",1,3,100,100,100));
		list.add(new Student("Mary",1,1,90,70,90));
		list.add(new Student("Ria",1,2,80,80,90));

		calculateSchoolRank(list);
		calculateClassRank(list);
		
		System.out.println("<< List of Students >>");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main()
}

@SuppressWarnings("rawtypes")
class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		int result = 0;
		if(o1 instanceof Student && o2 instanceof Student) {
			Student s1 = (Student) o1;
			Student s2 = (Student) o2;
			result = s1.getBan() - s2.getBan();
			
			if(result == 0) {
				result = s2.getTotal() - s1.getTotal();
			}
		}
		return result;
	} // compare()
}