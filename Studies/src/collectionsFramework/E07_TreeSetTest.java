package collectionsFramework;

import java.util.Set;
import java.util.TreeSet;

// TreeSet requires Comparable or Comparator implementation

class E07_TreeSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Set set = new TreeSet();
		
		set.add(new Student("홍길동", 50, 15)); // Student class in "E03_ComparableTest"
		set.add(new Temp()); // Error! --> Temp must implement Comparable or separate Comparator-implementation required
	}
}

class Temp { }