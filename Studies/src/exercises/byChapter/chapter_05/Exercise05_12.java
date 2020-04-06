package exercises.byChapter.chapter_05;

import java.util.Scanner;

class Exercise05_12 {
	public static void main(String[] args) {
		String[][] words = {
				{"chair", "����"}, // words[0][0], words[0][1]
				{"computer", "��ǻ��"}, // words[1][0], words[1][1]
				{"integer", "����"} // words[2][0], words[2][1]
		};
		
		int cnt = 0; // ���� ������ ���� �����ϱ� ���� ����
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < words.length; i++) {
			System.out.printf("Q%d. %s�� ����? ", i+1, words[i][0]);
			
			String tmp = scan.nextLine();
			
			if(tmp.equals(words[i][1])) {
				System.out.printf("�����Դϴ�.%n%n");
				cnt++;
			} else {
				System.out.printf("Ʋ�Ƚ��ϴ�. ������ %s�Դϴ�.%n%n", words[i][1]);
			}
		} // for�� ��.
		
		System.out.printf("��ü 3���� �� %d���� ���߼̽��ϴ�.", cnt);
	} // main() ��.
} // Ŭ���� ��.