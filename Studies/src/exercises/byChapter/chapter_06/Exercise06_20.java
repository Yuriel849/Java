package exercises.byChapter.chapter_06;

// shuffle() �޼��带 �ۼ��϶�.

public class Exercise06_20 {
	public static void main(String[] args) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		System.out.println(java.util.Arrays.toString(original));
	}
	
	static int[] shuffle(int[] arr) {
		// int[] ARR = arr;
		/* shuffle(original) ����
		 * 	>> original�̶�� ������ ����� �ּҰ� ����
		 * 	>> shuffle �޼����� �Ű������� �ּҰ� ����
		 * 	>> ARR�� �ּҰ� ����
		 * 		>> ARR�� original�� ���� �迭�� �����ϰ� �ִ�.
		 */
		
		if(arr==null || arr.length == 0) { return arr; }
		/* ��ȿ��üũ
		 * 	>> �Ű������� ������ �迭�� null�̰ų� ���� 0�� �� ó���ϱ� ���� �ڵ�
		 */
		
		int temp;
		for(int i = 0; i < 100; i++) {
			int j = (int)(Math.random() * 7 + 1);
			temp = arr[0];
			arr[0] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}
}
