package study;

import java.util.Scanner;

public class BingoScanner {
	public static int main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		do {
			System.out.println("���� �ϳ��� �Է��ϼ��� (1 ~ 25) >>");
			System.out.print("�Է��� ����Ͻ÷��� ������ �Է��ϼ���.");
			// printf()������ \n�� %n�� ��ü�� �� �ִ�!!!
			input = scan.nextInt();
			if (input < 0) {
				System.out.println("�Է��� ����ϼ̽��ϴ�.");
				System.out.println("���� ����� ����մϴ�.");
				break;
			}
//			if(input >= 1 && input <= 25) {
//				break;
//			}
		} while (input < 1 || input > 25);
		
		return input;
	}

}
