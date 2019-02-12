package study;

public class Ex12_Array12 {
	public static void main(String[] args) {
		noCheckRepetition();
		checkRepetition();
		baseballGame();
	}
	
	private static void noCheckRepetition() {
		// �� �迭�� ���� ���ڰ� ��� �ִ��� ��� ����϶�.
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,1,3,1,1,};
		int cnt = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					cnt++;
				}
			}
		}
		System.out.println("���� ������ ���� = " + cnt);
	}
	
	// INCOMPLETE!!! --> rethink the logic...
	private static void checkRepetition() {
		// �� �迭�� ���� ���ڰ� ��� �ִ��� ����, �ٸ� �ߺ��Ǵ� ���� �ߺ��Ͽ� ���� �ʴ´�.
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,1,3,1,1,};
		int array;
		if (arr1.length >= arr2.length) {
			array = arr1.length;
		} else {
			array = arr2.length;
		}
		int[] cnt = new int[array];
		int a = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					for(int k = 0; k < cnt.length; k++) {
						if(cnt[k] == arr1[i]) {
							break;
						} else {
							a++;	
						}
					}
				}
			}
		}
		System.out.println("���� ������ ���� = " + a);
	}
	
	private static void baseballGame() {
		// �� �迭�� ���� ���ڰ� ��� �ִ��� ��� ����϶�.
		int[] arr1 = {1,2,3};
		int[] arr2 = {2,1,3};

		// ball ���� ���ڰ� �ִµ�, ��ġ�� �ٸ� ��
		int b = 0;
		// strike ���� ���ڰ� �ִµ�, ��ġ�� ���� ��
		int s = 0;
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) { // �� ���� ���� ��, ball or strike
					if (i != j) { // ���� ������ ��ġ�� �ٸ� ��
						b++;
					} else { // ���� ������ ��ġ�� ���� ��
						s++;
					}
				}
			}
		}
		System.out.printf("%dS%dB\n", s, b);
	}
}

