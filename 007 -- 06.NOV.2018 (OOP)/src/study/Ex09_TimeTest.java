package study;

/* Ŭ������...
 * 	1. ���赵
 * 	2. ������ �Լ��� ����
 * 	3. ����� ���� Ÿ��
 */

/* Ŭ���� ����ϴ� ���� ������� �ʴ� �ͺ���
 * 	>> �ڵ� �ߺ��� ���̰�
 * 	>> �ڵ� ������ �����ϰ� --> Ŭ���������� �ڵ� �����ϸ� �ش� Ŭ������ ��ü�� ��� �����Ϳ� �Լ��� �Բ� ���Ѵ�
 */

class Time {
	/* Ŭ������ �����Ѵٰ� �ؼ� hour, minute, second�� ��������� ����� ���� �ƴϴ�.
	 * 	>> Ŭ���� ���Ǵ� ���赵 �ۼ� --> ������ Ŭ������ ����ϴ� ���� �ƴϴ�.
	 */
	int hour;
	int minute;
	int second;

}

public class Ex09_TimeTest {
	public static void main(String[] args) {
		// ��ü�� �����ؾ� Time Ŭ������ ����������� ��������� �����.
		Time time = new Time();
		System.out.println(time.hour);
		System.out.println(time.minute);
		System.out.println(time.second);
		
		System.out.println();
		
		// main() �޼��� �����ϸ鼭 �ٷ� ��������� �����.
		int hour = 12;
		int minute = 34;
		int second = 56;
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		int hour2 = 12;
		int minute2 = 34;
		int second2 = 56;
		System.out.println(hour2);
		System.out.println(minute2);
		System.out.println(second2);
		int hour3 = 12;
		int minute3 = 34;
		int second3 = 56;
		System.out.println(hour3);
		System.out.println(minute3);
		System.out.println(second3);
		int hour4 = 12;
		int minute4 = 34;
		int second4 = 56;
		System.out.println(hour4);
		System.out.println(minute4);
		System.out.println(second4);
	}
}
