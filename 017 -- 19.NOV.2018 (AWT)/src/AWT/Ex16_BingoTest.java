package AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GridLayout�� ��ư�� ũ�Ⱑ �����ϴ�

class Ex16_BingoTest {
	public static void main(String args[]) {
		Frame f = new Frame("GridLayoutTest");
		f.setSize(250, 250);
		f.setLayout(new GridLayout(5, 5)); // 5�� 5���� ���̺��� ���� str�� ���ڿ���� ä���.
		
		// �������� ä�� �ܾ� 25�� (������ ���ڿ�)
		String[] str = { "����", "�η��", "Ȳ��", "��ѱ�", "�����",
				"����", "Ÿ��", "�ξ���", "�û���", "���",
				"��", "��", "������", "�ײ�", "��",
				"����", "������", "�ܵ�", "��Ȳ", "����",
				"��ġ", "���", "�޹���", "�Ҳ���", "���" };
	
		// str�� ��ҵ��� ���´�.
		for(int i = 0; i < 25; i++) {
			int ran = (int)(Math.random() * 23 + 1);
			String temp = str[ran];
			str[ran] = str[0];
			str[0] = temp;
		}
		
		for(int i = 0; i < 25; i++) {
			/* �ߺ��ȴ�!!!
			 * 	>> Button�� ���������� i�� 1�� �����ϸ鼭 �Է��ϴµ�, �� ���߿� (�׿� ���ÿ�) str�� ��ҵ��� ���̰� �ִ�
			 */
//			int ran = (int)(Math.random() * 23 + 1);
//			String temp = str[ran];
//			str[ran] = str[0];
//			str[0] = temp;
			Button b = new Button(str[i]); // Button ��ä ����, Button�� label�� str[i]
			b.setBackground(Color.cyan); // b�� ������ ����
			f.add(b); // f���ٰ� b�� �߰�
			
			b.addActionListener(new ButtonHandler2 ()); 
			/* ButtonHandler2 Ŭ������ ��ü, �ϸ� "�̺�Ʈ ��ü"�� ����
			 * 	>> �̺�Ʈ ��ü���� �̺�Ʈ�� ���� ������ ������ִ�.
			 * 	>> �̺�Ʈ ��ü�� �޼������ ����ϸ� �� ������ ������ �� �ִ�.
			 */
		}
		f.setVisible(true); // f�� ȭ�鿡 ��Ÿ������		
	}
	// �������� �� â�� �߸�, �� ���¿����� main()�� ���� ��! f.setVisible(true)���� ��� �����ϰ� ������ ��!
	// ������ �������� �� ��ư�� addActionListener�� ���ؼ� �̺�Ʈó�� �޼��尡 ����Ǿ� �ִ� --> ��ٸ��ٰ� ����ڰ� ��ư�� ������ �װͰ� ����� �޼��带 ���󰡼� ButtonHandler2�� actionPerformed �޼��带 ȣ���Ѵ�!
}

class ButtonHandler2 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Button b = (Button) e.getSource();
		b.setBackground(Color.LIGHT_GRAY);
		System.out.println(b.getLabel());
	}
}