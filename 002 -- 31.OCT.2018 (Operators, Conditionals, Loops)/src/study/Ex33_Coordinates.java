package study;

public class Ex33_Coordinates {
	public static void main(String[] args) throws Exception {
		// [x,y] 형식으로 좌표 출력하기
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
		
		// [x,y]에서 y값보다 작거나 같을 때만 좌표 출력하기
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
		
		// 왼쪽 위에서 오른쪽 아래로 대각선으로 내려가며 알파벳 출력하기
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