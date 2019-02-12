package AWT;

import java.awt.*;
import java.awt.event.*;

// ��������̴�.
// Frame�� �������� �׸��� �� ���� ���� ��ư�� ������ ���� ����, ������ ��ư�� ������ �� ���� �׷������� �˸��� �ڵ带 �ϼ��Ͻÿ�.
// �� ���� Ŭ���� ���� ���� ����� �������� ������ �Ѵ�.

class Ex21_OmokTest extends Frame implements MouseListener {
	public static void main(String[] args) {
		new Ex21_OmokTest("OmokTest");
	} // main() ��.

	final int LINE_NUM = 9; // ������ �� ��
	final int LINE_WIDTH = 30; // ������ �� ����
	final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM-1); // �������� ũ��
	final int STONE_SIZE = (int)(LINE_WIDTH * 0.8); // ���� ũ��

	final int X0; // x ������ ������ġ ��ǥ
	final int Y0; // y ������ ������ġ ��ǥ
	
	final int FRAME_WIDTH; // Frame�� ��
	final int FRAME_HEIGHT; // Frame�� ����
	
	Image img = null;
	Graphics gImg = null;
	
	// ������!!
	public Ex21_OmokTest(String title) {
		super(title);
		
		// Event Handler�� ����Ѵ�.
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		setVisible(true); // Frame�� ȭ�鿡 ���̰� �Ѵ�.
		Insets insets = getInsets(); // setVisible�� �̿��Ͽ� ȭ�鿡 ���̱� ������ Insets�� ���� ���� �� ����.

		// ������ �׷��� ��ġ(LEFT, TOP)�� ��ǥ X0, Y0�� �����Ѵ�.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.top + LINE_WIDTH;
		
		// Frame�� ũ�⸦ ����Ѵ�.
		FRAME_WIDTH = BOARD_SIZE+LINE_WIDTH*2+insets.left+insets.right;
		FRAME_HEIGHT = BOARD_SIZE+LINE_WIDTH*2+insets.top+insets.bottom;

		// Frame�� ȭ���� (100,100)�� ��ġ�� ���� ũ��� ���̰� �Ѵ�.
		setBounds(100,100, FRAME_WIDTH, FRAME_HEIGHT);
	
		img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		gImg = img.getGraphics();
	
		setResizable(false); // Frame�� ũ�⸦ �������� ���ϰ� �Ѵ�
							 // true�� ������ ���, Frame�� ũ�⸦ ������ �� ������ �������� ũ��� �þ�� �ʴ´�.
		drawBoard(gImg);
	} // ������ Ex21_OmokTest(String title) ��.
	
	public void drawBoard(Graphics g) {
		for(int i=0; i<LINE_NUM;i++) {
			g.drawLine(X0,Y0+i*LINE_WIDTH,X0+BOARD_SIZE, Y0+i*LINE_WIDTH);
			g.drawLine(X0+i*LINE_WIDTH,Y0, X0+i*LINE_WIDTH, Y0+BOARD_SIZE);
		}
	} // drawBoard() ��.
	
	public void paint(Graphics g) {
		if(img==null) return;
		g.drawImage(img,0,0,this); // ����ȭ�鿡 �׷��� �׸��� Frame�� ����
	} // paint() ��.
	
	public void mousePressed(MouseEvent e) { // MouseListener
		int x = e.getX(); // ���콺 �������� x��ǥ
		int y = e.getY(); // ���콺 �������� y��ǥ
		
		// 1. x�� y�� ���� �������� ���� ��� ���̸� ���� �׸��� �ʴ´�.
		if((x <= (X0-LINE_WIDTH/2) || X0+BOARD_SIZE+LINE_WIDTH/2 <= x) || (y <= (Y0-LINE_WIDTH/2) || Y0+BOARD_SIZE+LINE_WIDTH/2 <= y))
			{ return; }
		
		// 2. x�� y�� ���� Ŭ���� ������ ���� ����� ���������� �����Ѵ�. (�ݿø�)
		x = (x-X0 + LINE_WIDTH/2) / LINE_WIDTH * LINE_WIDTH + X0;
		/* (�ؼ�)
		 * 	>> ���콺 Ŭ������ ������ x�� ������ X0(����)�� ����, �ű�ٰ� LINE_WIDTH�� ������ ���Ѵ�.
		 * 	>> ���� �ݿø��� �� ���̶�� (LINE_WIDTH�� ���� �̻��̱⿡ �� ū �������� �� �����ٸ�) �ݿø��� ���� ���̴�.
		 * 		>> �ݿø��� �� �ƴٸ� ���ʿ� �� ���� �������� ����� ���̴�.
		 * 	>> int�� LINE_WIDTH���� �������ؼ� �Ҽ��� ���ϸ� ������.
		 * 	>> �ٽ� LINE_WIDTH ���ϰ� X0 ���ؼ� ���������� �̵��� ���� x ���� ���Ѵ�.
		 */
		y = (y-Y0 + LINE_WIDTH/2) / LINE_WIDTH * LINE_WIDTH + Y0;
		
		// 3. x�� y�� ������ ���� ũ�� (STONE_SIZE)�� ������ ���� Ŭ���� ���� ���� �׷�����.
		// 	>> drawOval(), fillOval()�� �׸� ��, x,y�� ��� ������������ �׸������� ǥ���Ѵ� --> �� ���� �������� �������� �׷������� x,y�� ���� ���� �̵����Ѿ� �Ѵ�. 
		x -= STONE_SIZE/2;
		y -= STONE_SIZE/2;
		
		/* 4. ������ ��ư�� ���콺 ���� ��ư�̸� (x,y)�� ��ġ�� ���� ���� �׸���, --> ���콺 ���� ��ư�� BUTTON1
			    ������ ��ư�� ���콺 ������ ��ư�̸� (x,y)�� ��ġ�� �� ���� �׸���. --> ���콺 ������ ��ư�� BUTTON3
			 (�� ���� �׸� �� ���� �� �׵θ��� ���� �׸���.) */
		gImg = img.getGraphics();
		if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK ) {
			gImg.setColor(Color.black);
			gImg.fillOval(x,y, STONE_SIZE,STONE_SIZE); // fillOval�� ä���.
		} else if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK ) {
			gImg.setColor(Color.white);
			gImg.fillOval(x,y, STONE_SIZE, STONE_SIZE);
			gImg.setColor(Color.black);
			gImg.drawOval(x,y, STONE_SIZE,STONE_SIZE); // drawOval�� �׵θ��� �׸���.
		}
		
		// 5. repaint()�� ȣ���Ѵ�.
		repaint();

	} // mousePressed() ��.

	// MouseListener �������̽��� �ٸ� �޼����, ������� �����ϱ� �� �޼���� ����
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
} // Ŭ���� ��.