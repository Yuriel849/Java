package main;

import java.util.ArrayList;
import java.util.Collections;

public class E25_Sorting {
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		for(int i = 10; i >= 0; i--) {
			list.add(new Integer(i));
		}
		System.out.println(list);
		
		Collections.sort(list);
		/* How is it ordered without a condition?
		 * 	--> Collections.sort() takes TWO (2) arguments
		 * 		--> 2nd argument, user may designate condition for sorting (ordering)
		 *  --> Integer class has "ascending" as default sorting condition, and provides this to Collections.sort()
		 */
		System.out.println(list);
	}
}