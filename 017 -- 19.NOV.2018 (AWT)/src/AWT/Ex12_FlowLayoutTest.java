package AWT;

import java.awt.*;

public class Ex12_FlowLayoutTest {
	public static void main(String args[]) {
		Frame f = new Frame("FlowLayoutTest");
		f.setSize(500, 250);
		f.setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout ���������� ����
		f.add(new Button("ù ��°"));
		f.add(new Button("�� ��°"));
		f.add(new Button("�� ��°"));
		f.add(new Button("�� ��°"));
		f.add(new Button("�ټ� ��°"));
		f.add(new Button("���� ��°"));
		f.add(new Button("�ϰ� ��°"));
		f.add(new Button("���� ��°"));
		f.add(new Button("��ȩ ��°"));
		f.add(new Button("�� ��°"));
		f.setVisible(true);
	}
}
