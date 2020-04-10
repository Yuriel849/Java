package collectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import pool.Student;

class Ex04_Collections {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateSchoolRank(List list) {
		Collections.sort(list);
		
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
	
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("Christina",2,1,70,90,70));
		list.add(new Student("Katherine",2,2,60,100,80));
		list.add(new Student("Johnny",1,3,100,100,100));
		list.add(new Student("Fred",1,1,90,70,80));
		list.add(new Student("George",1,2,80,80,90));

		calculateSchoolRank(list);
		
		System.out.println("<< List of Students >>");
		Iterator<Student> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main()
}