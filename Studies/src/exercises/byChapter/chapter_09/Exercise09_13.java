package exercises.byChapter.chapter_09;

class Exercise09_13 {
	public static void main(String[] args) {
		String src = "aabbccAABBCCaa";
		System.out.println(src);
		System.out.println("\"aa\" appears in this string " + stringCount(src, "aa") + " number of times.");
	} // main()
	
	static int stringCount(String src, String key) {
		return stringCount(src,key,0);
	} // stringCount(String, String)
	
	static int stringCount(String src, String key, int pos) {
		int count = 0;
		int index = 0;
		
		if(key == null || key.length() == 0) {
			return 0;
		}
		
		while((index = src.indexOf(key, pos)) != -1) {
			count++;
			pos = index + key.length();
		}
		
		return count;
	} // stringCount(String, String, int)
}