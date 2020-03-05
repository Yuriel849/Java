package collectionsFramework;

import java.util.ArrayList;
import java.util.Collections;

class E01_ArrayList {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(3); // add(Object obj) --> Cannot give int as argument --> autoboxing, int to Integer
		
		ArrayList list2 = new ArrayList(list1.subList(1,4)); // Creates list2 with sublist of list1
		print(list1, list2);
		
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
		
		// list1.containsAll(list2) --> TRUE only when list1 contains all elements of list2
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);
		
		list2.set(3, "AA");
		print(list1, list2);
		
		// list1 only retains what elements in both list1 and list2
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		print(list1, list2);
		
		// Removes from list2 the elements which are also in list1
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i))) { list2.remove(i); }
			/* Arraylist.remove(int index)
			 * 	--> Removes element at designated index, then moves forward following elements
			 * 		ex) If first element is removed, second element becomes new first element
			 * 	--> With a list, start looping from the end
			 */
		}
		print(list1, list2);
	}
	
	@SuppressWarnings("rawtypes")
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}