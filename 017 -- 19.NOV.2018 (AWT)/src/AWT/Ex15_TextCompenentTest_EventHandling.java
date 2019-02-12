package AWT;

import java.awt.*;
import java.awt.event.*;

class Ex15_TextCompenentTest_EventHandling extends Frame {
	TextField tf;
	TextArea ta;
	
	Ex15_TextCompenentTest_EventHandling(String title) {
		super(title); // Frame(String title)�� ȣ���Ѵ�.
		
		tf = new TextField();
		ta = new TextArea();
		add(ta, "Center");
		add(tf, "South");
	
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TextField���� Enter�� ġ��, tf�� �Էµ� text�� TextArea�� �߰��Ѵ�.
				ta.append(tf.getText() + "\n");
				tf.setText(""); // tf�� text�� �����.
				tf.requestFocus();
			}
		});
		
		ta.setEditable(false); // TextArea�� text�� �������� ���ϰ� �Ѵ�.
		setSize(300, 200);
		setVisible(true);
		tf.requestFocus(); // focus�� TextField�� ��ġ�ϵ��� �Ѵ�.
	}
	
	public static void main(String args[]) {
		Ex15_TextCompenentTest_EventHandling mainWin = 
				new Ex15_TextCompenentTest_EventHandling("TextComponentEventTest");
	} // main�޼����� ��.
} // Ŭ���� ��.