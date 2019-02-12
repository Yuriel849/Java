package AWT;

import java.awt.*;
import java.awt.event.*;

class Ex04_FrameTest_EventHandling {
	public static void main(String args[]) {
		Frame f = new Frame("Login"); // Frame ��ü�� �����Ѵ�
		f.setSize(300, 200); // Frame�� ũ�⸦ �����Ѵ�
		Button b = new Button("OK");
		
		// 2. ��ư�� �̺�Ʈ ó���⸦ ���(����)�Ѵ�
		b.addActionListener(new ButtonHandler());
		f.add(b);
		b.addMouseMotionListener(new MouseHandler()); // ���콺 ������ �̺�Ʈó���� b���� �ؾ� �Ѵ�. b�� f�� ������ ���� ������, ���콺 ������ �̺�Ʈ�� f�� ���� ���ϰ� b�� �ޱ� �����̴�.
		
		// EventHandler Ŭ������ ��ü�� �����ؼ� Frame�� WindowListener�� ����Ѵ�
		f.addWindowListener(new EventHandler());
		f.setVisible(true); // Frame . ������ �� ȭ�鿡 ���̵��� �Ѵ�
	}
}

// OOP�� Adapter �����̱⿡ Window"Adapter"��� �θ���.
// Adapter Ŭ������ �߻�Ŭ������ �������̽��� �߻�޼��带 ��� �� (���� ����) �޼���� �����س���. (�Ƹ�...?)
	// �߻�Ŭ������ ���� ������ ��ü ���� ���ϰ� �ϱ� ���ؼ� --> AdapterŬ������ ��ü �����غ��� ������ ��� �ǹ̰� ���� --> �ƿ� ��ü ���� ���ϰ� ���� ��
// ����ڴ� �������̽��� ���� ������ �ʿ� ���� adapter�� ��ӹ޾Ƽ� ���ϴ� �޼��常 �������̵� �ϸ� �ȴ�.
// Adapter Ŭ������ ����ϴµ� �������� Adapter Ŭ������ ��ӹޱ⿡ �ٸ� ���� ��� ���� �� ����.
class EventHandler extends WindowAdapter {
	// �������̽� WindowListener�� ��� �߻�޼��带  ��ȣ�� �ٿ��� ��� �����ؾ� �Ѵ�.
	// Ŭ���� WindowAdapter�� WindowListener�� �߻�޼��带 �� (������ ����) �޼���� �����س��Ұ�, �׷��� ����ڴ� ����ϱ� ���� �޼��常 �������̵��ϸ� �ȴ�.
	public void windowClosing(WindowEvent e) { // Frame�� �ݱ� ��ư�� ������ �� �ڵ����� ȣ��ȴ�
		e.getWindow().setVisible(false); // Frame�� ȭ�鿡�� ������ �ʵ��� �ϰ�,
		e.getWindow().dispose(); // �޸𸮿��� �����Ѵ�
		System.exit(0); // ���α׷��� �����Ѵ�
	}
}

//class EventHandler implements WindowListener {
//	public void windowOpened(WindowEvent e) {}
//	public void windowClosing(WindowEvent e) { // Frame�� �ݱ� ��ư�� ������ �� �ڵ����� ȣ��ȴ�
//		e.getWindow().setVisible(false); // Frame�� ȭ�鿡�� ������ �ʵ��� �ϰ�,
//		e.getWindow().dispose(); // �޸𸮿��� �����Ѵ�
//		System.exit(0); // ���α׷��� �����Ѵ�
//	}
//	
//	// �Ʒ� �޼������ WindowListener �������̽��� �ִ� �͵� --> â�� �ݴµ��� �ʿ����� �ʴ�.
//	public void windowClosed(WindowEvent e) {} // �ƹ����뵵 ���� �޼��� ���� --> �������̽��� �߻�޼����̱� ������
//	public void windowIconified(WindowEvent e) {}
//	public void windowDeiconified(WindowEvent e) {}
//	public void windowActivated(WindowEvent e) {}
//	public void windowDeactivated(WindowEvent e) {}
//}

// 1. �̺�Ʈ ó���⸦ �ۼ� (���ϴ� �޼��带 ���� �������̽� ����)
class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK ��ư�� ���������.");
	}
}

class MouseHandler implements MouseMotionListener {
	public void mouseDragged(MouseEvent me) {}
	
	public void mouseMoved(MouseEvent me) {
		System.out.println("x = " + me.getX() + ", y = " + me.getY());
	}

}