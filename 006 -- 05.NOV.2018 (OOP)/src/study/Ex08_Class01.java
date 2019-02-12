package study;

public class Ex08_Class01 {
	public static void main(String[] args) {
		Time time = new Time();
		
		System.out.println(time.hour);
		System.out.println(time.minute);
		System.out.println(time.second);

		// int[] t = new int[3]; --> �񱳿�
		Time[] time2 = new Time[3];
			/* Time Ÿ���� �����͸� ���� �� �ִ� 3ĭ¥�� "time2"��� �θ��� �迭 ����
			 * 		--> �� ĭ���� (�⺻���� �ƴϴϱ�) �ּҰ��� ���� �� �ִ�
			 * 		--> �ʱ�ȭ���� �ʴ´�
			 * 		--> �����ϸ� ������ ���󰬴µ�, �װ����� �ƹ��͵� �����ϱ� null�̶�� ������
			 */
		// �Ʒ� 3�� ���๮(Lines 19~21)�� ������ NullPointerException �߻�
		time2[0] = new Time(); // time2 �迭�� �� ĭ�� Time�� ��ü�� �����Ͽ� �� �ּҰ��� ����
		time2[1] = new Time(); // 		--> ���� �����Ͽ� �迭�� ĭ�� ã�ư��� Time�� ��ü�� ���� ���̴�
		time2[2] = new Time();
		
		System.out.println(time2[0]);
			/* time2 �迭�� ù��° ĭ�� ��� ���� ��ȯ
			 * 		--> ��ü�� �ּҰ�
			 * 		--> "study.Time@1175e2db"
			 * 		--> study��� package�� Time�̶�� Ŭ���� + 16���� �ּҰ�
			 */

		time2[0].hour = 10;
		time2[0].minute = 20;
		time2[0].second = 30;
		time2[1].hour = 40;
		time2[1].minute = 50;
		time2[1].second = 60;
		time2[2].hour = 70;
		time2[2].minute = 80;
		time2[2].second = 90;
		
		System.out.println(time2[0].hour);
		System.out.println(time2[0].minute);
		System.out.println(time2[0].second);
		System.out.println(time2[1].hour);
		System.out.println(time2[1].minute);
		System.out.println(time2[1].second);
		System.out.println(time2[2].hour);
		System.out.println(time2[2].minute);
		System.out.println(time2[2].second);
	}

}