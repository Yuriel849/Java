package exercises.byChapter.chapter_09;

// contains �޼��带 �ۼ��϶�.

class Exercise09_07 {
	static boolean contains(String src, String target) {
		return src.contains(target);
	} // contains() ��.
	
	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
	} // main() ��.
} // Ŭ���� ��.