package exercises.byChapter.chapter_09;

// Ŀ�ǵ�������κ��� 2~9������ �� �� ���ڸ� �޾Ƽ� �� ���� ������ �������� ����϶�.

class Exercise09_11 {
	public static void main(String[] args) {
		int start = 0, end = 0;
		
		try {		
			if(args.length < 2) {
				throw new Exception("���� �ܰ� �� ��, �� ���� ������ �Է��ϼ���.");
			}

			start = Integer.parseInt(args[0]);
			end = Integer.parseInt(args[1]);
			
			if((start < 2 || 9 < start) || (end < 2 || 9 < end)) {
				throw new Exception("���� ������ 2�� 9������ ���̾�� �մϴ�.\nUSAGE : GugudanTest 3 5");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("USAGE : GugudanTest 3 5");
			System.exit(0);
		} // try-catch�� ��.
		
		if(start > end) {
			int temp;
			temp = start;
			start = end;
			end = temp;
		} else if(start < end) {
			for(; start <= end; start++) {
				for(int i = 1; i <= 9; i++) {
					System.out.println(start + "*" + i + "=" + (start*i));
				}
				System.out.println();
			}
		} // if-else�� ��.
	} // main() ��.
} // Ŭ���� ��.