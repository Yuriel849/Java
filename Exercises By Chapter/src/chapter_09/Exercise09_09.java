package chapter_09;

// delChar �޼��带 �ۼ��϶�.

class Exercise09_09 {
	static String delChar(String src, String delCh) {
		// �־��� ���ڿ�(src)���� ������ ���ڵ�(delCh)�� ������ �� ��ȯ�϶�.
		String temp = "";
		for(int i = 0; i < src.length(); i++) {
			if(delCh.indexOf(src.charAt(i)) == -1) {
				temp += src.charAt(i);
			}
		}
		return temp;
	} // delChar() ��.
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2    3   4\t5)" + " -> " + delChar("(1 2    3   4\t5)", " \t"));
	} // main() ��.
} // Ŭ���� ��.