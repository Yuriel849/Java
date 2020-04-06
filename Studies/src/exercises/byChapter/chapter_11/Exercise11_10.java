package exercises.byChapter.chapter_11;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// ��������  1~30 ������ ���ڷ� ä���, �����

class Exercise11_10 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
//		Set set = new HashSet(); // HashSet�� ���� ������ ��Ģ�� ���� ���� �����Ѵ� --> ����� ���ڳ��� ��ġ�� ���� �߻� 
		Set set = new LinkedHashSet(); // ���� ���� ���� ������ �����ϴ� LinkedHashSet ����Ѵ�.
		int[][] board = new int[5][5];
		
		for(int i = 0; set.size() < 25; i++) {
			set.add((int)(Math.random() * 30) + 1 + "");
		}
		
		Iterator it = set.iterator();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
					// ������ ��� ���� �����ϱ� ���Ͽ�, ���� 10���� ������ �տ� ���� 2ĭ�� ���̰�, ���� ������ ���� 1ĭ�� ���δ�.
			}
			System.out.println();
		}
	} // main() ��.
} // Ŭ���� ��.