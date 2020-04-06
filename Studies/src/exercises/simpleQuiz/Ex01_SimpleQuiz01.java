package exercises.simpleQuiz;

// data�� ������ ����, ��, �������� ������ ��������� �ݺ����� �̿��ϸ鼭 ��� ���� ������ �����.
class Ex01_SimpleQuiz01 { 
	public static void main(String[] args) { 
		String[] data = { 
				"���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public", 
                "���� �� �ڹ��� �����ڰ� �ƴ� ����?`5`&`|`++`!=`/`^", 
                "���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false", 
			}; 
		String question, answer, choice; // data�� ����, ��, �������� ������ �����ϱ� ���� ���ڿ� ����
		String[] temp; // data�� split���� ������ �� ��ȯ�Ǵ� ���ڿ��� �ӽ÷� �����ϱ� ���� ���ڿ� �迭
		for(int i=0;i<data.length;i++) {
			// 1. StringŬ������ String[] split(String regex, int limit)�� ����ؼ� ������ �������� ��������.
			temp = data[i].split("`", 3);
			question = temp[0];
			answer = temp[1];
			choice = temp[2];

			// 2. ������ ����ϼ���.
			System.out.println("[" + (i+1) + "] " + question);

			// 3. �������� ������ ���� String[] split(String regex)�� ����ϼ���.
			temp = choice.split("`");

            // 4.�ݺ����� �̿��ؼ� �������� ����ϼ���.
			for(int j = 0; j < temp.length; j++) {
				System.out.print((j+1) + "." + temp[j] + "\t");
			}
			System.out.println();
		} // for�� ����
	} // main() ���� 
}