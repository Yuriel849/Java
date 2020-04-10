package exercises.byChapter.chapter_11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import pool.Student;

class Exercise11_06 {
	static int getGroupCount(TreeSet<Student> tset, int from, int to) {
		Student s1 = new Student("", 0, 0, from, from, from);
		Student s2 = new Student("", 0, 0, to, to, to);
		return tset.subSet(s1, s2).size();
	} // getGroupCount()
	
	public static void main(String[] args) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		TreeSet<Student> set = new TreeSet<Student>(new Comparator() { // Anonymous class, sort according to average grades
			public int compare(Object o1, Object o2) {
				if(o1 instanceof Student && o2 instanceof Student) {
					Student s1 = (Student)o1;
					Student s2 = (Student)o2;
					return (int)(s1.getAverage() - s2.getAverage());
				}
				return -1;
			}
		}); // TreeSet constructor end.

		set.add(new Student("John",1,1,100,100,100));
		set.add(new Student("Chris",1,2,90,70,80));
		set.add(new Student("Seele",1,3,80,80,90));
		set.add(new Student("Mara",1,4,70,90,70));
		set.add(new Student("Adams",1,5,60,100,80)); // Same average as Chris, so cannot be saved
		
		Iterator<Student> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("[60~69] :" + getGroupCount(set,60,70));;
		System.out.println("[70~79] :" + getGroupCount(set,70,80));;
		System.out.println("[80~89] :" + getGroupCount(set,80,90));;
		System.out.println("[90~99] :" + getGroupCount(set,90,101));;
	} // main()
}