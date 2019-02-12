package threads;

// �������� �켱����

public class Ex04_Thread04 {
	public static void main(String[] args) {
		ThreadEx04 th1 = new ThreadEx04();
		ThreadEx05 th2 = new ThreadEx05();
		
		th2.setPriority(7);
		
		System.out.println("Priority of th1 (-) : " + th1.getPriority());
		System.out.println("Priority of th2 (|) : " + th2.getPriority());
		
		th1.start();
		th2.start();
	} // main() ��.
} // Ŭ���� ��.

class ThreadEx04 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
			for(int x = 0; x < 10000000; x++);
		}
	} // run() ��.
} // Ŭ���� ��.

class ThreadEx05 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
			for(int x = 0; x < 10000000; x++);
		}
	} // run() ��.
} // Ŭ���� ��.