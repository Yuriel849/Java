package stream;

import java.util.Random;
import java.util.stream.*;

class Ex06_Stream {
	public static void main(String[] args) {
		IntStream intSt = new Random().ints(6, 1, 46); // Stream giving 6 random numbers between 1 ~ 45
		
		intSt.sorted().forEach(System.out::println);
	}
}