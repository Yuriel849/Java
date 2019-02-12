package threads;

// join() ����ϱ�

class Ex12_Thread12 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		Ex12_Thread12_1 th1 = new Ex12_Thread12_1();
		Ex12_Thread12_2 th2 = new Ex12_Thread12_2();
		
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();
		
		try {
			th1.join(); // main �����尡 th1�� �۾��� ���� ������ ��ٸ���.
			th2.join(); // main �����尡 th2�� �۾��� ���� ������ ��ٸ���.
		} catch (InterruptedException e) {}

		System.out.println("�ҿ�ð� : " + (System.currentTimeMillis() - Ex12_Thread12.startTime));
	} // main() ��.
} // Ŭ���� ��.

class Ex12_Thread12_1 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("-"));
		}
	} // run() ��.
} // Ŭ���� ��.

class Ex12_Thread12_2 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("|"));
		}
	} // run() ��.
} // Ŭ���� ��.