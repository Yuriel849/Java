package study;

import java.util.Calendar;
import java.util.Date;

public class Ex07_Date_Calendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // ���� ��¥�� �ð����� Calendar ��ü ����
		Calendar cal2 = Calendar.getInstance();
		
		System.out.println("���� ��¥�� �ð����� Calendar ������ ����");
		System.out.println(cal);
		System.out.println(cal2);
		
		cal.clear(); // ������ ������ ��¥�� �ð��� ���� --> ���Ӱ� ������ �� �ִ�
		cal2.clear(); // clear() ������� �ʰ� set()�ϸ� ���� �ٸ� ���� ����ȴ� --> �ð��� nanosecond �������� ����ϱ� �����̴�
		
		System.out.println("clear()�� ���� ���� ���� ����");
		System.out.println(cal); // clear()�� ���¿��� ���� ��� "?"�̰ų� �ʱⰪ�� ���� �� ���� �ִ�
		
		cal.set(2008, 10, 13); // Month�� 0�� January, Date�� �츮�� �ƴµ���
		cal2.set(2008, 10, 13);
		
		System.out.println("set()���� ��,��,�� ���Ӱ� ���� ����");
		System.out.println(cal); // clear() �� set()�ϸ鼭 set�� �� ������ ���鸸 ä���� ���� �� ���� �ִ�
		System.out.println(cal2);
		
		System.out.println();
		System.out.println(cal.equals(cal2));
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		System.out.println(new Date(cal.getTimeInMillis())); // cal�� ��� ������ �ƴ�, Date ���Ŀ� ���� ����ϵ��� Date�� ��ȯ�Ѵ�.

	}
}
