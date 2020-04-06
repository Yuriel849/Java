package exercises.byChapter.chapter_04;

// 2x + 4y = 10�� ��� �ظ� ���϶� (0<=x<=10, 0<=y<=10)

public class Exercise04_08 {
	public static void main(String[] args) {
		for(int x = 0; x <= 10; x++) {
			for(int y = 0; y <= 10; y++) {
				if(2*x + 4*y == 10) {
					System.out.println("x = " + x + ", y = " + y);
				}
			}
		} // �ٱ� for��.
	} // main() ��.
} // Ŭ���� ��.