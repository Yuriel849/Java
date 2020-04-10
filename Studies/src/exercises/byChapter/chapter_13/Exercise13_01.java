package exercises.byChapter.chapter_13;

class Exercise13_01 {
	public static void main(String args[]) {
		Thread th1 = new Thread(new Thread1());
		Thread th2 = new Thread(new Thread2());
		
		th1.start();
		th2.start();
	}
}

/* TWO ways to create a thread
 * 	>> Inherit Thread class and "public void run()"
 * 	>> Implement Runnable interface and "public void run()"
 */

class Thread1 implements Runnable {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print('-');
		}
	}
} // Thread1 class

class Thread2 extends Thread {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print('|');
		}
	}
} // Thread2 class