package study;

import java.util.Arrays;

public class Ex08_Array08 {
	public static void main(String[] args) {
		int[] score = new int[5];
		score[0] = 100;
		score[1] = 90;
		score[2] = 80;
		score[3] = 70;
		score[4] = 60;
		/* score[5] = 50;
		 * 	>> �迭�� score[0] ~ score[4]������ ����
		 * 	>> �ڵ带 �ۼ��� ���� ���� �ȳ����� �����ϸ� ����
		 */
		
		int[] score1 = {100, 90, 80, 70, 60};
		
		for(int i = 0; i < 5; i++) {
			System.out.println(score1[i]);
		}
		
		int[] score2;
		score2 = new int [] {100, 90, 80, 70, 60};
				
		// �迭�� ������ �� ���� ���
		System.out.println(Arrays.toString(score2));
		
		// score.length -> �迭�� ���� ��ȯ --> �迭�� ��� ���� �ٲ㵵 ���� ���� for���� �ݿ�
		for(int i = 0; i < score.length; i++) {
			System.out.println(score1[i]);
		}
	}

}
