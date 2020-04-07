package exercises.byChapter.chapter_07;

class Exercise07_18 {
	static void action(Robot r) { // action() takes as argument any instance of type Robot, or children of Robot
		if(r instanceof DanceRobot) { // Always first check with instanceof operator
			((DanceRobot) r).dance();
		} else if(r instanceof SingRobot) {
			((SingRobot) r).sing();
		} else if(r instanceof DrawRobot) {
			((DrawRobot) r).draw();
		}
	} // action()
	
	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
		
		for(int i = 0; i < arr.length; i++) { action(arr[i]); }
	} // main()
}

class Robot { }

class DanceRobot extends Robot {
	void dance() {
		System.out.println("The robot dances.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("The robot sings.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("The robot draws.");
	}
}