package collectionsFramework;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class E05_BingoWithSetAndIterator {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) { 
		Set set = new LinkedHashSet();
		/* HashSet --> 순서는 없지만 나름의 규칙에 따라 값을 저장한다 --> 여기 코드 실행하면 비슷한 숫자끼리 뭉치는 현상 발생
		 * 		   --> 골고루 섞기 위해 순서를 유지하는 LinkedHashSet 사용한다.
		 */
		int[][] board = new int[5][5];
		
		for(; set.size() < 25;) {
			set.add((int)(Math.random()*50) + 1 + ""); // Add empty string to turn random value into string
		}
		
		Iterator it = set.iterator();		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
	}
}