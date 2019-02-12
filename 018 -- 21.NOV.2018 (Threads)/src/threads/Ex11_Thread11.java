package threads;

// Ex10_Thread10�� ���׷��̵�!! --> ���� ��ü���������� ����

class Ex11_Thread11 {
	public static void main(String[] args) throws Exception {
		Ex11_Thread11_1 th1 = new Ex11_Thread11_1("*");
		Ex11_Thread11_1 th2 = new Ex11_Thread11_1("**");
		Ex11_Thread11_1 th3 = new Ex11_Thread11_1("***");
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {}
	} // main() ��.
} // Ŭ���� ��.

class Ex11_Thread11_1 implements Runnable {
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	Thread th;
	
	Ex11_Thread11_1(String name) {
		th = new Thread(this, name); // Thread(Runnable r, String name) ���
	}
	
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		}
		System.out.println(Thread.currentThread().getName() + " - stopped");
	} // run() ��.
	
	public void suspend() { suspended = true; }
	public void resume() { suspended = false; }
	public void stop() { stopped = true; }
	public void start() { th.start(); }
} // Ŭ���� ��.