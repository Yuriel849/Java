package pool;

@SuppressWarnings("rawtypes")
public class Student implements Comparable {
	private String name;
	private int ban;
	private int no;
	private int kor, eng, math, total;
	private int schoolRank, classRank;
	
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		total = kor + eng + math;
	}
	
	public int getBan() {
		return ban;
	}
	
	public int getNo() {
		return no;
	}

	public int getKor() {
		return kor;
	}

	public int getMath() {
		return math;
	}

	public int getEng() {
		return eng;
	}
	
	public int getSchoolRank() {
		return schoolRank;
	}
	
	public void setSchoolRank(int schoolRank) {
		this.schoolRank = schoolRank;
	}

	public int getClassRank() {
		return classRank;
	}
	
	public void setClassRank(int classRank) {
		this.classRank = classRank;
	}
	
	public int getTotal() {
		return total;
	}
	
	public	float getAverage() {
		return (int)((getTotal() / 3f) * 10 + 0.5) / 10f;
	}
	
	public String toString() {
		return
				name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + ","
				+ getTotal() + "," + getAverage() + "," + schoolRank + "," + classRank;
	}
	
	public int compareTo(Object o) {
		// Sort by total score, ascending
		if(o instanceof Student) {
			Student tmp = (Student) o;
			return tmp.getTotal() - this.getTotal();
		}
		return -1;

		// Sort by name, alphabetical order
//		String myName = this.name;
//		String yourName = "";
//
//		if(o instanceof Student) {
//			yourName = ((Student) o).name;
//		}
//		
//		return myName.compareTo(yourName);
	}
}