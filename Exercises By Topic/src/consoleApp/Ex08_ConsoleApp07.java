package consoleApp;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/* ������ Ű���带 ������ ���Ͽ��� ã�Ƽ� ȭ�鿡 �����ִ� find��ɾ �����϶� (i.e. �ش� KEYWORD�� ���Ե� ���ΰ� ���ι�ȣ�� ȭ�鿡 ���)
 * 	>> ��ɾ��� ������ 'find KEYWORD FILE_NAME'�̸�, ���Ŀ� ���� �������� ������ �����ش�.
 * 		>> KEYWORD - ������ ���Ͽ��� ã�� ���ϴ� ���ڿ�
 * 		>> FILE_NAME - KEYWORD�� ���Ե� ������ ã�� ���� (console*.*�� ���� ������������ ����)
 */

class Ex08_ConsoleApp07 { 
	static String[] argArr; // ����� �Է��� ������� ���ڿ� �迭
	@SuppressWarnings("rawtypes")
	static LinkedList q = new LinkedList(); // ������� �Է��� ������ queue�μ� LinkedList Ŭ������ ��ü ����
	static final int MAX_SIZE = 5; // q�� �ִ� ũ��
	
    static File curDir; // ���� ���丮

	static {
		try {
			// �ý��ۼӼ� "user.dir" ���� �о File ��ü�� �����, curDir�� �Ҵ��϶�.
			curDir = new File(System.getProperty("user.dir"));
		} catch (Exception e) {}
	}
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // �ѹ��� �����ؼ� �����ϸ�Ǵϱ� while�� �ۿ� ��ġ
		String input = "";
		String command = "";
		while(true)	{
			try {
				String prompt = curDir.getCanonicalPath() + ">>";
				System.out.print(prompt);
				
				// ȭ�����κ��� ���δ����� �Է¹޴´�.
				input = scan.nextLine();
				
				// �Է°��� q�� �����Ѵ�
				save(input);
				
				// �Է� ���� ������ �յ� ������ �����Ѵ�
				input.trim();
				
				// �Է� ���� ��ɶ����� ������ ������ �����ڷ� �ؼ� ������ argArr�� ��´�. (String Ŭ������ split() ���)
				argArr = input.split(" +");
					// split�� �μ��δ� ���Խ��� ��� �ϴµ�, " +"�� �ǹ̴� + ���� ����(���⼭�� ����)�� �� �� Ȥ�� �� �̻��̶�� �ǹ̴�.
				
				// input�� split()�� �� �� ù��° ������ command�� �����Ѵ�.
				command = argArr[0].trim();
				
				// 0��° ��Ұ� �����̸� while�� ���� �ݺ��� continue�Ѵ�.
				if("".equals(command)) { continue; } 
				
				// ��ɾ �ҹ��ڷ� �ٲ۴�.
				command = command.toLowerCase(); 
				
				if(command.equals("q")) { // q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�. 
					System.out.println("Thank you for utilizing our services :)");
					System.exit(0); 
				} else if(command.equals("history")) {  // ������ command�� �ҹ��ڷ� �ٲ�����ϱ� equalsIgnoreCase��� equals�� ���.
					history(); 
				} else if(command.equals("dir")) {
					dir();
				} else if(command.equals("type")) {
					type();
				} else if(command.equals("find")) {
					find();
				} else {
					for(String str : argArr) {
						System.out.println(str);
					} // for�� ��.
				} // if-else�� ��.
			} catch(Exception e) {
				System.out.println("�Է¿����Դϴ�.");
			} // ����ó�� ��.
		} // while(true) ��.
	} // main() ��.
	
	
// ������� �Է��� q�� �����ϴ� �޼���
	@SuppressWarnings("unchecked")
	public static void save(String input) { 
		if(input==null || "".equals(input)) { return; }
			// queue�� �ִ�ũ��(MAX_SIZE)�� ������ ���� ������ ���尪�� �����Ѵ�.
		else if(q.size() == MAX_SIZE) { q.remove(); }
			// queue�� �����Ѵ�.
		q.add(input);
	} // save() ��.

	
// ����ڰ� �Է��� �ֱ� ����� �����ִ� �޼���
	public static void history() { 
		int i = 0;
			// LinkedList�� ����� ����(�ֱ� MAX_SIZE���� ��ɾ�)�� �����ش�.
		@SuppressWarnings("rawtypes")
		Iterator it = q.iterator();
		while(it.hasNext()) {
			System.out.println((i+1) + "." + it.next());
		}
//		for(; i < MAX_SIZE; i++) {
//			System.out.println((i+1) + "." + q.get(i));
//		}
	} // history() ��.
	
// ���� ���丮�� ���ϰ� ���丮�� �����ִ� �޼���
	public static void dir() { 
		String pattern = ""; 
		
		File[] file = curDir.listFiles();
		switch(argArr.length) { 
			case 1 : // dir�� �Է��� ��� ���� ���丮�� ��� ���ϰ� ���丮�� �����ش�.
				// 1. �ݺ����� �̿��ؼ� ������丮�� ��� ������ ����� ����Ѵ�.
				for(File f : file) { 
					// 2. ���ǹ��� ���� ����ؼ� ���丮(����)�� ���, �̸��� �յڿ� '[' �� ']'�� �ٿ��� ����Ѵ�.
					if(f.isDirectory()) { 
						System.out.println("["+f.getName()+"]"); 
					} else { 
						System.out.println(f.getName()); 
					} 
				} 
				break; 
			case 2 : // // dir�� ������ ���� �Է��� ���, ���� ��� dir *.class
				pattern = argArr[1]; 
				
				pattern = pattern.toUpperCase(); // ���Ͽ��� ��ҹ��ڸ� �������� �ʵ��� �빮�ڷ� �����Ѵ�.
				 
				// 1. �Էµ� ����(pattern)�� ���Խ� ǥ��(Regular Expression)�� �˸°� ġȯ�Ѵ�.
				pattern = pattern.replace("*",".*"); 
				pattern = pattern.replace("?","."); 

				Pattern p = Pattern.compile(pattern); 

				for(File f : file) {
                    // 2. ��ҹ��ڱ����� ���� �ʱ� ���ؼ�, ���ϰ� ���������� �����̳� ���丮���� �빮�ڷ� �����ؾ��Ѵ�.
					String tmp = f.getName().toUpperCase();
					Matcher m = p.matcher(tmp); 
					
					// 3. �ݺ����� �̿��ؼ� ���� ���丮 ��, �Էµ� ���ϰ� ��ġ�ϴ� �͵鸸 ����Ѵ�.
					if(m.matches()) {
						// 4. ���ǹ��� ���� ����ؼ� ���丮(����)�� ���, �̸��� �յڿ� '[' �� ']'�� �ٿ��� ����Ѵ�.
						if(f.isDirectory()) {
							System.out.println("["+f.getName()+"]");
						} else {
							System.out.println(f.getName());
						}
					}
				} // for�� ��.
				break; 
			default : 
				System.out.println("USAGE : dir [FILENAME]"); 
		} // switch�� ��. 
	} // dir() ��.
	
// ������ ������ ������ �����ִ� �޼���
	public static void type() throws IOException {
		if(argArr.length != 2) {
			System.out.println("Usage : type FILE_NAME");
			return;
		}
		
		String fileName = argArr[1];
		
		File tmp = new File(curDir, fileName); // ������ File(String pathName, String fileName)
		
		// 1. ����(tmp)�� �����ϴ��� Ȯ���ϰ�,
		if(tmp.exists()) {
			// 2. �����ϸ�, ������ ������ ȭ�鿡 ����Ѵ�.
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			for(int i = 1; (line = br.readLine()) != null; i++) {
				System.out.println(i + ":" + line);
			}
			br.close();
			// 3. �������� ������, �������� �ʴ� �����̶�� ����Ѵ�.
		} else { System.out.println("�������� �ʴ� �����Դϴ�."); }
		
		return;
	} // type() ��.
	
// ������ Ű���带 ������ ���Ͽ��� ã�Ƽ� ȭ�鿡 �����ִ� �޼���
	@SuppressWarnings("resource")
	public static void find() throws IOException {
		if(argArr.length!=3) { 
			System.out.println("USAGE : find KEYWORD FILE_NAME"); 
			return; 
		}
		
		String keyword = argArr[1]; 
		String fileName = argArr[2]; 
		
		File tmp = new File(fileName); 
		// 1. ����(tmp)�� �����ϸ�,
		if(tmp.exists()) {
			// 2. �ݺ����� �̿��ؼ� ���κ��� �о keyword�� ���ԵǾ����� Ȯ���Ѵ�.
			FileReader fr = new FileReader(tmp);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			for(int i = 1; (line = br.readLine()) != null; i++) {
				if(line.contains(keyword)) { // contains()�� ���������� indexOf()�� ����Ѵ� --> i.e. ���� �Ȱ���!!
					// 3. keyword�� ���Ե� ������ �߰��ϸ�, ���ι�ȣ�� �Բ� �ش� ������ ȭ�鿡 ����Ѵ�.
					System.out.printf("%d : %s\n", i, line);
				}
			}
		} else {
			// 4. tmp�� �������� ������, �������� �ʴ� �����̶�� ȭ�鿡 ����Ѵ�.
			System.out.println(fileName + "�� �������� �ʴ� �����Դϴ�.");
		}
		return; 
	} // find() ��.
} // Ŭ���� ��.