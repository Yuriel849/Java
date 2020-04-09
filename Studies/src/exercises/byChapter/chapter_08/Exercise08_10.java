package exercises.byChapter.chapter_08;

class Exercise08_10 {
	public static void main(String[] args) {
		try {
			method1();
			System.out.println(6); // Not used because of exception in method1()
		} catch(Exception e) {
			System.out.println(7);
		}
	} // main()
	
	static void method1() throws Exception {
		try {
			method2();
			System.out.println(1); // Not used because of exception in method2()
		} catch(NullPointerException e) {
			System.out.println(2);
			throw e;
		} catch(Exception e) {
			System.out.println(3); // Not used because try-catch only catches one exception
		} finally {
			System.out.println(4);
		}
		
		System.out.println(5); 	   // Not used because of exception thrown in try-catch
	} // method1()
	
	static void method2() {
		throw new NullPointerException();
	} // method2()
}