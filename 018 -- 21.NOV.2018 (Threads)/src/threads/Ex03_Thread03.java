package threads;

import javax.swing.JOptionPane;

// Ex02_Thread02�� ��!!

class Ex03_Thread03 {
	public static void main(String[] args) throws Exception {
		ThreadEx03 th1 = new ThreadEx03();
		th1.start();
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
	} // main() ��.
} // Ŭ���� ��.

class ThreadEx03 extends Thread {
	public void run() {
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1�� �� �ð��� �����Ѵ�.
			} catch (Exception e) {}
		}
	} // run() ��.
} // Ŭ���� ��.