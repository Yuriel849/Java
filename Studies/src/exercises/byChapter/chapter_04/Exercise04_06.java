package exercises.byChapter.chapter_04;

// 2���� �ֻ����� ������ ���� ���� 6�϶��� ����ϴ� ���α׷��� �ۼ��϶�.

public class Exercise04_06 {
	public static void main(String[] args) {
		for(int i = 1; i < 7; i++) {
			for(int j = 1; j < 7; j++) {
				if(i+j == 6) {
					System.out.printf("[ i = %d, j = %d ]\n", i, j);
				}
			}
		} // �ٱ� for��.
	} // main() ��.
} // Ŭ���� ��.