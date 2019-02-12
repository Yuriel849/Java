package AWT;

import java.awt.*;

class Ex02_FrameTest02 {
	public static void main(String args[]) {
		Frame f = new Frame("Login");
		f.setSize(300, 200);
	
		Toolkit tk = Toolkit.getDefaultToolkit(); // ������ Toolkit�� ��´�
		Dimension screenSize = tk.getScreenSize(); // ȭ���� ũ�⸦ ���Ѵ�
		
		// ȭ��ũ���� ���ݰ����� Frame ũ���� ���ݰ��� �� ��ġ�� �ϸ�
		// Frame�� ȭ�� ��� ��ġ�ϰ� �ȴ�
		f.setLocation(screenSize.width/2 - 150, screenSize.height/2 - 100);
		f.setVisible(true); // ������ Frame�� ȭ�鿡 ���̵��� �Ѵ�
	}
}