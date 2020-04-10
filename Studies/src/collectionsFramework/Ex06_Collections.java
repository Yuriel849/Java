package collectionsFramework;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class Ex06_Collections {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		int[][] board = new int[5][5];
		
		for(; set.size() < 25;) {
			set.add((int)(Math.random() * 30) + 1 + ""); // Random int between 1 ~ 30
		}
		
		Iterator it = set.iterator();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		} // for loop
	}
}