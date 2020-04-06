package exercises.byChapter.chapter_05;

// ���ĺ��� ���ڸ� �־��� ��ȣǥ�� ��ȣȭ�ϴ� ���α׷��� �ۼ��϶�.

class Exercise05_10 {
	public static void main(String[] args) {
		char[] abcCode = {
				'`', '~', '!', '@', '#', '$', '%', '^', '&', '*',
				'(', ')', '-', '_', '+', '=', '|', '[', ']', '{',
				'}', ';', ':', ',', '.', '/'
		};
//						    0    1    2    3    4    5    6    7    8    9
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

		String src = "abc123";
		String result = "";
		
		// ���ڿ� src�� ���ڸ� charAt()���� �ϳ��� �о ��ȯ �� result�� ����
		for(int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
		
			if('a' <= ch && ch <= 'z') {
				result += abcCode[ch - 'a'];
			} else if('0' <= ch && ch <= '9') {
				result += numCode[ch - '0'];
			}
		}
		
		System.out.println("src : " + src);
		System.out.println("result : " + result);
	}
}