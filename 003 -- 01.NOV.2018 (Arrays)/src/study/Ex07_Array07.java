package study;

// �����迭
public class Ex07_Array07 {
	public static void main(String[] args) {
		int[][] score = new int[5][];
		
		/* �����迭�� �迭�� ��� ������ �ٸ� �ʿ䰡 ���� --> �迭�� ��� ������ �Ȱ��� ���� ���� �ִ�.
		 * the following is an example
		 */
		score[0] = new int[4];
		score[1] = new int[3];
		score[2] = new int[2];
		score[3] = new int[2];
		score[4] = new int[3];
		
		/* score.length    --> 2���� �迭���� length �Լ��� ����ϸ� ���� ������ ��ȯ�Ѵ�
		 * score[A].length --> 2���� �迭�� Ư�� �࿡�� length �Լ��� ����ϸ� �� ���� ���� ������ ��ȯ�Ѵ�
		 */
		for(int i = 0; i<score.length; i++) {
			for(int j = 0; j<score[i].length; j++) {
				score[i][j] += i;
				System.out.printf("score[%d][%d] : %d\n", i, j, score[i][j]);
			}
		}
	}

}
