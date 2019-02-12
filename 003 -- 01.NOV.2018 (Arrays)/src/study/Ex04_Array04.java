package study;

import java.util.Scanner;

public class Ex04_Array04 {
	public static void main(String args[]) {
		// 3������ ������ �Է¹޾Ƽ� ����, ��� ���ϱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���� �Է��� �ּ��� : ");
		int subject_number = sc.nextInt();
		
		// �迭 : index 0, 1, 2 <-- ���� ����, index 3 <-- ����
		int[] score = new int[subject_number+1];
			// score.length <-- 4
			// �ε����� �ִ� = �迭�� ũ�� - 1
		float average;
		
		// index 1 ~ 2 ���� 3������ ������ �Է��ϸ鼭 index 3�� ���� ���������ϱ�
		for(int i = 0; i < score.length-1 ; i++) {
			System.out.printf("%d ��° ������ �Է��ϼ��� : ", (i+1));
			// ���� �Է�
			score[i] = sc.nextInt();
			// ���� : ���� �������� --> score[3] += score[i];
			score[score.length-1] += score[i];
		}
		
		// average = (float)score[3] / 3;
		average = (float)score[subject_number] / (score.length-1);
		/* A / (score.length-1) --> ��ȣ�� �ؾ��� ������� ����̵ȴ�
		 * 						--> ��ȣ�� ������ ������ �� ���⸦ �ǽ��Ѵ� -> (A / score.length) - 1
		 */
		
		// System.out.printf("���� : %d��, ��� : %.2f��", score[3], average);	
		System.out.printf("���� : %d��, ��� : %.2f��", score[score.length-1], average);	
	}

}
