package exercises.simpleQuiz;

//data�� ������ ����, ��, �������� ������ �迭�� �ٽ� �����Ѵ�.
class Ex02_SimpleQuiz02 { 
	public static void main(String[] args) { 
		String[] data = { 
				"���� �� Ű���尡 �ƴ� ����?`2`final`True`if`public", 
                "���� �� �ڹ��� �����ڰ� �ƴ� ����?`5`&`|`++`!=`/`^", 
                "���� �� �޼����� ��ȯ���� ������ �ǹ��ϴ� Ű�����?`1`void`null`false", 
			}; 
		String[][] sData = new String[3][3];
		
		String[] temp; // sData�� 3��° ĭ�� ����, ������ ���ڿ��� split���� ������ �� ��ȯ�Ǵ� ���ڿ��� �ӽ÷� �����ϱ� ���� ���ڿ� �迭
		for(int i=0;i<data.length;i++) {
			// 1. StringŬ������ String[] split(String regex, int limit)�� ����ؼ� ������ �������� ��������.
			sData[i] = data[i].split("`", 3);

			// 2. ������ ����ϼ���.
			System.out.println("[" + (i+1) + "] " + sData[i][0]);

			// 3. �������� ������ ���� String[] split(String regex)�� ����ϼ���.
			temp = sData[i][2].split("`");

            // 4.�ݺ����� �̿��ؼ� �������� ����ϼ���.
			for(int j = 0; j < temp.length; j++) {
				System.out.print((j+1) + ". " + temp[j] + " ");
			}
			System.out.println();
		} // for�� ����
	} // main() ���� 
}