package threads;

import javax.swing.JOptionPane;

// Ex03_Thread03�� ��!!

class Ex02_Thread02 {
	public static void main(String[] args) throws Exception {
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1�� �� �ð��� �����Ѵ�.
			} catch (Exception e) {}
		}
	} // main() ��.
} // Ŭ���� ��.