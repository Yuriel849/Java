package AWT;

// Image�� �̿��ؼ� �̹��� ����ϱ�
// ���� ���� �׸��� ���� ������ --> �������������� �׸��� ����ϴϱ�, ��� �����Ÿ��鼭 repaint()�� ����ȴ�
// �ذ�å --> ���� �׸��� �Է��� ���� ���� ȭ���� �ϳ� �����, �װ��� �ٽ� �����ؼ� ��¿� ȭ�鿡 �ű�� --> double buffering ���
// �ڵ�
// 1. ���� �̹��� ����
// 2. ���� �̹����� �׷��Ƚ� ������
// 3. �׸� �׸���
// 4. ����

import java.awt.*;
import java.awt.event.*;

class Ex19_Graphics03 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;
	Image img = null; // ����ȭ�鸦 �ٷ�� ���� ��������
	Graphics gImg = null; // ����ȭ���� �׷��Ƚ��� �ٷ�� ���� ��������
	
	public static void main(String[] args) {
		new Ex19_Graphics03("Ex19_Graphics03");
	}
	
	public Ex19_Graphics03(String title) {
		super(title);
		addMouseMotionListener(this);
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		// Frame (100, 100) width 500, height 500 . �� �� ��ġ�� ũ��� ���̰� �Ѵ�
		setBounds(100,100, 500,500);
		setVisible(true);
		img = createImage(500, 500);
		gImg = img.getGraphics();
		gImg.drawString("���ʹ�ư�� ���� ä�� ���콺�� ������������." ,10, 50);
		repaint();
	}
	
	public void paint(Graphics g) {
		if(img!=null)
			g.drawImage(img,0,0,this); // Frame ����ȭ�鿡 �׷��� �׸��� �� ����
	}
	
	public void mouseMoved(MouseEvent me) {}
	
	public void mouseDragged(MouseEvent me) {
		if (me.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK ) { // BUTTON1�� ���콺 ���� ��ư�� �ǹ�
			x = me.getX();
			y = me.getY();
			gImg.drawString("*", x, y);
			repaint();
		}
	}
} // class