package exercises.byChapter.chapter_06;

// �־��� ���ڿ��� ���ڷθ� �̷�����ִ��� Ȯ���ϴ� �޼��带 �ۼ��϶�.

public class Exercise06_22 {
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));
		
		str = "1234o";
		System.out.println(str + "�� �����Դϱ�? " + isNumber(str));
	}
	
	static boolean isNumber(String str) {
		//��ȿ�� üũ
		if(str == null || str == "") { return false; }
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(!('0' <= c && c <= '9')) { return false; }
		}
		return true;
	}
}
