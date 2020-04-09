package exercises.byChapter.chapter_09;

class Exercise09_06 {
	public static String fillZero(String src, int length) {
		if(src == null || src.length() == length) {
			return src;
		} else if(length <= 0) {
			return "";
		} else if(src.length() > length) {
			return src.substring(0, length);
		}

		char[] cArr = new char[length];
		
		for(int i = 0; i < cArr.length; i++) {
			cArr[i] = '0'; // Fill cArr with zeros
		}
		for(int i = 0; i < src.length(); i++) {
			cArr[cArr.length - (src.length()) + i] = src.charAt(i);
		}
		
		// OR...
//		System.arraycopy(src.toCharArray(), 0, cArr, length - src.length(), src.length()); 
		
		return new String(cArr);
	} // fillZero()
	
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src,  3));
	} // main()
}