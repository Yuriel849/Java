package stream;

import java.util.*;
import java.util.stream.*;

class Ex05_Stream {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("aaa","bb","c", "dddd");
		Stream<String> strStream = strList.stream();
		
		Optional<String> result = strStream.max(Comparator.comparingInt(String::length));
		System.out.println(result.get().length()); // 4 -> "dddd" is the longest String, length == 4
		
		// Alternate solution
//		String[] strArr = { "aaa","bb","c", "dddd" };
//		Stream<String> strStream = Stream.of(strArr);
//		strStream.map(String::length) // == strStream.map(s-> s.length())
//				 .sorted(Comparator.reverseOrder())
//				 .limit(1).forEach(System.out::println);
	}
}