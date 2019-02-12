package study;

class Time {
	// Ŭ���� �������� �Ӽ��� ��ɸ� �ۼ��� �� �ִ� --> ����(ex) println)�� �޼��� �������� �ۼ��ؾ� �Ѵ�
	
	private int hour;
	private int minute;
	private int second;
	
	// private Time() { } --> �����ڸ� private���� ����� �ܺο��� ������ ��� �Ұ��� --> ��ü ���� �Ұ���
	
	int getHour() { // ���������ڰ� default
		return hour;
	}
	
	// �Ű������� ������ hour ������ ���� �ٲ۴�
	void setHour(int hour) {
		if (hour < 0 || hour > 23) return;
		this.hour = hour;
	}
}

public class Ex01_AccessModifier {
	public static void main(String[] args) {
		Time t = new Time();
		// t.hour = 10;
			/* hour ������ private���� �ٲٸ� "not visible" ��������
			 * 	>> not visible --> ������ �ʴ´� --> private�̱� ������ "���������� �ۿ��� �Ⱥ��δ�" �ǹ�
			 * ������ Ư¡ --> scope & visibility
			 * 	>> scope --> ������ ��� �ڵ���� ��� �ڵ���� ��� �ִ°�?
			 * 	>> visibility --> ��� �ִµ� ���̴°�? ���⼭ �װ��� ����� �� �ִ°�?
			 */
		System.out.println(t.getHour());
		t.setHour(10);
		System.out.println(t.getHour());
	}

}
