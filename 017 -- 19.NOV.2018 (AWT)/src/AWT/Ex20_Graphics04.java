package AWT;

import java.awt.*;
import java.awt.event.*;

class Ex20_Graphics04 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;
	Image img = null;
	Graphics gImg = null;

	public static void main(String[] args) {
		new Ex20_Graphics04("Ex20_Graphics04");
	}
	
	public Ex20_Graphics04(String title) {
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
		if(img==null) return;
		g.drawImage(img,0,0,this); // Frame ����ȭ�鿡 �׷��� �׸��� �� ����
	}
	
	public void mouseMoved(MouseEvent me) {
		x = me.getX();
		y = me.getY();
	}
	
	public void mouseDragged(MouseEvent me) {
		if (me.getModifiersEx()!=MouseEvent.BUTTON1_DOWN_MASK ) return;
		gImg.drawLine(x,y, me.getX(),me.getY());
		x = me.getX();
		y = me.getY();
		repaint();
	}
} // class