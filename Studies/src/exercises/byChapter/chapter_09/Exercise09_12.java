package exercises.byChapter.chapter_09;

// getRand �޼��带 �ۼ��϶�.

class Exercise09_12 {
	static int getRand(int from, int to) {
		// from ~ to ������ ���� ������ �������� ��ȯ�Ѵ� (inclusive)
		if(from < to) {
			return (int)(Math.random() * (to-from+1)) + from;
		} else if (to < from) {
			return (int)(Math.random() * (from-to+1)) + to;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			System.out.print(getRand(1, -3) + ",");
		}

	}

}
