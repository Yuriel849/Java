package exercises.byChapter.chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Student�� �⺻������ ����(total)�� �������� �� ������������ �����ϰ�,
//		������ �������� �� �л��� ��������� ����ϰ� ��������� �������� �������� �����Ͽ� ����϶�.

class Exercise11_08 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateSchoolRank(List list) {
		// ���� �������� ������������ �����Ѵ�.
		Collections.sort(list);
		
		int prevRank = -1; // ���� �������
		int prevTotal = -1; // ���� ����
		int length = list.size();
		
			// 1. �ݺ����� �̿��ؼ� list�� ����� Student ��ü�� �ϳ��� �д´�.
		for(int i = 0; i < length; i++) {
			if(list.get(i) instanceof Student4) {
				Student4 std = (Student4) list.get(i);
					// 2. total�� prevTotal�� ������ prevRank�� schoolRank�� �Ѵ�.
				if(std.getTotal() == prevTotal) { std.schoolRank = prevRank; }
					// 3. ������ �ٸ���, schoolRank�� ���� �˸°� ����Ѵ�. �����ڰ� �־��ٸ�, �� ���� ����� �����ڵ� ����ؾ� �Ѵ�.
				else { std.schoolRank = i + 1; } // �̹� sort()�� ���ĵǾ��⿡, else���� ����ȴٸ� total�� �� ũ�ٴ� ��!
					// 4. ���� ������ ����� prevTotal�� prevRank�� �����Ѵ�.
				prevTotal = std.getTotal();
				prevRank = std.schoolRank;
			}
		} // for�� ��.
	} // calculateSchoolRank() ��.
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student4("���ڹ�",2,1,70,90,70));
		list.add(new Student4("���ڹ�",2,2,60,100,80));
		list.add(new Student4("ȫ�浿",1,3,100,100,100));
		list.add(new Student4("���ڹ�",1,1,90,70,80));
		list.add(new Student4("���ڹ�",1,2,80,80,90));

		calculateSchoolRank(list);
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main() ��.
} // Ŭ���� ��.

@SuppressWarnings("rawtypes")
class Student4 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // ����
	int schoolRank; // �������
	
	Student4(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor + eng + math;
	}
	
	int getTotal() {
		return total;
	}
	
	float getAverage() {
		return (int)((getTotal() / 3f) * 10 + 0.5) / 10f;
	}
	
	public String toString() {
		return name
				+ "," + ban
				+ "," + no
				+ "," + kor
				+ "," + eng
				+ "," + math
				+ "," + getTotal()
				+ "," + getAverage()
				+ "," + schoolRank;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Student4) {
			Student4 tmp = (Student4) o;
			return tmp.total - this.total; // tmp�� total�� �� ũ�� ���, ������ 0, �� ������ ������ ��ȯ
		}
		return -1;
	}
} // Ŭ���� ��.