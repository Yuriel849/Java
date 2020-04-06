package exercises.byChapter.chapter_05;

import java.util.Scanner;

// �ܾ��� ���� ��ġ�� ��� �����ְ� ������ �ܾ ���ߴ� ���α׷��� �ۼ��϶�.

class Exercise05_13 {
	public static void main(String[] args) {
		String[] words = { "television", "computer", "mouse", "phone" };

		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray(); // String�� char[]�� ��ȯ
			
			for(int j = 0; j < question.length; j++) {
				int k = (int)(Math.random() * question.length);
				char tmp = question[0];
				question[0] = question[k];
				question[k] = tmp;
			}
			
			System.out.printf("Q%d. %s�� ������ �Է��ϼ��� >>", i+1, new String(question));
			String answer = scan.nextLine();
			
			// trim()���� answer�� �¿� ������ ������ ��, equals�� word[i]�� ��
			if(words[i].equals(answer.trim())) {
				System.out.printf("�¾ҽ��ϴ�.%n%n");
			} else {
				System.out.printf("Ʋ�Ƚ��ϴ�.%n%n");
			}
		} // for�� ��.
	} // main() ��.
} // Ŭ���� ��.