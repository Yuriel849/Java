package exercises.byChapter.chapter_07;

// �־��� ��ü�� �޼��带 ȣ���ϴ� ���α׷��� �ۼ��϶�.

class Exercise07_18 {
	static void action(Robot r) { // �Ű������� Robot �ν��Ͻ� OR Robot�� child �ν��Ͻ�
		if(r instanceof DanceRobot) {
			((DanceRobot) r).dance();
		} else if(r instanceof SingRobot) {
			((SingRobot) r).sing();
		} else if(r instanceof DrawRobot) {
			((DrawRobot) r).draw();
		}
	} // action() ��.
	
	public static void main(String[] args) {
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot() };
		
		for(int i = 0; i < arr.length; i++) { action(arr[i]); }
	} // main ��.
} // Ŭ���� ��.

class Robot { }

class DanceRobot extends Robot {
	void dance() {
		System.out.println("���� ��ϴ�.");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("�뷡�� �մϴ�.");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("�׸��� �׸��ϴ�.");
	}
}