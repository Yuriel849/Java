package exercises.byChapter.chapter_04;

// ������ �� �ڸ��� ���ؼ� ���� ���϶� (12345 --> 1 + 2 + 3 + 4 + 5)

public class Exercise04_10 {
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			sum += num % 10;
			num = num / 10;
		}
		
		System.out.println("sum = " + sum);
	} // main() ��.
} // Ŭ���� ��.