package study;

public class Ex02_Variable01 {
	public static void main(String args[]) {
		
		int number;
		number = 100;
		
		// 2byte 크기의 정수 공간을 확보하고 score라는 이름표를 붙인다.
		short score; // short 타입은 2byte 크기
		score = 20;
		
		System.out.printf("1. number = %d%n", number);
		System.out.printf("2. score = %d%n", score);
	}
}