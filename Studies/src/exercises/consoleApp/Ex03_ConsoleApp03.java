package exercises.consoleApp;

import java.util.LinkedList;
import java.util.Scanner;

// ����ڰ� �Է��� ��ɶ����� save(String input)�޼���� �����ϰ� history()�޼���� ������� �Է� �̷��� �����ִ� ����
class Ex03_ConsoleApp03 {
	static String[] argArr; // ����� �Է��� ������� ���ڿ� �迭
	static LinkedList q = new LinkedList(); // ������� �Է��� ������ queue�μ� LinkedList Ŭ������ ��ü ����
	static final int MAX_SIZE = 5; // q�� �ִ� ũ��
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		String command = "";
		while(true)	{
			String prompt = ">> ";
			System.out.print(prompt);
			
			// ȭ�����κ��� ���δ����� �Է¹޴´�.
			input = scan.nextLine();
			
			// �Է°��� q�� �����Ѵ�
			save(input);
			
			// �Է� ���� ������ �յ� ������ �����Ѵ�
			input.trim();
			
			// �Է� ���� ��ɶ����� ������ ������ �����ڷ� �ؼ� ������ argArr�� ��´�. (String Ŭ������ split() ���)
			argArr = input.split(" ");
			
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
            } else {
            	for(int i=0; i < argArr.length;i++) {  
					if(argArr[i].equals("")) { continue; }
					/* �� ���ڿ��̸� continue�� ���� >>
					 * ex) ����� �Է� --> "1 2  3   4" --> 1 & 2 ���̿� ���� �� ĭ, 2 & 3 ���̿� ���� 2ĭ, 3 & 4 ���̿� ���� 3ĭ
					 * 	>> ������ �������� �����ϱ� (split(" ")) ���� �յڰ� ���� �ٸ� ���ڿ��� ����
					 * 	>> ������ ������ 2ĭ �̻��� �� --> ���� ����ĭ�� ������ �������� ������, �� ����� ���� ���̴� �ƹ��͵� ����
					 * 	>> �ƹ��͵� �����ϱ� argArr���� �ش� ĭ�� �� ���ڿ��� ����ȴ�
					 */
				else { System.out.println(argArr[i]); }
            	} // for�� ��.
            	} // if-else�� ��.
		} // while(true) ��.
	} // main() ��.
	
	// ������� �Է��� q�� �����ϴ� �޼���
	public static void save(String input) { 
		if(input==null || "".equals(input)) { return; }
			// queue�� �ִ�ũ��(MAX_SIZE)�� ������ ���� ������ ���尪�� �����Ѵ�.
		else if(q.size() == MAX_SIZE) { q.remove(0); }
			// queue�� �����Ѵ�.
		q.add(input);
	} // save() ��.

	// ����ڰ� �Է��� �ֱ� ����� �����ִ� �޼���
	public static void history() {
			// LinkedList�� ����� ����(�ֱ� MAX_SIZE���� ��ɾ�)�� �����ش�.
		for(int i = 0; i <= MAX_SIZE; i++) {
			System.out.println((i+1) + "." + q.get(i));
		}
	} // history() ��.
} // class ��.