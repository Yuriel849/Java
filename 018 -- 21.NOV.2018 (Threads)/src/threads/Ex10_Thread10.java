package threads;

//Ex09_Thread09�� ��!!

class Ex10_Thread10 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		RunImplEx10 r1 = new RunImplEx10();
		RunImplEx10 r2 = new RunImplEx10();
		RunImplEx10 r3 = new RunImplEx10();
		Thread th1 = new Thread(r1, "*");
		Thread th2 = new Thread(r2, "**");
		Thread th3 = new Thread(r3, "***");
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			r1.suspend(); // r1�� �����ϴ� RunImplEx10 Ŭ������ suspend �޼��� ȣ��! --> th1.suspend()�� �ƴϴ�!
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(3000);
			r1.resume();
			Thread.sleep(3000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
		} catch (InterruptedException e) {}
	} // main() ��.
} // Ŭ���� ��.

class RunImplEx10 implements Runnable {
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
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
} // Ŭ���� ��.