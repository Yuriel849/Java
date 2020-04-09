package exercises.byChapter.chapter_09;

class Exercise09_09 {
	static String delChar(String src, String delCh) { // Removes characters in delCh from src
		String temp = "";
		for(int i = 0; i < src.length(); i++) {
			if(delCh.indexOf(src.charAt(i)) == -1) {
				temp += src.charAt(i);
			}
		}
		return temp;
	} // delChar()
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2    3   4\t5)" + " -> " + delChar("(1 2    3   4\t5)", " \t"));
	} // main()
}