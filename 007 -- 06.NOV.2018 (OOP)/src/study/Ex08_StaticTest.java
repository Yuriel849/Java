package study;

class StaticBlockTest {
	// ���̰� 10�� int �迭
	// �� �迭�� ������ �������� ä��� �ʹ�
	static int[] arr = new int[10]; // static ����� ������ �ʱ�ȭ
	
	static { // static initialization block --> static ����� ������ �ʱ�ȭ�� ���
				// --> �ν��Ͻ��� �����ڷ� �ʱ�ȭ������ static ����� �����ڸ� ������� �ʱ⿡ ������ �ʱ�ȭ�� �Ұ����ϴ�
		// ������ ������ �迭�� ä��� ���ؼ��� for���� �ʿ�������, �޼��� �ۿ� for���� ����� �� ����.
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10);
		}
	}
}

public class Ex08_StaticTest {
	public static void main(String[] args) {
	}

}
