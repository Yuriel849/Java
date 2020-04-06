package exercises.byChapter.chapter_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Exercise11_08�� �̾ �ݵ��(classRank)�� ����Ͽ�,
//		������ �������� �����ϰ� ���� ������ �������� �������� �����϶�.

class Exercise11_09 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateClassRank(List list) {
		// ���� �ݺ� ��������, ���� ���� �������� ������������ �����Ѵ�.
		Collections.sort(list, new ClassTotalComparator());
		
		int prevBan = -1;
		int prevRank = -1;
		int prevTotal = -1;
		int length = list.size();
		
			// 1. �ݺ����� �̿��ؼ� list�� ����� Student��ü�� �ϳ��� �д´�.
		for(int i = 0, n = 0; i < length; i++, n++) {
			if(list.get(i) instanceof Student5) {
				Student5 std = (Student5) list.get(i);
					// 2. ���� �޶����� (ban�� prevBan)�� �ٸ��� prevRank�� prevTotal�� �ʱ�ȭ�Ѵ�.
				if(std.ban != prevBan) {
					prevRank = -1;
					prevTotal = -1;
					n = 0;
				}
					// 3. total�� prevTotal�� ������ prevRank�� classRank�� �Ѵ�.
				if(std.total == prevTotal) { std.classRank = prevRank; }
					// 4. ������ ���� �ٸ���, classRank�� ���� �˸°� ����Ѵ�. �����ڰ� �־��ٸ�, �� ���� ����� �����ڵ� ����ؾ� �Ѵ�.
				else { std.classRank = n + 1; }
					// 5. ���� �ݰ� ������ ����� prevBan, prevTotal, prevRank�� �����Ѵ�.
				prevBan = std.ban;
				prevTotal = std.total;
				prevRank = std.classRank;
			}
		} // for�� ��.
	} // calculateClassRank() ��.
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculateSchoolRank(List list) {
		// ���� �������� ������������ �����Ѵ�.
		Collections.sort(list, new ClassTotalComparator());
		
		int prevRank = -1; // ���� �������
		int prevTotal = -1; // ���� ����
		int length = list.size();
		
			// 1. �ݺ����� �̿��ؼ� list�� ����� Student ��ü�� �ϳ��� �д´�.
		for(int i = 0; i < length; i++) {
			if(list.get(i) instanceof Student5) {
				Student5 std = (Student5) list.get(i);
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
		list.add(new Student5("���ڹ�",2,1,70,90,70));
		list.add(new Student5("���ڹ�",2,2,60,100,80));
		list.add(new Student5("ȫ�浿",1,3,100,100,100));
		list.add(new Student5("���ڹ�",1,1,90,70,90));
		list.add(new Student5("���ڹ�",1,2,80,80,90));

		calculateSchoolRank(list);
		calculateClassRank(list);
		
		System.out.println("�̸�, ��,\t��ȣ,\t����,\t����,\t����,\t����,\t���,\t�������,\t�� ���");
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	} // main() ��.
} // Ŭ���� ��.


@SuppressWarnings("rawtypes")
class Student5 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total; // ����
	int schoolRank; // �������
	int classRank; // �� ���
	
	Student5(String name, int ban, int no, int kor, int eng, int math) {
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
				+ ",\t" + no
				+ ",\t" + kor
				+ ",\t" + eng
				+ ",\t" + math
				+ ",\t" + getTotal()
				+ ",\t" + getAverage()
				+ ",\t" + schoolRank
				+ ",\t" + classRank;
	}

	
	public int compareTo(Object o) {
		if(o instanceof Student4) {
			Student4 tmp = (Student4) o;
			return tmp.total - this.total; // tmp�� total�� �� ũ�� ���, ������ 0, �� ������ ������ ��ȯ
		}
		return -1;
	}
} // Ŭ���� ��.


@SuppressWarnings("rawtypes")
class ClassTotalComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		int result = 0;
		if(o1 instanceof Student5 && o2 instanceof Student5) {
			Student5 s1 = (Student5) o1;
			Student5 s2 = (Student5) o2;
			result = s1.ban - s2.ban; // ��(ban) �������� (��������)
			
			if(result == 0) {
				result = s2.total - s1.total; // ����(total) �������� (��������)
			}
		}
		return result;
	} // compare() ��.
} // Ŭ���� ��.