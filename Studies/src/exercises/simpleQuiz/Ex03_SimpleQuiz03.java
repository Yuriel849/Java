package exercises.simpleQuiz;

import java.util.Scanner;

// data�� ������ ����, ��, �������� ������ ��������� �ݺ����� �̿��ϸ鼭 ��� ���� ������ �����.
class Ex03_SimpleQuiz03 { 
	public static void main(String[] args) { 
		String[] data = { 
				"���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public", 
                "���� �� �ڹ��� �����ڰ� �ƴ� ����?`6`&`|`++`!=`/`^", 
                "���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false", 
			}; 
		
		Scanner scan = new Scanner(System.in);
		int score = 0; // ����ڰ� ���� ������ ����
		
		String question, answer, select; // data�� ���� & ��� ������ �����ϰ�, ������� ������ �����ϱ� ���� ���ڿ� ����
		String[] temp, choices; // data�� split���� ������ �� ��ȯ�Ǵ� ���ڿ��� �ӽ÷� �����ϱ� ���� ���ڿ� �迭
							    // data �߿��� �������� split���� ���� �� �����ϱ� ���� ���ڿ� �迭
		for(int i=0;i<data.length;i++) {
			// 1. StringŬ������ String[] split(String regex, int limit)�� ����ؼ� ������ �������� ��������.
			temp = data[i].split("`", 3);
			question = temp[0];
			answer = temp[1];
			choices = temp[2].split("`");

			// 2. ������ ����ϼ���.
			System.out.println("[" + (i+1) + "] " + question);

            // 3. �ݺ����� �̿��ؼ� �������� ����ϼ���.
			for(int j = 0; j < choices.length; j++) {
				System.out.print((j+1) + "." + choices[j] + "\t");
			}
			System.out.println();
			
			// 4. ������� �Է��� ��������.
			System.out.print("[��] ");
			select = scan.next();
			
			// 5. ������� �Է��� ���� ����� ��ġ�Ѵٸ� ���䰳���� 1�����ϼ���.
			if(select.equals(answer)) { score++; }
			System.out.println();
		} // for�� ����
		
		// 6. ����ڰ� �� �� �߿� �� ���� ������� ����ϼ���.
		System.out.println("���䰳�� / ��ü���װ��� : " + score + "/" + data.length);
	} // main() ���� 
}