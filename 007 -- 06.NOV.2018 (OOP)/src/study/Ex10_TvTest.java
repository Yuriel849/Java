package study;

// 1. Ŭ���� ����
class Tv { // Tv Ŭ������ ����
	String color; // Tv�� ����
	boolean power; // ���� on/off --> true�� on, false�� off
	int channel; // ä��
	
	void power() {
		power = !power; // ���� on/off ��ȯ�ϱ�
		// �� �� �ٰ� ���� if-else��
//		if(power==true)
//			power = false;
//		else
//			power = true;
	}
	void channelUp() {
		channel++; // ä�� �ø���
	}
	void channelDown() {
		channel--; // ä�� ������
	}
} // Tv Ŭ������ ��

public class Ex10_TvTest {
	public static void main(String[] args) {
		// 2. ��ü�� ����
		Tv tv = new Tv();
		Tv tv2 = new Tv();
		
		// 3. ��ü�� ��� == ��ü�� �Ӽ� & ��� ���
		tv.power(); // tv�� ���� ����� ���
		tv.channel = 7;
		tv.channelUp();
		tv.color = "white"; // tv�� �Ӽ��� ���� --> tv�� ������ white���� ����
		
		tv2.power(); // --> �� ���������� �ʿ�
		
		System.out.println("���� ä���� " + tv.channel + "�Դϴ�.");
	}
}
