package study;

import java.util.Scanner;

public class Ex_Scanner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�� �ڸ� ������ �ϳ� �Է��ϼ��� >> ");
		String input = scan.nextLine();
		int num = Integer.parseInt(input);
		
		System.out.println("�Է³��� : " + input);
		System.out.printf("num = %d%n", num);
	}

}
