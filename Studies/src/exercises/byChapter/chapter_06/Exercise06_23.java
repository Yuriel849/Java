package exercises.byChapter.chapter_06;

// �־��� int�� �迭�� �� �߿��� ���� ū ���� ��ȯ�϶�.

public class Exercise06_23 {
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("�ִ밪:" + max(data));
		System.out.println("�ִ밪:" + max(null));
		System.out.println("�ִ밪:" + max(new int[] {})); // ũ�Ⱑ 0�� �迭
	}
	
	// ���� �־��� �迭�� null�̰ų� ũ�Ⱑ 0�� ���, -999999�� ��ȯ�Ѵ�.
	static int max(int[] arr) {
		if(arr == null || arr.length == 0) { return -999999; }
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) { max = arr[i]; }
		}
		return max;
	}
}
