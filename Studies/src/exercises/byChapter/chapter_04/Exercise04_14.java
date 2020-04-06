package exercises.byChapter.chapter_04;

class Exercise04_14 {
	public static void main(String[] args) {
		// 1 ~ 100 ������ ������ ���� �� answer�� �����Ѵ�.
		int answer = (int)(Math.random() * 100 + 1);
		int input = 0; // ����� �Է��� ������ ����
		int count = 0; // �õ�Ƚ���� �������� ����
		
		// ȭ�����κ��� ����� �Է��� �ޱ� ���ؼ� Scanner Ŭ���� ���
		java.util.Scanner s = new java.util.Scanner(System.in);
		
		do {
			count++;
			System.out.print("1�� 100 ������ ���� �Է��ϼ��� :");
			input = s.nextInt(); // �Է¹��� ���� ���� input�� �����Ѵ�.
			
			if(answer == input) {
				System.out.println("������ϴ�.\n�õ�Ƚ���� " + count + "���Դϴ�.");
				break;
			} else if (answer > input) {
				System.out.println("�� ū ���� �Է��ϼ���.");
			} else if (answer < input) {
				System.out.println("�� ���� ���� �Է��ϼ���.");
			}
			
		} while(true); // ���ѹݺ���
	} // main() ��.
} // Ŭ���� ��.