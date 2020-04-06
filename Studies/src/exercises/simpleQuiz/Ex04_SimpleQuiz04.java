package exercises.simpleQuiz;

import java.util.Scanner;

// data�� ������ ����, ��, �������� ������ ��������� �ݺ����� �̿��ϸ鼭 ��� ���� ������ �����.
class Ex04_SimpleQuiz04 { 
	public static void main(String[] args) { 
		String[] data = { 
				"���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public", 
                "���� �� �ڹ��� �����ڰ� �ƴ� ����?`6`&`|`++`!=`/`^", 
                "���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false", 
			}; 
		
		Scanner scan = new Scanner(System.in);
		int score = 0; // ����ڰ� ���� ������ ����
		
		shuffle(data); // �켱 ������ ������ ���´� --> ����, ��, �������� ������ ���� �������� �����ؼ� �̸� �Ѵ�.
		
		String question; // ������ �����ϱ� ���� ���ڿ� ����
		String answer; // ������ ���� �����ϱ� ���� ���ڿ� ����
		String select; // ����ڰ� ������ ���� �����ϱ� ���� ���ڿ� ����
		String[] temp; // data�� split���� ������ �� ��ȯ�Ǵ� ���ڿ��� �ӽ÷� �����ϱ� ���� ���ڿ� �迭
		String[] choices; // data �߿��� �������� split���� ���� �� �����ϱ� ���� ���ڿ� �迭
		
		for(int i=0;i<data.length;i++) {
			// ������ ��� �������� ������.
			temp = data[i].split("`", 3);
			question = temp[0];
			answer = temp[1];
			choices = temp[2].split("`");

			// �������� ���� ��, answer�� ���� �����Ѵ�.
			answer = choices[Integer.parseInt(answer) - 1]; // answer���� �信 �ش��ϴ� ��ȣ�� �ƴ϶� ���ڿ��� ����ȴ�
			
			// �������� ���´�.
			shuffle(choices);
			
			// ������ ����Ѵ�.
			System.out.println("[" + (i+1) + "] " + question);
			
            // �ݺ����� �̿��ؼ� �������� ����Ѵ�.
			for(int j = 0; j < choices.length; j++) {
				System.out.print((j+1) + "." + choices[j] + "\t");
				if(answer == choices[j]) { answer = String.valueOf(j+1); }
					/* answer�� ����� ���ڿ��� �ش��ϴ� choice�� index �� j�� �����Ѵ�.
					 * 	>> ����ڴ� ����(j+1)�� �Է��ϱ� ������ answer�� ���ڷ� �ٲ��� �Ѵ�.
					 */
			}
			System.out.println();
			
			// ������� �Է��� �޴´�.
			System.out.print("[��] ");
			select = scan.next();
			
			// ������� �Է��� ���� ����� ��ġ�Ѵٸ� ���䰳���� 1�����Ѵ�.
			if(select.equals(answer)) { score++; System.out.println("run");}
			System.out.println();
		} // for�� ����
		
		// ����ڰ� �� �� �߿� �� ���� ������� ����Ѵ�.
		System.out.println("���䰳�� / ��ü���װ��� : " + score + "/" + data.length);
	} // main() ����
	
	public static void shuffle(String[] data) {
		// �迭 data�� ������ 0���� �۰ų� ������ �޼��带 �����Ѵ�.
		if(data.length <= 0) { return; }

		// 2. �������� ������ ���´�. �ݺ��� & Math.random() ����϶�.
		for(int i = 0; i < 10; i++) {
			int r = (int)(Math.random() * (data.length));
			int s = (int)(Math.random() * (data.length));
			String temp = data[r];
			data[r] = data[s];
			data[s] = temp;
		}
	} // shuffle() ����
}