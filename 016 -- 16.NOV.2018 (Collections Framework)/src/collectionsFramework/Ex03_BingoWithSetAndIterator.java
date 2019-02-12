package collectionsFramework;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class Ex03_BingoWithSetAndIterator {
	public static void main(String[] args) {
//		Set set = new HashSet(); // HashSet�� ������ ������ ������ ��Ģ�� ���� ���� �����Ѵ� --> �Ʒ� �ڵ带 �����ϸ� ����� ���ڳ��� ��ġ�� ���� �߻� 
		Set set = new LinkedHashSet(); // ���� ���� ���� ������ �����ϴ� LinkedHashSet ����Ѵ�.
		int[][] board = new int[5][5];
		
		for(int i = 0; set.size() < 25; i++) {
			set.add((int)(Math.random()*50) + 1 + ""); // ���� ���ڿ��� ���������ϸ鼭 ������ �������� ���ڿ� ���·� add�ȴ�.
		}
		
		Iterator it = set.iterator();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
	} // main() ��.
} // Ŭ���� ��.
