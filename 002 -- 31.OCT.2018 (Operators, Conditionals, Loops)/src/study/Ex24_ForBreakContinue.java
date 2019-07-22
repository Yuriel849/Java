package study;

public class Ex24_ForBreakContinue {
	public static void main(String[] args) {
		System.out.println("Break");
		for(int i = 1; i<=10; i++) {
			if(i == 5) {
				break;
			}
			System.out.println(i);
		}
		System.out.println("\nContinue");
		for(int i = 1; i<=10; i++) {
			if(i == 5) {
				continue;
			}
			System.out.println(i);
		}
	}

}
