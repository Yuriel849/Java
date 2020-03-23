package lambda;

import java.util.*;

class Ex02_Lambda02 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<> ();
		for(int i = 0; i < 10; i++) { list.add(i); }
		
		// Print all elements of the list
		list.forEach(i -> System.out.print(i + ","));
		System.out.println();
		
		// Remove multiples of 2 and 3 from the list
		list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
		System.out.println(list);
	
		// Multiply each element of the list by 10
		list.replaceAll(i -> i * 10);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<> ();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		// Print all entries of the map in the format "{k,v}"
		map.forEach((k,v) -> System.out.print("{" + k + "," + v + "}"));
		System.out.println();
	}
}