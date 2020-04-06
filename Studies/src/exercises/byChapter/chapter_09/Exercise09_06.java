package exercises.byChapter.chapter_09;

// fillZero �޼��带 �ۼ��϶�.

class Exercise09_06 {
	public static String fillZero(String src, int length) {
		// 1. src�� null�̰ų� src.length()�� length�� ������ src�� �״�� ��ȯ�Ѵ�.
		if(src == null || src.length() == length) {
			return src;
		} else if(length <= 0) {
			// 2. length�� ���� 0���� ���ų� ������ �� ���ڿ�("")�� ��ȯ�Ѵ�.
			return "";
		} else if(src.length() > length) {
			// 3. src�� ���̰� length�� ������ ũ�� src�� length��ŭ �߶� ��ȯ�Ѵ�.
			return src.substring(0, length);
		}
		// 4. ���̰� length�� char�迭�� �����Ѵ�.
		char[] cArr = new char[length];
		
		// 5. 4���� ������ char�迭�� '0'���� ä���.
		for(int i = 0; i < cArr.length; i++)
			{ cArr[i] = '0'; }
		
		// 6. src���� ���ڹ迭�� �̾Ƴ��� 4���� ������ �迭�� �����Ѵ�.
		for(int i = 0; i < src.length(); i++)
			{ cArr[cArr.length - (src.length()) + i] = src.charAt(i); }
		// OR...
//		System.arraycopy(src.toCharArray(), 0, cArr, length-src.length(), src.length()); 
		// 7. 4���� ������ �迭�� String�� �����ؼ� ��ȯ�Ѵ�.
		return new String(cArr);
	} // fillZero() ��.
	
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src,  3));
	} // main() ��.
} // Ŭ���� ��.