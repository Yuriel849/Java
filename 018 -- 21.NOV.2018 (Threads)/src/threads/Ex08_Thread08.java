package threads;

import javax.swing.JOptionPane;

// Ex07_Thread07�� ��!!

class Ex08_Thread08 {
	public static void main(String[] args) throws Exception {
		Ex08_Thread08_1 th1 = new Ex08_Thread08_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���. ");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		th1.interrupt(); // interrupt()�� ȣ���ϸ�, interrupted ���°� true�� �ȴ�.
		System.out.println("isInterrupted(): " + th1.isInterrupted()); // true�� false�� ���� �� �ִ� --> ��? who cares --> ����ٴ°� �߿��ϴ�
	} // main() ��.
} // Ŭ���� ��.

class Ex08_Thread08_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted())	{
			System.out.println(i--);
			try {
				Thread.sleep(1000); // 1�ʾ� ����
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	} // run() ��.
} // Ŭ���� ��.