package study;

public class Coordinates {
	public static void main(String[] args) throws Exception {
		// ��ǥ ��� --> ���� ��ü ��ǥ�� ��ġ Ȯ��
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(true) {
					System.out.print("[" + i + "," + j + "]");
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		// ��� ���� ��ǥ�� ���� ������ �ֱ�
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i >= j) {
					System.out.print("[" + i + "," + j + "]");
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(i<=j) {
					System.out.print((char) (j+'A'-i));
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
		
	}

}
