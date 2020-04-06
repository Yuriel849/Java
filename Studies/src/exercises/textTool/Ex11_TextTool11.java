package exercises.textTool;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

class Ex11_TextTool11 extends Frame implements WindowListener {
	// TextArea�� �����͸� ���κ��� �о param1�� �Էµ� ���Ŀ��� �����͸� �̾Ƴ��� �����ִ� '��������'��ư�� �����϶�.
 
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
            "distinct", // �ߺ��� ������ �� �����ؼ� �����ֱ�
            "distinct2", // �ߺ��� ������ �� �����ؼ� �����ֱ� - �ߺ�ī��Ʈ ����
            "��������", // �����Ϳ� ������ ���� �����ϱ�
            "��������", // �����Ϳ� ����� ���� �����ϱ�
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
        		String para1 = tfParam1.getText();
        		String para2 = tfParam2.getText();

        		// 2. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine();
        			// 3. �� ���ο��� param1, param2�� ��ġ�ϴ� ���ڿ��� ��ġ�� ã�´�.
        			// 	 (param1�� ������ ���ʳ�����, param2�� ������ �����ʳ����� ã�� �����Ѵ�.)
        			//    param1�� param2�� �ѷ����� �κ��� sb�� �����Ѵ�.
        			int from = line.indexOf(para1);
        			int to = line.lastIndexOf(para2);
        			
        			from = (from == -1) ? 0 : from+para1.length(); // tfParam1�� line�� ���� �� idx�� 0���� ����
        			to = (to == -1) ? line.length() : to; // tfParam2�� line�� ���� �� idx2�� line�� ������ index��+1�� ����
        			if(from > to) { return; }

        			sb.append(line.substring(from, to)).append(CR_LF);
        		}
        		
        		// 4. �۾��� ���� �Ŀ� sb�� ��� ������ ta�� �����ش�.(setText()���)
        		ta.setText(sb.toString());
        	}
        });
        
        // 9. distinct --> �ߺ� ���� ����
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());

        		prevText = curText;
        		
				Set<String> hSet = new HashSet<String>();

        		// 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �о HashSet�� ��´�.
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			hSet.add(scan.nextLine());
        		}
        		
        		// 2. HashSet�� ������ ArrayList�� �ű���� �����Ѵ�.(Collections�� sort()���)
        		List<String> list = new ArrayList<String>(hSet);
        		Collections.sort(list);
        		
        		// 3. ���ĵ� ArrayList�� ������ sb�� �����Ѵ�.
        		for(int i = 0; i < list.size(); i++) {
        			sb.append(list.get(i)).append(CR_LF);
        		}
        		
        		// 4. sb�� ����� ������ TextArea�� �����ش�.
        		ta.setText(sb.toString());
        	}
        });
        
        // 10. distinct2 --> �ߺ� ���� ���� + �ߺ� ���� ī��Ʈ
        btn[n++].addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		String curText = ta.getText();
        		StringBuffer sb = new StringBuffer(curText.length());

        		prevText = curText;
        		
        		// 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �о TreeMap�� ��´�. �� ������ Ű�� �����δ� �ߺ�ȸ���� �����Ѵ�.
        		Map<String, Integer> tMap = new TreeMap<String, Integer>();
        		
        		Scanner scan = new Scanner(curText);
        		while(scan.hasNextLine()) {
        			String line = scan.nextLine().trim();
        			// 2. tMap�� ���� ��, �̹� ���� Ű�� �ִ��� Ȯ���ϰ� �̹� �ִٸ�, �ش� Ű�� ���� �о 1������Ű��
        			if(tMap.containsKey(line)) {
        				Integer value = (Integer) tMap.get(line);
        				tMap.put(line, value+1);
        			} else {
        				// 3. tMap�� ���� ��, ���ο� Ű���̸� 1�� ������ �����Ѵ�.
        				tMap.put(line, new Integer(1));
        			}
        		} // while�� ��.    		

        		// 4. tfParam1�� ������ ���ڿ��� ������, �� ���ڿ��� Ű�� ���� �����ڷ� ����ϰ�, ������ ','�� �����ڷ� �����Ѵ�.
        		String delimiter = tfParam1.getText();
        		if(delimiter.length() == 0) {
        			delimiter = ",";
        		}
        		
        		// 5. Iterator�� �̿��ؼ� TreeMap�� ����� Ű�� ���� �����ڿ� �Բ� sb�� �����Ѵ�.
        		// 	 (TreeMap�� ����߱� ������, �ڵ������� Ű���� �������� �������� ���ĵȴ�.)
        		Iterator it = tMap.entrySet().iterator();
        		
        		while(it.hasNext()) {
        			Map.Entry entry = (Entry) it.next();
        			int value = ((Integer)entry.getValue()).intValue();
        			sb.append(entry.getKey()).append(delimiter).append(value).append(CR_LF);
        		}

        		// 6. sb�� ����� ������ TextArea�� �����ش�.
        		ta.setText(sb.toString());
        	}
        });
        
        // 11. ��������
        btn[n++].addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent ae) { 
            	String curText = ta.getText(); 
            	StringBuffer sb = new StringBuffer(curText.length()); 

            	prevText = curText; 

            	String pattern = tfParam1.getText(); 
                String delimiter = tfParam2.getText(); 
                  
                if(delimiter.length() == 0) { delimiter = ","; } 

                // 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
                Scanner scan = new Scanner(curText);
                while(scan.hasNextLine()) {
                	// 2. ������ ������(delimiter)�� ������ ���ڿ� �迭�� �����Ѵ�.
                	String[] line = scan.nextLine().split(delimiter);
                	// 3. param1�κ��� �Է¹��� pattern�� �� ���ο� �����ؼ� sb�� �����Ѵ�.
                	//   (MessageFormatŬ������ format()���)
                	sb.append(MessageFormat.format(pattern, line)).append(CR_LF);
                }
                  
                // 4. sb�� ������ TextArea�� �����ش�.
                ta.setText(sb.toString());
            }
        });
        
        // 12. ���� ����
        btn[n++].addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent ae) { 
        		String curText = ta.getText(); 
                StringBuffer sb = new StringBuffer(curText.length()); 

                prevText = curText; 

                String pattern = tfParam1.getText(); 
                String delimiter = tfParam2.getText(); 

                Pattern p = Pattern.compile(pattern); // Pattern == (0\d{1,2})-(\d{3,4})-(\d{4})

                if(delimiter.length() == 0) { delimiter = ","; }

                // 1. ScannerŬ������ �ݺ����� �̿��ؼ� curText�� ���δ����� �д´�.
                Scanner scan = new Scanner(curText);
                while(scan.hasNextLine()) {
                	// 2. �� ������ pattern�� �°� ��Ī��Ų��.(PatternŬ������ matcher()���)
                	String line = scan.nextLine();
                	Matcher m = p.matcher(line);
                	
                	// 3. pattern�� ��Ī�Ǵ� �����͸� �����ڿ� �Բ� sb�� �����Ѵ�.
                	if(m.find()) {
                		sb.append(m.group(1)).append(delimiter).append(m.group(2)).append(delimiter).append(m.group(3)).append(delimiter).append(CR_LF);
                	} else if(!m.find()) {
                		sb.append(line);
                	}
                }
                
                // 4. sb�� ������ TextArea�� �����ش�.
                ta.setText(sb.toString());
        	} 
        }); 
    } // registerEventHandler() ��.

    // main()!!
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
    	Ex11_TextTool11 win = new Ex11_TextTool11("Text Tool");
        win.show();
	} // main() ��.

    // ������!!
    public Ex11_TextTool11(String title) {
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