package study;

// �����ϱ� (Bubble Sort) --> �������� / ������������ �迭�� ����
public class Ex_Array06 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for(int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] = (int)(Math.random() * 10));
		}
		System.out.println();
		
		for(int i = 0; i < numArr.length - 1; i++) {
			boolean changed = false;
			
			for(int j = 0; j < numArr.length - 1 - i; j++) {
				/* �ݺ�Ƚ�� ���� (numArr.length - 1 - i)
				 * 	>> �ݺ��� ������ �� ���� ������ �Ϸ��Ѵ�
				 * 	>> �ݺ��� ������ �� ���� �� ���ص� �ȴ�
				 * 		(>> ���ص� ������ ���ĵǾ��⿡ ��ȯ�� �Ͼ�� �ʴ´�)
				 *  	(>> ���� �ʿ� ���� ������ ������ �ʴ� ���� ȿ�����̴�)
				 */
				if(numArr[j] > numArr[j+1]) { // ������������ �����Ѵ�
						/* ������������ �����Ϸ��� if(numArr[j] < numArr[j+1])���� �񱳿������� ���⸸ ����
						 * 		>> ���� ��ġ�� ���� ���� ��ġ�� ���� ���Ͽ�, �� ū ���� �������� ���� ��ȯ
						 */
					int temp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = temp;
					changed = true;
				}
			}
			
			if(!changed) { // �ڸ��ٲ��� �Ͼ�� �ʾ����� �ݺ����� ����� --> �ڸ��ٲ��� �Ͼ�� ������ ������ �Ϸ�Ǿ��ٴ� �ǹ̴�
				break;
			}
			/* ���� ����)
			 * 	>> 8226422989
			 * 	>> 2264228899
			 * 	>> 2242268899
			 * 	>> 2222468899
			 * 
			 * �ٱ� for���� 3ȸ �ݺ����� ���� �Ϸ� --> changed == false --> break
			 * 	--> changed�� �ٲ��� �ʾҴٴ� ���� ���� ��ȯ�� �Ͼ�� �ʾҴٴ� �ǹ�
			 * 	--> �̹� ���� �Ϸ�Ǿ ��ȯ�� �Ͼ�� �ʴ� ��
			 * 	--> break�� �ݺ��� ���� 
			 */
			
			
			for(int k = 0; k < numArr.length; k++) {
				System.out.print(numArr[k]);
			}
			System.out.println();
		}
	}

}