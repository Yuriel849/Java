package exercises.byChapter.chapter_07;

// Outer and inner classes, static and non-static classes

class Outer {
	int iv = 10;
	
	class Inner {
		int iv = 20;
		
		void method() {
			int iv = 30;
			
			System.out.println("\nCalling Inner.method()");
			System.out.println(			  iv);
			System.out.println(		 this.iv);
			System.out.println(Outer.this.iv);
		} // Inner.method()
	}
	
	static class Inside {
		int iv = 40;
	}
}

class Exercise07_25 {
	public static void main(String[] args) {
		Outer.Inside inside = new Outer.Inside();
		System.out.println(inside.iv);
		
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		System.out.println(in.iv);
		in.method();
	}
}