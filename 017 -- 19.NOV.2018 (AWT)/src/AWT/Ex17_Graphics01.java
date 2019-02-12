package AWT;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

class Ex17_Graphics01 extends Frame {
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Ex17_Graphics01("Ex17_Graphics");
		f.setVisible(true);
		// Frame�� Graphics�� ���´�.
		Graphics fg = f.getGraphics();
		// Frame�� Hello��� ����.
		// Frame�� �ð��� ��´�.
		for(int i = 1; i < 1000; i++) {
			fg.drawString("Hello", 200, 80);
			fg.drawString(new Date().toString(), 200, 200);
			Thread.sleep(1000);
			f.repaint();
		}
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		g.drawString("Graphics�� �̿��ؼ� �׸��� �׸��ϴ�." ,10, 50);
		
		g.drawOval(50,100, 50,50); // ù��° �� �׸���
		g.setColor(Color.blue);
		g.fillOval(100,100, 50,50); // �ι�° �� �׸���
		
		g.setColor(Color.red);
		g.drawLine(100,100, 150,150); // �밢�� �׸���
		
		g.fillRoundRect(200, 100, 120, 80, 30, 30); // ���簢�� �׸���
		g.setColor(Color.orange);
		g.fillPolygon(new int[]{ 50, 100, 150, 200}, // ���� �׸���
					new int[]{250, 200, 200, 250}, 4);
		g.setColor(Color.cyan);
		g.fillArc(250, 200, 100, 100, 0, 120); // ��ä�� �׸���
	}
	
	public Ex17_Graphics01(String title) {
		super(title);
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// Frame�� (100,100)�� ��ġ�� width 400, height 300 ũ��� ���̰� �Ѵ�.
		setBounds(100,100, 400,300);
		setVisible(true);
	}
} // class
