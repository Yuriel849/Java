package exercises.byChapter.chapter_08;

// ���� �Ǵ����� (error re-throwing)

class Exercise08_10 {
	public static void main(String[] args) {
		try {
			method1();
			System.out.println(6);
		} catch(Exception e) {
			System.out.println(7);
		}
	} // main() ��.
	
	static void method1() throws Exception {
		try {
			method2();
			System.out.println(1);
		} catch(NullPointerException e) {
			System.out.println(2);
			throw e; // ���ܸ� �ٽ� �߻���Ų�� --> ���� �Ǵ�����
			// method1()�� ���⼭ finally�� ���� �� ������ main()���� ���ư���.
				// ���� ���� catch�� ������ �ٽ� try-catch���� �ۼ��Ѵٸ�,
				// 				���ܸ� ó���ϰ� method1()�� ��� ������ �� �ִ�.
		} catch(Exception e) {
			System.out.println(3);
		} finally {
			System.out.println(4);
		}
		
		System.out.println(5);
	} // method() ��.
	
	static void method2() {
			// NullPointerException�� �߻���Ų��.
		throw new NullPointerException();
	} // method2() ��.
} // Ŭ���� ��.

