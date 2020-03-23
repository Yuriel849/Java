package lambda;

import java.util.*;
import java.util.function.*;

class Ex03_Lambda03 {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random()*100) + 1; // Random number output (0<=X<100)
		Consumer<Integer> c = i -> System.out.print(i + ", "); // Prints input and comma
		Predicate<Integer> p = i -> i % 2 == 0; // Checks if input is even number
		Function<Integer, Integer> f = i -> i/10*10; // Remove the unit digit (rightmost)
	
		List<Integer> list = new ArrayList<> ();
		
		makeRandomList(s,list);
		System.out.println(list);
		
		printEvenNum(p, c, list);
		
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}
	
	static<T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i)); // Remove unit digit of each number in list and add to newList
		}
		
		return newList;
	}
	
	static<T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i))
				c.accept(i);
		}
		System.out.println("]");
	}
	
	static<T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i = 0; i < 10; i++) {
			list.add(s.get());
		}
	}
}