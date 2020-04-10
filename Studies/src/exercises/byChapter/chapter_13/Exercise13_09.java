package exercises.byChapter.chapter_13;

import javax.swing.JOptionPane;

class Exercise13_09 {
	public static void main(String[] args) throws Exception {
		Exercise13_09_1 th1 = new Exercise13_09_1();
		th1.start();
	
		String input = JOptionPane.showInputDialog("Please type something.");
	
		System.out.println("You have entered \"" + input + "\".");
	
		th1.interrupt();
	}
}

class Exercise13_09_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000); // Sleep for 1 second
			} catch(InterruptedException e) {
				interrupt();
			}
		}
		
		System.out.println("Sleep interrupted.");
	} // run()
}