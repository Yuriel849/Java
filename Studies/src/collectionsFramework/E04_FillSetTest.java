package collectionsFramework;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class E04_FillSetTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Set set = new HashSet();
		
		// Fill set with arbitrary values
		for(; set.size() < 10;) { // 중복되는 값은 입력 실패하기에, 실제 반복 횟수는 3보다 많을 수 있다.
			int r = (int)(Math.random()*100) + 1;
			set.add(r);
			System.out.println("r = " + r);
		}
		System.out.println(set);
		
		// Sort the set's values --> A set has no order, so change to a list
		List list = new LinkedList(set); // LinkedList(Collection c) constructor
		Collections.sort(list);
		System.out.println(list);
	}
}