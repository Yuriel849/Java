package study;

// 2���� �迭
public class Ex06_Array06 {
	public static void main(String args[]) {
		/* int[][] array; 		--> 2���� �迭 ����
		 * array = new int[][]; --> 2���� �迭 �����ϰ� �� �ּҰ��� �迭�� ����
		 */
		
		/* int[] array;
		 * int[][] array2;
		 * array = new int[3][3];
		 * 		--> ����! array�� 1���� �迭, 2���� �迭�� array�� �Ҵ��� �� ����!!!
		 */
		
		int[][] score = new int[][] { {101, 102, 103},
			                     	  { 11,  12,  13},
			                     	  { 21,  22,  23},
			                     	  { 31,  32,  33},
			                     	  { 41,  42,  43}			                     	 
		                            };
	    /* new int[A][B]; --> A�� �� & B�� ���� �̷���� 2���� �迭�� ����, �ʱ�ȭ���� ���� ��
	     * new int[][] {{A,B},{C,D}, ...}; --> �ʱⰪ�� �Է��� ���� [][]�� ����ξ�� �Ѵ�
	     * 
	     * int[][] array11 = new int[][] {{},{},{}}; --> 0���� �ʱ�ȭ�� 3x1 ���
	     * int[][] array22 = new int[][] {{1,2},{3,4},{5,6}}; --> 3x2 ���
	     * array22[0]; --> array22 2���� �迭�� ù��° �� ��ü�� �ǹ� --> {1,2}
	     * array22[0][0]; --> array22 2���� �迭�� ù��° ���� ù��° ���� �� --> '1'
	     */
		                            
		for(int i = 0; i < score.length; i++){
	        for(int j = 0; j < score[i].length; j++){
	        	System.out.println(score[i][j]);
	        }
	    }
		
		for(int i = 0; i < score.length; i++){
	        for(int j = 0; j < score[i].length; j++){
	        	score[i][j] = i;
	        	System.out.println(score[i][j]);
	        }
	    }
		                            
	}

}