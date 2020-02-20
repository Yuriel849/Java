package exercises;

import java.util.Scanner;

public class BaseballGame {
	public static void main(String[] args) {
		int[] std = new int[3];
		int[] entry = new int[3];
		int cnt = 0;
		
		// Generate three distinct integers and store in an array
		for(int i = 0; i < std.length; i++) {
			do {
				std[i] = (int)((Math.random() * 9) + 1); // Math.random() returns 0.0 <= n < 1.0
			} while((i == 0) ? false : ((i == 1) ? (std[i] == std[0]) : (std[i] == std[0] || std[i] == std[1])));
		}
	
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("3자리 정수를 입력해주세요 : ");
			int input = scan.nextInt();
			
			for(int k = 0; k < entry.length; k++) {
				entry[2-k] = input%10;
				input /= 10;
			}
			
			int b = 0; // ball --> same number, different position
			int s = 0; // strike --> same number and position
			
			for(int i = 0; i < std.length; i++) {
				for(int k = 0; k < entry.length; k++) {
					if (std[i] == entry[k]) {
						if (i != k) {
							b++;
						} else {
							s++;
						}
					}
				}
			}
			
			System.out.printf("%dS%dB\n", s, b);
			cnt++;
			
			if(s == 3) {
				System.out.printf("%d번만에 맞추셨습니다!!", cnt);
				break;
			}
		}
		scan.close();
	}
}