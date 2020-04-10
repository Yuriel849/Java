package exercises.byChapter.chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import pool.Student;

class Exercise11_05 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("James",1,1,100,100,100));
		list.add(new Student("Frederika",1,2,90,70,80));
		list.add(new Student("Cat",1,3,80,80,90));
		list.add(new Student("Zane",1,4,60,90,70));
		list.add(new Student("Kim",1,5,70,50,50));
		
		Collections.sort(list);	// Elements of "list" (Student objects) must implement Comparable
		Iterator<Student> it = list.iterator();
		
		System.out.println("Names in alphabetical order >>\n" + 
				"Name, Class, Number, Score(KOR), Score(ENG), Score(Math), Total Score, Average Score\n" +
				"------------------------------------------------------------------------------------");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}