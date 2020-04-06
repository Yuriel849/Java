package exercises.byChapter.chapter_04;

class Exercise04_15 {
	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		
		int result = 0; // ���� number�� �Ųٷ� ��ȯ�ؼ� ���� ����
		String str = "";

		while(tmp != 0) {
			str += tmp % 10;
			// alternative
			// result = result*10 + tmp%10; // ���� ����� 10�� ���ؼ� ���Ѵ�.
			tmp /= 10;
		}
		result = Integer.parseInt(str);
		
		if(number == result) {
			System.out.println(number + "�� ȸ�����Դϴ�.");
		} else {
			System.out.println(number + "�� ȸ������ �ƴմϴ�.");
		}
	} // main() ��.
} // Ŭ���� ��.