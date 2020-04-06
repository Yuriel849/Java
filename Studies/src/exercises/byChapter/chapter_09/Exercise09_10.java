package exercises.byChapter.chapter_09;

// format �޼��带 �ۼ��϶�.

public class Exercise09_10 {
	static String format(String str, int length, int alignment) {
		// str -> ��ȯ�� ���ڿ�
		// length -> ��ȯ�� ���ڿ��� ����
		// alignment -> ��ȯ�� ���ڿ��� �������� (0: ���� ����, 1: ��� ����, 2: ������ ����)
	
		// 1. length�� ���� str�� ���̺��� ������  length��ŭ�� �߶� ��ȯ�Ѵ�.
		if(str.length() > length) {
			return str.substring(0, length);
		} else {
			// 2. 1�� ��찡 �ƴϸ�, lengthũ���� char�迭�� �����ϰ� �������� ä���.
			char[] origin = str.toCharArray();
			char[] result = new char[length];
			for(int i = 0; i < result.length; i++) {
				result[i] = ' '; // �迭 result�� �������� �ʱ�ȭ�Ѵ�.
			}
			// 3. ��������(alignment)�� ���� ���� ���ڿ�(str)�� ������ ��ġ�� �����Ѵ�.
			if(alignment == 0) {
				System.arraycopy(origin, 0, result, 0, origin.length);
			} else if(alignment == 1) {
				System.arraycopy(origin, 0, result, (length - str.length())/2, origin.length);
			} else if(alignment == 2) {
				System.arraycopy(origin, 0, result, (length - str.length()), origin.length);
			}
			// 4. 2���� ������ char�迭�� ���ڿ��� ���� ��ȯ�Ѵ�.
			return new String(result);
		}
	} // format() ��.
	
	public static void main(String[] args) {
		String str = "������";
		
		System.out.println(format(str,7,0)); // ���� ����
		System.out.println(format(str,7,1)); // ��� ����
		System.out.println(format(str,7,2)); // ������ ����
	} // main() ��.
} // Ŭ���� ��.