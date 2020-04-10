package stream;

import java.util.*;
import java.util.stream.*;

class Ex04_Stream {
	public static void main(String[] args) {
		String[] strArr = { "aaa","bb","c", "dddd" };

		Stream<String> strStream = Arrays.stream(strArr); // Make stream out of String array
		
		int sum = strStream.map(String::length).reduce(0, (a,b) -> a+b);
//		int sum = strStream.mapToInt(String::length).sum();
		System.out.println("sum="+sum);
	}
}