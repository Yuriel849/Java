package threads;

import javax.swing.JOptionPane;

// Ex08_Thread08�� ��!!

class Ex07_Thread07 {
	public static void main(String[] args) throws Exception {
		Ex07_Thread07_1 th1 = new Ex07_Thread07_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���. ");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		th1.interrupt(); // interrupt()�� ȣ���ϸ�, interrupted ���°� true�� �ȴ�.
		System.out.println("isInterrupted(): " + th1.isInterrupted()); // true�� ��µǾ�� �Ѵ�
	} // main() ��.
} // Ŭ���� ��.

class Ex07_Thread07_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted())	{
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++); // �ð� ������
		}
		
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	} // run() ��.
} // Ŭ���� ��.