package collectionsFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

// Comparable & Comparator �ǽ�

/* <�ΰ�����>
 * 	>> sort()�� �ڵ�� ������ �ϼ��Ǿ� �ְ�, ���� ��� �����Ǿ����� �Ű� �� �ʿ䰡 ����.
 * 	>> sort()���� ������ ��, ���� �����ؾ� �ϴ� ���� �迭�� ������ ���� (������ �������� ������ ���� ���ΰ�?)
 * 		>> sorting�� �� 2�� ���� ���Ͽ� ���ǿ� �����ϸ� �ڸ��ٲ��� �Ѵ�.
 * 			>> ��Ȯ�� � 2�� ���� ���ϴ����� sort �޼��帶�� �ٸ��� (ex) quick sort, bubble sort ���)
 * 		>> ���� �� ���� ���ǽ��� �����ϴ°� "���ı���"!!!
 * 
 * 	>> ���ı����� ���ڷ� �˷��ִ� ���� ���� �����ϴ�
 * 		ex) �����Ʈ���� �������� �����Ϸ���... i ���� (i+1) ���� �� --> i-(i+1) --> ������ i�� �� ���� ��, 0�̸� ���� ��, ����� i�� �� ū �� 
 */ 

class Ex01_ComparableTest {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new Student("ȫ�浿", 50, 15));
		list.add(new Student("IWS ", 100, 20));
		list.add(new Student("���ڹ�", 75, 25));
		list.add(new Student("AUG ", 100, 10));
		list.add(new Student("�����", 25, 35));

		// ó���ϱ� ���� �� �� ���
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
//		Collections.sort(list); // �� ���·δ� ���� ������ ���� ������ ����!
		
		// �⺻ ���ı������� ����
		Collections.sort(list);
		
		System.out.println("\n�̸�(���� ��)���� �����Ͽ���.");
		it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		// ���� �������� ����
		Collections.sort(list, new ScoreComp());
		
		System.out.println("\n���� ������ �����Ͽ���.");
		it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main() ��.
} // Student Ŭ���� ��.

// (Q1) Student�� �⺻������ �̸�(���� ��)���� �϶�.
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
	public int compareTo(Object o) { // this & ������ ��ü o�� �� --> o�� Student ��ü�� ���´�!
		if(o instanceof Student) { // o�� Student ��ü���� Ȯ��
//			Student stud = (Student) o; // StudentŸ�� ���������� o�� ����ȯ
			return this.name.compareTo(((Student) o).name);
		}
		return 0;
	}
	
	public int hashCode() {
		return Objects.hash(name, score, age);
	}
	
} // Student Ŭ���� ��.

// (Q2) ���ı����� ������(��������)�� Comparator�� ������ Ŭ���� ScoreComp�� �ۼ��϶�.
//		>> ������ ���� ��� ���̼�(��������)���� ������ ��.
class ScoreComp implements Comparator {
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			// ���׿����ڷ� ���� ����ϴ� ��� Integer�� autoboxing & unboxing�Ͽ� IntegerŬ������ compareTo()�� ����Ѵ�.
			Integer oneVal = ((Student) o1).score;
			Integer anoVal = ((Student) o2).score;
			Integer oneAge = ((Student) o1).age;
			Integer anoAge = ((Student) o2).age;
			int i = oneVal.compareTo(anoVal) * -1;
			return (i==0 ? (oneAge.compareTo(anoAge) * -1) : i);
			
			// int �����鿡 score, age ������ ������ �� �ߺ� ���׿����ڸ� �̿��Ѵ�.
//			int oneVal = ((Student) o1).score;
//			int anoVal = ((Student) o2).score;
//			int oneAge = ((Student) o1).age;
//			int anoAge = ((Student) o2).age;
//			return (oneVal < anoVal ? 1 : (oneVal == anoVal ? (oneAge < anoAge ? 1 : (oneAge == anoAge ? 0 : -1)) : -1));
		}
		return 0;
	} // compare() ��.
} // ScoreComp Ŭ���� ��.