package exercises.textTool;

import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

class Ex07_TextTool07 extends Frame implements WindowListener {
	// TextArea�� �� ���ο��� param1�� �Էµ� ���ڿ��� param2�� �Էµ� ���ڿ��� ã�Ƽ� �� ���ڿ� ������ �ؽ�Ʈ�� ����� �����ϴ� ����� 'substring2'��ư�� �����϶�. 
	TextArea ta;
    TextField tfParam1, tfParam2;
    Panel pNorth, pSouth;
    Label lb1, lb2;
    
    // �����ڿ��� btnName�� �����͸� btn���� �ű��.
    String[] btnName = {
    		"Undo", // �۾����� ���·� �ǵ���
            "¦���ٻ���", // ¦������ �����ϴ� ���
            "���ڻ���", // tfParam1�� ������ ���ڵ��� �����ϴ� ���
            "trim", // ������ �յ� ������ ����
            "���ٻ���", // �� �� ����
            "���λ��߰�", // tfParam1 & tfParam2�� ���ڿ��� �� ������ �� �ڿ� ���̴� ���
            "substring", // tfParam1 & tfParam2�� ������ ���ڿ��� �� ���ο��� �����ϴ� ���
            "substring2", // tfParam1�� tfParam2�� ������ ���ڿ��� �ѷ����� �κ��� ����� �����ϴ� ���
	};

    Button[] btn = new Button[btnName.length];

    private final String CR_LF = System.getProperty("line.separator"); // ���๮��(�ٹٲ޹���)

    private String prevText = "";

    private void registerEventHandler() {
    	addWindowListener(this);

        int n = 0; // ��ư����

        // 1. // Undo --> �۾����� ���·� �ǵ���
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();

        		if(!prevText.equals("")) {
        			ta.setText(prevText);
        		}

                prevText = curText;
        	}	        	
        });

        // 2. ¦���ٻ��� --> ¦������ �����ϴ� ���
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
                StringBuffer sb = new StringBuffer(curText.length());

                prevText = curText;

                Scanner scan = new Scanner(curText);

                for(int i = 0; scan.hasNextLine(); i++) {
                	String line = scan.nextLine();

                    if(i%2==0) {
                    	sb.append(line).append(CR_LF);
                    }
                }

                ta.setText(sb.toString());
        	}
        });

        // 3. ���ڻ��� - Param1�� ������ ���ڸ� �����ϴ� ���
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
	        		
        		// 1. TextField tfParam1�� ���� �����´�.(getText()���)
        		String para = tfParam1.getText();

        		if(para.equals("")) { return; } // tfParam1�� ����ٸ� �����Ѵ�.
	        		
        		// 2. �ݺ����� �̿��ؼ� curText�� �ѱ��ھ� �о Param1���� ������ ���ڿ��� ���ԵǾ� �ִ��� Ȯ���Ѵ�.
        		for(int i = 0; i < curText.length(); i++) {
        			char ch = curText.charAt(i);
        			if(para.indexOf(ch) == -1) // indexOf --> ���� para�� ch�� ������ -1�� ��ȯ�ȴ�.
                        // 3. ���� ���ԵǾ� ���� ������ sb�� �����ϰ� ���ԵǾ� ������ sb�� �������� �ʴ´�.
        				sb.append(ch);
        		}
	        		
        		// 4. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
        		ta.setText(sb.toString());
        	}
        });
        
        // 4. trim - ������ �¿������ �����ϴ� ���
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
        		
        		// 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 2. �о�� ������ ���ʰ���� ������ ������ �����Ѵ�.(StringŬ������ trim()���)
        			sb.append(line.trim() + CR_LF);
        		}

        		// 3. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
        		ta.setText(sb.toString());
        	}
        });
        
        // 5. ���ٻ��� - �� �� ���� ���
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
        		
        		// 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 2. �о�� ������ ������ ���� �� �����̸� sb�� �������� �ʴ´�.
        			if(!(line.equals(""))) { sb.append(line).append(CR_LF); }
        		}
        		
        		// 3. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
        		ta.setText(sb.toString());
        	}
        });
        
        // 6. ���λ��߰� --> �� ���ο� ���λ�, ���̻� ���̱�
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
        		
        		// 1. tfParam1�� tfParam2�� ���� �����´�.(getText()���)
        		String param1 = tfParam1.getText();
        		String param2 = tfParam2.getText();
        		
        		// 2. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 3. �о�� ������ �յڿ� param1�� param2�� ���� �ٿ��� sb�� ��´�.
        			sb.append(param1).append(line).append(param2).append(CR_LF);
        		}

        		// 4. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
        		ta.setText(sb.toString());
        	}
        });
        
        // 7. substring --> ���ڿ� �ڸ���
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());
	        		
        		prevText = curText;
        		
        		// 1. tfParam1�� tfParam2�� ���� �����´�.(getText()���)
        		int from = tfParam1.getText().length();
        		int to = tfParam2.getText().length();
        		
        		// 2. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 3. �о�� ������ substring���� �ڸ���. tfParam1�� tfParam2�� ���뿡 ������� ���̸�ŭ �ڸ���.
        			if(line.length() < (from+to)) { return; }
        			sb.append(line.substring(from, line.length() - to)).append(CR_LF);
        		}

        		// 4. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
        		ta.setText(sb.toString());
        	}
        });
        
        // 8. substring2 --> ������ ���ڿ��� ã�Ƽ� �� ��ġ���� �߶󳻱�
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());

        		prevText = curText;

        		// 1. tfParam1�� tfParam2�� ���� �����´�.(getText()���)
        		int from = tfParam1.getText().length();
        		int to = tfParam2.getText().length();
        		String para1 = tfParam1.getText();
        		String para2 = tfParam2.getText();

        		// 2. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			if(line.length() < (from+to)) { return; }
        			else if(!(line.contains(para1) || line.contains(para2))) { return; }
        			// 3. �� ���ο��� param1, param2�� ��ġ�ϴ� ���ڿ��� ��ġ�� ã�´�.
        			// 	 (param1�� ������ ���ʳ�����, param2�� ������ �����ʳ����� ã�� �����Ѵ�.)
        			//    param1�� param2�� �ѷ����� �κ��� sb�� �����Ѵ�.
        			int idx = line.indexOf(para1);
        			int idx2 = line.lastIndexOf(para2);
        			sb.append(line.substring(idx+from, idx2)).append(CR_LF);
        		}
        		
        		// 4. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
        		ta.setText(sb.toString());
        	}
        });
	} // registerEventHandler() ��.

    // main()!!
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	Ex07_TextTool07 win = new Ex07_TextTool07("Text Tool");
        win.show();
	} // main() ��.

    // ������!!
    public Ex07_TextTool07(String title) {
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

        for(int i=0; i < btn.length;i++) { // ��ư�迭�� �ϴ� Panel�� �ִ´�.
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
