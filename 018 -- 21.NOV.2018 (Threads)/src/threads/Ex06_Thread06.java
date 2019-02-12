package threads;

// sleep() �׽�Ʈ

class Ex06_Thread06 {
	public static void main(String[] args) throws Exception {
		MyThread t = new MyThread();
		t.start();
		
		// main �����带 5�� �� ����ٰ�...
		Thread.sleep(3 * 1000); // main�� �ܴ�
		// ...3�� �Ŀ� t �����带 �����
		System.out.println("main �����尡 ����ϴ�.");
		t.sleep(500); // t��� �ᵵ ������ü�� main�� �ܴ�
		t.interrupt();
	} // main() ��.
} // Ŭ���� ��.

class MyThread extends Thread {
	public void run() {
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) { }
			// ������ ���� ���� �ƴ϶� ���ܸ� �߻����Ѽ� ����� ���̱⿡ catch�� ������ ��� �ȴ�.
		System.out.println("�Ͼ���ϴ�.");
	} // run() ��.
} // Ŭ���� ��.