package exercises.consoleApp;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* ���� ���丮�� ���ϰ� ���丮�� ����� �����ִ� ��ɾ� dir�� �����϶�.
 * 	>> dir�� �Է��ϸ� ��� ���ϰ� ���丮��, dir *ex?.* �� ���� ������ �Է��ϸ� ���ϰ� ��ġ�ϴ� ���� �Ǵ� ���丮�� ����� ��������Ѵ�.
 * 	>> (���Ͽ��� '*'�� '?'�� ���ϵ� ī��� '*'�� ������ ���� ���ڰ� �� �� ������, '?'�� ������ �ѱ��ڸ� �ǹ��Ѵ�.
 */

class Ex06_ConsoleApp05 { 
	static String[] argArr; // ����� �Է��� ������� ���ڿ� �迭
	@SuppressWarnings("rawtypes")
	static LinkedList q = new LinkedList(); // ������� �Է��� ������ queue�μ� LinkedList Ŭ������ ��ü ����
	static final int MAX_SIZE = 5; // q�� �ִ� ũ��
	
    static File curDir; // ���� ���丮

	static {
		try {
			// 1. �ý��ۼӼ� "user.dir" ���� �о File ��ü�� �����, curDir�� �Ҵ��϶�.
			curDir = new File(System.getProperty("user.dir"));
			// 2. 1���� �ڵ带 ������ ����ó���϶�.
		} catch (Exception e) {}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
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
				} else if(command.equals("history")) {  // equalsIgnoreCase��� equals�� ���.
					history(); 
				} else if(command.equals("dir")) { 
					dir(); 
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
} // Ŭ���� ��.