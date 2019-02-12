package study;

import java.util.Scanner;

public class Ex01_BaseballGame {
	public static void main(String[] args) {
		/* 1. 1 ~ 9 ������ ���ڷ� �̷���� 3�ڸ� ����(�ߺ� X)�� ���Ƿ� ����
		 * 		>> use Math.random() to get digits b/w 0 ~ 9
		 * 		>> put digits into 3-element array
		 * 		>> if digits are the same as previous, get new digit
		 * 2. �ݺ������� 3�ڸ� ������ �Է¹޴´�.
		 * 		>> Scanner & while loop
		 * 		>> take user input and put into 3-element array
		 * 3. �Է¹��� ���ڿ� (1)�� ���ڸ� ���ؼ� ����� ��� (ex) 1S2B)
		 * 4. �񱳰���� 3S0B �� ������ (2)~(3) �ݺ� ����
 		 * 		>> incl. if and break to escape loop when 3S0B
		 * 5. �� �� ���� ������� �Է�Ƚ�� ��� 
		 * 		>> keep count of how many loops
		 */
		
		
		int[] std = new int[3];
		int[] entry = new int[3];
		int cnt = 0;
		
		// ��� 01 --> ������ 3�ڸ� ���� ����
		for(int i = 0; i < std.length; i++) {
			do {
				std[i] = (int)((Math.random() * 9) + 1);
			} while((i == 0) ? false : ((i == 1) ? (std[i] == std[0]) : (std[i] == std[0] || std[i] == std[1])));
		}

		// ��� 02 --> ������ 3�ڸ� ���� ����
//		int[] ran = new int[9];
//		int temp, j;
//		for(j = 1; j < 10; j++) {
//			ran[j-1] = j;
//		}
//		for(int k = 0; k < 100; k++) {
//			j = (int)(Math.random() * 9);
//			temp = ran[0];
//			ran[0] = ran[j];
//			ran[j] = temp;
//		}
//		for(j = 0; j < 3; j++) {
//			std[j] = ran[j];
//		}
	
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("3�ڸ� ������ �Է����ּ��� : ");
			int input = scan.nextInt();
			for(int k = 0; k < entry.length; k++) {
				entry[2-k] = input%10;
				input /= 10;
			}
			
			// ball --> ���� ���ڰ� �ִµ�, ��ġ�� �ٸ� ��
			int b = 0;
			// strike --> ���� ���ڰ� �ִµ�, ��ġ�� ���� ��
			int s = 0;
			
			for(int i = 0; i < std.length; i++) {
				for(int k = 0; k < entry.length; k++) {
					if (std[i] == entry[k]) { // �� ���� ���� ��, ball or strike
						if (i != k) { // ���� ������ ��ġ�� �ٸ� ��
							b++;
						} else { // ���� ������ ��ġ�� ���� ��
							s++;
						}
					}
				}
			}
			System.out.printf("%dS%dB\n", s, b);
			cnt++;
			if(s == 3) {
				System.out.printf("%d������ ���߼̽��ϴ�!!", cnt);
				break;
			}
		}
		scan.close();
	}
}

