package exercises.textTool;

import java.awt.*;
import java.awt.event.*; 
import java.util.*;

// �۾� ���� ���·� �ǵ����� Undo����� ����
// 	  ex) "¦���ٻ���" ���� �� Undo ������ TextArea�� ������ "¦���ٻ���" ������ ������ ���·� �ǵ��ư��� �Ѵ�.

class Ex02_TextTool02 extends Frame implements WindowListener { 
	TextArea ta;
    TextField tfParam1, tfParam2; 
    Panel pNorth, pSouth; 
    Label lb1, lb2;

    // �����ڿ��� btnName�� �����͸� btn���� �ű��.
    String[] btnName = {
    		"Undo", // �۾����� ���·� �ǵ��� 
            "¦���ٻ���", // ¦������ �����ϴ� ��� 
    };

    Button[] btn = new Button[btnName.length]; 

    private final String CR_LF = System.getProperty("line.separator"); // ���๮��(�ٹٲ޹���)

    // �۾��� �ϱ� �� TextArea ta�� ������ �����ϱ� ���� ����
    private String prevText = "";

    private void registerEventHandler() {
    	addWindowListener(this);

        btn[0].addActionListener(new ActionListener() { // Undo - �۾����� ���·� �ǵ��� 
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();

        		if(!prevText.equals("")) {
        			ta.setText(prevText);
        		}

                prevText = curText;

                // �̹� "¦���� ����" ����� ���� prevText�� ����� ���ڿ���  ���๮�ڱ��� �����Ͽ� �ϼ��Ǿ� �ִ� ����! ���� �Ʒ��� ���� �ٽ� ó���� �ʿ䰡 ����!
//    			String curText = ta.getText();
//    			StringBuffer sb = new StringBuffer(prevText.length());
//
//    			Scanner scan = new Scanner(prevText);
//    		
//    			for(int i = 0; scan.hasNextLine(); i++) {
//    				String line = scan.nextLine();
//    				sb.append(line + CR_LF);
//    			}
//    			ta.setText(sb.toString());
//    			prevText = curText;
        	}
        });

		// �Ʒ� () �� �ڵ�� �͸�Ŭ���� --> ActionListener �������̽� ����
        btn[1].addActionListener(new ActionListener() { // ¦���ٻ��� - ¦������ �����ϴ� ��� 
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length()); 

                prevText = curText;

                Scanner scan = new Scanner(curText); 

                for(int i = 0; scan.hasNextLine(); i++) { 
                	String line = scan.nextLine();
                    if(i%2==0) {
                    	sb.append(line).append(CR_LF);
                        // sb.append(line+CR_LF); �� ����
                    }
                }
                ta.setText(sb.toString()); 
                
                System.out.println(curText);
        	}
        });
    } // registerEventHandler() ��.

    // main()!!
    @SuppressWarnings("deprecation")
	public static void main(String[] args) { 
    	Ex02_TextTool02 win = new Ex02_TextTool02("Text Tool"); 
        win.show();
    } // main() ��.

    // ������!!
    public Ex02_TextTool02(String title) { 
    	super(title);
        lb1 = new Label("param1:", Label.RIGHT); 
        lb2 = new Label("param2:", Label.RIGHT); 
        tfParam1 = new TextField(15);
        tfParam2 = new TextField(15);

        ta = new TextArea();
        pNorth = new Panel(); 
        pSouth = new Panel();

        for(int i=0;i < btn.length;i++) {
        	btn[i] = new Button(btnName[i]); 
        }

        pNorth.setLayout(new FlowLayout()); 
        pNorth.add(lb1);
        pNorth.add(tfParam1); 
        pNorth.add(lb2);
        pNorth.add(tfParam2); 

        pSouth.setLayout(new GridLayout(2,10)); 

        for(int i=0;i < btn.length;i++) { // ��ư�迭�� �ϴ� Panel�� �ִ´�. 
        	pSouth.add(btn[i]);
        }

        add(pNorth,"North"); 
        add(ta,"Center");
        add(pSouth,"South"); 

        setBounds(100, 100, 600, 300); 
        ta.requestFocus();
        registerEventHandler(); 
        setVisible(true);
	} // ������ public TextToolEx1(String title) ��.

	// WindowsListener�� �߻�޼���� ����
    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) { 
    	e.getWindow().setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
} // Ŭ���� ��.