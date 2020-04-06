package exercises.byChapter.chapter_09;

// count �޼��带 �ۼ��϶�.

class Exercise09_05 {
	public static int count(String src, String target) {
		int count = 0; // ã�� Ƚ��
		int pos = 0;   // ã�� ������ ��ġ
		
		while(true) {
			// 1. src���� target�� pos�� ��ġ���� ã�´�.
			pos = src.indexOf(target, pos);
			// 2. indexOf�� ����� -1�̸� �ݺ����� ���������� count�� ��ȯ�Ѵ�.
			if(pos == -1) {
				break;
			} else {
				// 3. ã���� count�� ���� 1 ������Ű��, pos�� ���� target.length��ŭ ������Ų��.
				count++;
				pos += target.length(); // pos�� ã�� �ܾ� ���ķ� �ű��.
			}
		} // while�� ��.
		return count;
	} // count() ��.

	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	} // main() ��.
} // Ŭ���� ��.