package AWT;

import java.awt.*;

class Ex05_TextFieldTest {
	public static void main(String args[]) {
		Frame f = new Frame("Login");
		f.setSize(400, 100);
		f.setLayout(new FlowLayout()); // LayoutManager�� FlowLayout���� �Ѵ�
		
		// ���� �� ��Ÿ���� â���� "ID: " & "Password: "�� �ٷ� ���̺�
		Label lid = new Label("ID :", Label.RIGHT); // ������ ����������
		Label lpwd = new Label("Password :", Label.RIGHT);
		
		// ���� �� ��Ÿ���� â���� ����ڰ� �Է��� �� �ִ� �ڽ��� textfield
		TextField id = new TextField(10);//�� 10���� ���ڸ� �Է��� �� �ִ� TextField ����
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*'); // �Է��� �� ��� '*'�� ���̵��� �Ѵ�
		
		f.add(lid); // ������ ������Ʈ���� Frame�� ���Խ�Ų��
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.setVisible(true);
	} // main() ��.
} // Ŭ���� ��.
