package study;

public class StringClass {
	String str = "abc"; // ������ ������� �̹� �����ϴ� ��ü�� str�� �����ϰ� �Ѵ�.
						// ���� ���������� ���� ���ڿ��� ������ �� �ִ� (i.e. ���� ���������� ��� �ִ� �ּҰ��� ����)
	String str2 = new String("abc"); // ������ ���ο� ��ü�� ���Ӱ� �����Ͽ� str2�� �����ϰ� �Ѵ� (������ ������ ������ ���� �ٸ� �ּҰ��� ������)
	
	/* ==
	 * �񱳴���� �� ���������� �ּҰ��� ���Ѵ�.
	 * 
	 * .equals()
	 * �񱳴���� �� ���������� ������ �����ϰ� �ִ� ���ڿ�(i.e. ����)�� ���Ѵ�.
	 */
	
	/* "" == ���ڿ� == ũ�Ⱑ 0�� charŸ�� �迭 == ������ ���� �迭
	 * 
	 * ���ڿ� �ʱ�ȭ�� �� �⺻�� null�� �ƴ� "" (�� ���ڿ�)�� �ʱ�ȭ����!
	 * 	>> ��? null�� �ʱ�ȭ�ϸ� �������� ���� --> ex) ��� �ʱ�ȭ���� �𸣰� length ����ϸ� null�̱⿡ ��������
	 */
	
	// �迭�� �ִ� ���� --> �⺻������ ������ �޸� ũ�Ⱑ �ִ� (���� �缳���� �� �ִ�)
	public static void main(String[] args) {
		char[][][] cArr = new char[1000][1000][800]; // [1000][1000][1000]�� �ص� �������� (1 trillion)
		System.out.println(cArr);
	}
	
}