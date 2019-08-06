package study;

import java.io.File;
import java.util.Scanner;

class Ex06_Scanner {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File ("data2.txt")); // PackageExplorer >> File >> New >> File (���� ����)
															// �� File�� ��ġ�� Project ���� �ٷ� �ؿ� (�ٸ� ���� ���� ����)
		int sum = 0;
		int cnt = 0;
		
		while(scan.hasNextInt()) {
			sum += scan.nextInt();
			cnt++;
		}
		
		System.out.println("sum = " + sum);
		System.out.println("average = " + (double)sum/cnt);
	} // main() ��.
}
