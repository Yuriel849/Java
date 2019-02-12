package study;

public class Ex10_Array10 {
	public static void main(String[] args) {
		checkArray();
		checkArray02();
	}
	
	private static void checkArray() {
		// 3ĭ¥�� �迭 2���� �ִ�. �� �迭�� ���� ���Ͽ�, ������ "�����ϴ�" ���� ������ "�ٸ��ϴ�" ����ϱ�
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,4,3};
		int flag = 0; // ���� ���� �� ������ ���µ� ����� ����
		
		if(arr1.length != arr2.length) {
			System.out.println("�� �迭�� �ٸ��ϴ�.");
		}
		
		// �� �迭�� ������ Ȯ���Ѵ�. ���� ��ġ�� ���� ��� ���ƾ� �� �迭�� ���� ���̴�
		// 3�� ���ƾ� �Ѵ� (arr1.length == 3)
		for(int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[i]) {
				flag++;
			}
		}
		if(flag == arr1.length) {
			System.out.println("�����ϴ�.");
		} else {
			System.out.println("�ٸ��ϴ�.");
		}
	}
	
	private static void checkArray02() {
		/* ���� �Ҹ��� ù��° �迭 �ӿ� �ι�° �迭�� �ִ��� �˰�ʹ�. �ι�° �迭�� �ִ���, �� �� �ִ���, �׸��� �� ��ġ�� ����϶�.
		 * arr1 = {1,2,3,4,5,6,7,8,9,10}
		 * arr2 = {5,6,7}
		 */
		int[] arr3 = {10,21,32,43,54,65,76,87,98,19,40};
		int[] arr4 = {54,62,71};
		int flag = 0;
		int loc = 0;
		
		for(int i = 0; i < arr3.length; i++) {
			for(int j = 0; j < arr4.length; j++) {
				if (arr3[i+j] != arr4[j]) {
					break;
				} else {
					flag++;
				}
				if(flag == arr4.length) {
					loc = i;
					break;
				}
			}
		}
		if(flag == arr4.length) {
			System.out.print("�迭 arr4 (");
			for(int a = 0; a < arr4.length; a++) {
				System.out.print(arr4[a]);
				if(a+1 != arr4.length) {
					System.out.print(", ");
				}
			}
			System.out.printf(")�� arr3[%d]�� �ֽ��ϴ�.", loc);
		} else {
			System.out.println("ã�� �迭�� arr3�� �����ϴ�.");
		}
	}
}




