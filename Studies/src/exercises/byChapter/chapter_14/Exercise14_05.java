package exercises.byChapter.chapter_14;

import java.util.*;
import java.util.stream.*;

// ���ڿ� �迭 strArr�� ��� ���ڿ��� ���̸� ���� ����� ����϶�.

class Exercise14_05 {
	public static void main(String[] args) {
		String[] strArr = { "aaa","bb","c", "dddd" };

		Stream<String> strStream = Arrays.stream(strArr);
		
		int sum = strStream.map(String::length).reduce(0, (a,b) -> a+b);
//		int sum = strStream.mapToInt(String::length).sum();
		System.out.println("sum="+sum);
	} // main() ��.
} // Ŭ���� ��.