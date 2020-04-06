package exercises.byChapter.chapter_13;

import java.util.*;

// WordGenerator �����尡  Vector�� 2�ʸ��� �ܾ �ϳ��� �߰��ϰ�,
// 	����ڰ� �ܾ �Է��ϸ� Vector���� ��ġ�ϴ� �ܾ �����ϵ��� �Ǿ� �ִ�.
//	>> WordGenerator�� run()�� �ϼ��϶�.

class Exercise13_08 {
	@SuppressWarnings("rawtypes")
	Vector words = new Vector();
	String[] data = {"�¿�","����","����","ȿ��","����","����","Ƽ�Ĵ�","���","����ī"};

	int interval = 2 * 1000; // 2��
	
	WordGenerator wg = new WordGenerator();
	
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {
		Exercise13_08 game = new Exercise13_08();
		
		game.wg.start();
	
		Vector words = game.words;
	
		while(true) {
			System.out.println(words);
			String prompt = ">>";
			System.out.print(prompt);

			// ȭ�����κ��� ���δ����� �Է¹޴´�.
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine().trim();
	
			int index = words.indexOf(input);
			if(index!=-1) {
				words.remove(index);
			}
		}
	} // main() ��.

	class WordGenerator extends Thread {
		@SuppressWarnings("unchecked")
		public void run() {
			// 1. interval(2��)���� �迭 data�� �� �� �ϳ��� ���Ƿ� �����ؼ�,
			while(true) {
				int r = (int)(Math.random() * data.length);
				// 2. words�� �����Ѵ�.
				words.add(data[r]);

				try {
					Thread.sleep(interval);
				} catch(Exception e) {}
			} // while�� ��.
		} // run() ��.
	} // WordGenerator ���� Ŭ���� ��.
} // ũ����  ��.