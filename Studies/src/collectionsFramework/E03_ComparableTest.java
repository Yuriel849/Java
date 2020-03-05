package collectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

// Comparable & Comparator 실습

/* <부가설명>
 * 	>> sort()의 코드와 로직은 완성되어 있고, 나는 어떻게 구현되었는지 신경 쓸 필요가 없다.
 * 	>> sort()에게 부족한 것, 내가 제공해야 하는 것은 배열과 정렬의 기준 (무엇을 기준으로 순서를 정할 것인가?)
 * 		>> sorting할 때 2개 값을 비교하여 조건에 충족하면 자리바꿈을 한다.
 * 			>> 정확히 어떤 2개 값을 비교하는지는 sort 메서드마다 다르다 (ex) quick sort, bubble sort 등등)
 * 		>> 비교할 때 쓰는 조건식을 제공하는게 "정렬기준"!!!
 * 
 * 	>> 정렬기준을 숫자로 알려주는 것이 가장 간편하다
 * 		ex) 버블소트에서 오름차순 정렬하려면... i 값과 (i+1) 값을 비교 --> i-(i+1) --> 음수면 i가 더 작은 것, 0이면 같은 것, 양수면 i가 더 큰 것 
 */ 

class E03_ComparableTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Student("Hamburg", 50, 15));
		list.add(new Student("Seoul", 100, 20));
		list.add(new Student("Portsmouth", 75, 25));
		list.add(new Student("St.Petersburg", 100, 10));
		list.add(new Student("Boston", 25, 35));

		Iterator it = list.iterator();		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// Sort with the basic Comparable specified by Student class
		Collections.sort(list);
		
		System.out.println("\n이름(사전 순)으로 정렬하였다.");
		it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		// Sort by score, descending with Comparator specified in ScoreComp class
		Collections.sort(list, new ScoreComp());
		
		System.out.println("\n성적 순으로 정렬하였다.");
		it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

// (Q1) Student의 기본정렬을 이름(사전 순)으로 하라.
@SuppressWarnings("rawtypes")
class Student implements Comparable {
	String name;
	int score;
	int age;
	
	public Student(String name, int score, int age) {
		super();
		this.name = name;
		this.score = score;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) { // Compare this & o --> Student instance is provided as o
		if(o instanceof Student) { // Check if o is instance of Student
			return this.name.compareTo(((Student) o).name);
		}
		return 0;
	}
	
	public int hashCode() {
		return Objects.hash(name, score, age);
	}
	
} // Student 클래스 끝.

// (Q2) 정렬기준이 성적순(내림차순)인 Comparator를 구현한 클래스 ScoreComp를 작성하라.
//		>> 성적이 같은 경우 나이순(내림차순)으로 정렬할 것.
@SuppressWarnings("rawtypes")
class ScoreComp implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			// 삼항연산자로 내가 계산하는 대신 Integer로 autoboxing & unboxing하여 Integer클래스의 compareTo()를 사용한다.
			Integer oneVal = ((Student) o1).score;
			Integer anoVal = ((Student) o2).score;
			Integer oneAge = ((Student) o1).age;
			Integer anoAge = ((Student) o2).age;
			int i = oneVal.compareTo(anoVal) * -1;
			return (i==0 ? (oneAge.compareTo(anoAge) * -1) : i);
			
			// int 변수들에 score, age 값들을 저장한 후 중복 삼항연산자를 이용한다.
//			int oneVal = ((Student) o1).score;
//			int anoVal = ((Student) o2).score;
//			int oneAge = ((Student) o1).age;
//			int anoAge = ((Student) o2).age;
//			return (oneVal < anoVal ? 1 : (oneVal == anoVal ? (oneAge < anoAge ? 1 : (oneAge == anoAge ? 0 : -1)) : -1));
		}
		return 0;
	} // compare() 끝.
} // ScoreComp 클래스 끝.