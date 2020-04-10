package exercises.byChapter.chapter_13;

public class Exercise13_07 {
	static boolean stopped = false;
	
	public static void main(String[] args) {
		Thread3 th1 = new Thread3();
		th1.start();
		
		try {
			Thread.sleep(6*1000);
		} catch(Exception e) {}

		stopped = true;
		th1.interrupt();
		System.out.println("stopped");
	} // main()
}

class Thread3 extends Thread {
	public void run() {
		for(int i=0; !Exercise13_07.stopped; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(3*1000);
			} catch(Exception e) {}
		}
	} // run()
}