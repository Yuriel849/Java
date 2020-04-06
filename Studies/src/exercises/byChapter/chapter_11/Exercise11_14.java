package exercises.byChapter.chapter_11;

import java.util.*;

// ����ó�� ���α׷��� �Ϻ��̴�. ScannerŬ������ �̿��ؼ� ȭ�����κ��� �����͸� �Է��ϰ� �����ִ� ����� �ϼ��϶�.

class Exercise11_14 {
	@SuppressWarnings("rawtypes")
	static ArrayList record = new ArrayList(); // ���������͸� ������ ����
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		while(true) {
			switch(displayMenu()) {
				case 1 :
					inputRecord();
					break;
				case 2 :
					displayRecord();
					break;
				case 3 :
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
			}
		} // while(true) ��.
	} // main() ��.

	// menu�� �����ִ� �޼���
	static int displayMenu(){
		System.out.println("**************************************************");
		System.out.println("* ���� ���� ���α׷� *");
		System.out.println("**************************************************");
		System.out.println();
		System.out.println(" 1. �л����� �Է��ϱ� ");
		System.out.println();
		System.out.println(" 2. �л����� ����");
		System.out.println();
		System.out.println(" 3. ���α׷� ���� ");
		System.out.println();
		System.out.print("���ϴ� �޴��� �����ϼ���.(1~3) : ");
		
		int menu = 0;
		
		// 1. ȭ�����κ��� �޴��� �Է¹޴´�. �޴��� ���� 1~3������ ���̾�� �Ѵ�.
		while(true) {
			menu = scan.nextInt();
			// 2. 1~3������ ���� �Է¹��� ������, �޴��� ������ �߸��Ǿ����� �˷��ְ� �ٽ� �Է¹޴´�.(��ȿ�� ���� �Է¹��� ������ �ݺ��ؼ� �Է¹޴´�.)
			if(menu < 1 || 3 < menu) {
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�. �ٽ� �Է����ּ���!");
			} else {
				break;
			}
		}
		
		

		return menu;
	} // displayMenu() ��.
	
	// �����͸� �Է¹޴� �޼���
	@SuppressWarnings("unchecked")
	static void inputRecord() {
		System.out.println("1. �л����� �Է��ϱ�");
		System.out.println("�̸�,��,��ȣ,�����,�����,���м���'�� ������ ������� �Է��ϼ���.");
		System.out.println("�Է��� ��ġ���� q�� �Է��ϼ���. ����ȭ������ ���ư��ϴ�.");
		while(true) {
			System.out.print(">>");
			
			// 1. Scanner�� �̿��ؼ� ȭ������ ���� �����͸� �Է¹޴´�.(','�� �����ڷ�)
			try {
				String[] input = scan.nextLine().split(",");
				// 2. �Է¹��� ���� q �Ǵ� Q�̸� �޼��带 �����ϰ�, �׷��� ������ �Է¹��� ������ Student6�ν��Ͻ��� �����ϰ� record�� �߰��Ѵ�.
				if(input[0].equalsIgnoreCase("q")) { return; }
				else {
					Student6 std = new Student6(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]),
							Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]));
					record.add(std);
				}
			} catch(Exception e) {
				// 3. �Է¹��� �����Ϳ��� ���ܰ� �߻��ϸ�, "�Է¿����Դϴ�."�� �����ְ� �ٽ� �Է¹޴´�.
				System.out.println("�Է¿����Դϴ�.");
			}
		} // while ��.
	} // inputRecord() ��.
	
	// ������ ����� �����ִ� �޼���
	static void displayRecord() {
		int koreanTotal = 0;
		int englishTotal = 0;
		int mathTotal = 0;
		int total = 0;
		int length = record.size();
		if(length > 0) {
			System.out.println();
			System.out.println("�̸� �� ��ȣ ���� ���� ���� ���� ��� ������� �ݵ��");
			System.out.println("====================================================");
			for (int i = 0; i < length ; i++) {
				Student6 Student6 = (Student6)record.get(i);
				System.out.println(Student6);
				koreanTotal += Student6.kor;
				mathTotal += Student6.math;
				englishTotal += Student6.eng;
				total += Student6.getTotal();
			} // for�� ��.
			System.out.println("====================================================");
			System.out.println("����: "+koreanTotal+" "+englishTotal +" "+mathTotal+" "+total);
			System.out.println();
		} else {
			System.out.println("====================================================");
			System.out.println(" �����Ͱ� �����ϴ�.");
			System.out.println("====================================================");
		}
	} // displayRecord() ��.
} // Ŭ���� ��.

@SuppressWarnings("rawtypes")
class Student6 implements Comparable {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	int total;
	int schoolRank;
	int classRank; // �ݵ��
	
	// ������
	Student6(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		total = kor+eng+math;
	}
		
	int getTotal() {
		return total;
	}
		
	float getAverage() {
		return (int)((getTotal()/ 3f)*10+0.5)/10f;
	}
		
	public int compareTo(Object o) {
		if(o instanceof Student6) {
			Student6 tmp = (Student6)o;
			return tmp.total - this.total;
		} else {
			return -1;
		}
	}
		
	public String toString() {
		return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + ","
				+ getTotal() + "," + getAverage() + "," + schoolRank + "," + classRank;
	}
} // Student6 Ŭ���� ��.
