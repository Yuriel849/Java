package exercises.byChapter.chapter_09;

// getRand() to get random numbers within a designated range

class Exercise09_12 {
	static int getRand(int from, int to) {
		if(from < to) {
			return (int)(Math.random() * (to-from+1)) + from;
		} else if (to < from) {
			return (int)(Math.random() * (from-to+1)) + to;
		}
		return 0;
	} // getRand()
	
	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			System.out.print(getRand(1, -3) + ",");
		}
	} // main()
}