package exercises.byChapter.chapter_09;

public class Exercise09_10 {
	static String format(String str, int length, int alignment) {
		if(str.length() > length) {
			return str.substring(0, length);
		} else {
			char[] origin = str.toCharArray();
			char[] result = new char[length];
			for(int i = 0; i < result.length; i++) {
				result[i] = ' ';
			}

			if(alignment == 0) {
				System.arraycopy(origin, 0, result, 0, origin.length);
			} else if(alignment == 1) {
				System.arraycopy(origin, 0, result, (length - str.length())/2, origin.length);
			} else if(alignment == 2) {
				System.arraycopy(origin, 0, result, (length - str.length()), origin.length);
			}

			return new String(result);
		}
	} // format()
	
	public static void main(String[] args) {
		String str = "Resolute"; // str.length == 8
		
		System.out.println(format(str,15,0));
		System.out.println(format(str,15,1));
		System.out.println(format(str,15,2));
	} // main()
}