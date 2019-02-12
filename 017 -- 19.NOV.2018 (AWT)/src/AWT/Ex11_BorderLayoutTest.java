package AWT;

import java.awt.*;

// Layout Manager�� ���� â�� ũ�⸦ ������ �� �ڵ����� ũ�� ������ ���ش�.

// BorderLayout�� Layout Manager�� 5�� ���� �� �ϳ�

public class Ex11_BorderLayoutTest {
	public static void main(String args[]) {
		Frame f = new Frame("BorderLayoutTest");
		f.setSize(400, 400);
		//Frame�� �⺻������ BorderLayout�� �����Ǿ� �����Ƿ� ���� �������� �ʾƵ� ��
		f.setLayout(new BorderLayout());
		Button north = new Button("North");
		Button south = new Button("South");
		Button east = new Button("East");
		Button west = new Button("West");
		Button center = new Button("Center");
		
		// Frame�� 5���� �� ������ Button�� �ϳ��� �߰��Ѵ�
//		f.add(north, "North"); // f.add("North",north);�� ���� �� ���� �ִ�
		f.add(south, "South"); // South�� ��ҹ��� ��Ȯ��
		f.add(east, "East"); // East ���, BorderLayout.EAST ��밡��
//		f.add(west, "West");
		f.add(center, "Center");
		// Ư�� ������ ��ư �ʿ���ٸ�, �� �κп� add()���� ������ �� ������ ���� ȭ���� ä���.
		
		f.setVisible(true);
	} // main() ��.
} // Ŭ���� ��.