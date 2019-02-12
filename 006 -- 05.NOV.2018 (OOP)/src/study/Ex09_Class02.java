package study;

public class Ex09_Class02 {
	public static void main(String[] args) {
		Variables.cv = 20; // ���������� �ν��Ͻ��� ���� ��Ȳ���� �ٷ� Ŭ������ ������ �� �ִ� ���� static variable
		System.out.println("���������� �ν��Ͻ��� ���� ���¿��� Variables.cv : " + Variables.cv);
		
		// cv = 20; --> ���������� ����/�������� �ʾƼ� ��� �ִ� cv���� �� ���� ���� ��������
		// vary.iv = 10; --> ���������� ����/�������� ���� �������� ������ �� ����
		// 				 --> �ν��Ͻ��� �������� ���� �������� ������ �� ����
		
		Variables vary1 = new Variables();
		System.out.println("�ν��Ͻ� vary1�� �������� �ʱⰪ --> vary1.iv : " + vary1.iv);
															// �ʱ�ȭ�� ��, ���� ����
		vary1.iv = 20;
		System.out.println("�ν��Ͻ� vary1�� �������� �ٲ� �� --> vary1.iv : " + vary1.iv);
		System.out.println("�ν��Ͻ� vary1���� static variable ���� --> vary1.cv : " + vary1.cv);
		vary1.cv = 120;
		System.out.println("�ν��Ͻ� vary1���� static variable �ٲ� �� --> vary1.cv : " + vary1.cv);
		Variables.cv = 240;
		Variables vary2 = new Variables();
		System.out.println("Variables���� static variable �ٲ� �� --> vary2.cv : " + vary2.cv);
		System.out.println("�ν��Ͻ� vary2�� �������� �ʱⰪ --> vary2.iv : " + vary2.iv); // �ʱ�ȭ�� ��, ���� ����
		vary1.iv = 40;
		System.out.println("�ν��Ͻ� vary2�� �������� �ٲ� �� -->vary1.iv : " + vary1.iv);
		vary2.cv = 500;
		System.out.println("�ν��Ͻ� vary2���� static variable �ٲ� �� -->vary1.cv : " + vary1.cv);
		System.out.println("�ν��Ͻ� vary1���� static variable ���� --> vary1.cv : " + Variables.cv);
		System.out.println("Variables���� static variable ���� --> Variables.cv : " + Variables.cv);
	}

}

class Variables {
	int iv; // "iv" --> instance variable
	static int cv; // "cv" --> class variable == static variable == ��������
	
	public void method() {
		int lv; // "lv" --> local variable
	}
}