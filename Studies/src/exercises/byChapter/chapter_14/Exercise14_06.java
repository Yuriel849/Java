package exercises.byChapter.chapter_14;

import java.util.*;
import java.util.stream.*;

// ���ڿ� �迭 strArr�� ���ڿ� �߿��� ���� �� ���� ���̸� ����϶�.

class Exercise14_06 {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("aaa","bb","c", "dddd");
		Stream<String> strStream = strList.stream();
		
		Optional<String> result = strStream.max(Comparator.comparingInt(String::length));
		System.out.println(result.get().length());
		
		// Alternate solution
//		String[] strArr = { "aaa","bb","c", "dddd" };
//		Stream<String> strStream = Stream.of(strArr);
//		strStream.map(String::length) // strStream.map(s-> s.length())
//				 .sorted(Comparator.reverseOrder()) // ���ڿ� ���̷� ���� ����
//				 .limit(1).forEach(System.out::println); // ���� �� ���ڿ��� ���� ���
	} // main() ��.
} // Ŭ���� ��.