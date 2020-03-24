package stream;

import java.util.*;
import java.util.stream.*;

class Ex01_Stream01 {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 180)
				);
		
		studentStream.sorted(Comparator.comparing(Student::getBan) // Sort by class number
					.thenComparing(Comparator.naturalOrder())) // Natural order sort (First order by class number, then within each class, order by name in alphabetical order)
					.forEach(System.out::println);
	}
}

class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
	}
	
	String getName() { return name; }
	int getBan() { return ban; }
	int getTotalScore() { return totalScore; }
	
	// Descending order by totalScore
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}