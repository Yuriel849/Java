package exercises.byChapter.chapter_14;

import java.util.Random;
import java.util.stream.*;

// ������ �ζǹ�ȣ(1~45)�� �����ؼ� ����϶�.

class Exercise14_07 {
	public static void main(String[] args) {
		IntStream intSt = new Random().ints(6, 1, 46);
		
		intSt.sorted().forEach(System.out::println);
	} // main() ��.
} // Ŭ���� ��.