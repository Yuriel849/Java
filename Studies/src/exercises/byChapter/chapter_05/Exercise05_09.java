package exercises.byChapter.chapter_05;

// �迭 star�� �ð�������� 90�� ȸ�����Ѽ� ����϶�.

class Exercise05_09 {
	public static void main(String[] args) {
		char[][] star = {
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', ' ', ' ', ' '},
				{'*', '*', '*', '*', '*'},
				{'*', '*', '*', '*', '*'},
		};
		
		char[][] result = new char[star[0].length][star.length];
		
		// �迭 star�� �ִ� �״�� ���.
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		} // for�� ��.
		
		System.out.println();
		
		// �迭 star�� �ð�������� 90�� ȸ�����Ѽ� ���.
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[i].length; j++) {
				result[j][star.length-(1+i)] = star[i][j];
			}
		} // for�� ��.
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		} // for�� ��.
	} // main() ��.
} // Ŭ���� ��.