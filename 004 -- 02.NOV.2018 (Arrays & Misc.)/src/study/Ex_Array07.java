package study;

/* �󵵼� ���ϱ� (Counting)--> �迭�� � ���� �� �� ����Ǿ� �ִ��� ��� �����ش�.
 * 
 * Counting �� �� �ڷ�� ���� �� �� �ִ� ��
 * 	>> ���� --> �̰��� bucket sort
 * 	>> �ߺ�����
 * 		>> counting �� bucket sort�� �� ���� counting�ϸ� �Ǳ⿡ ������ ȿ�����̴�
 * 			<--> bubble sort�� �ſ� ���� �ݺ��ϸ鼭 �����ϱ⿡ ��ȿ���� (�ڵ�� ����������...)
 */

public class Ex_Array07 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		int[] counter = new int[10];
		
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = (int)(Math.random() * 10);
			System.out.print(numArr[i]);
		}
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < numArr.length; i++) {
			counter[numArr[i]]++;
		} 
		for(int i = 0; i < numArr.length; i++) {
			System.out.println(i + "�� ���� :" + counter[i]);
		}
		System.out.println();
		
		// �ߺ����� --> if counter[i] not empty print i
		for(int i = 0; i < counter.length; i++) {
			if(counter[i] != 0) {
				System.out.print(i);
			}
		}
		System.out.println();
		System.out.println();
		
		// �����ϱ� --> if counter[i] not empty print i as many times as counter[i]
		for(int i = 0; i < counter.length; i++) {
			if(counter[i] != 0) {
				for(int j = 0; j < counter[i]; j++) {
					System.out.print(i);
				}
			}
		}
		System.out.println();
	}

}