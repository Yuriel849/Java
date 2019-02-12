package threads;

class Ex01_Thread01 {
	public static void main(String[] args) {
		ThreadEx01 t1 = new ThreadEx01();
		
		Runnable r = new ThreadEx02();
		Thread t2 = new Thread(r); // ������ --> Thread(Runnable target)
		
		t1.start();
//		t1.start(); --> start()�� ������ ��ü �� �� �� ���� ���� ���� --> �ٽ� start()�Ϸ��� ������ ��ü�� �ٽ� �����ؾ�!
		t2.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("0." + Thread.currentThread().getName());
		}
		// ������ ���� �� ����/���ܰ� �߻��ص� �� �����常 ������ ����, �ٸ� ������� ���� ���� �ʴ´�.
	} // main() ��. --> ������ main �� �ٸ� �����尡 ���� �������� ���α׷��� ������� �ʴ´�.
} // Ŭ���� ��.

// �����带 ����� �� �Ĵ� �����尡 �� ���� �����ؾ� �Ѵ� --> �� ���� ����� ���� run() --> �׷��� run()�� �������̵��ϰų� �����ϴ� ���̴�.

class ThreadEx01 extends Thread { // Thread Ŭ������ ��� �޾Ƽ� run() �������̵�
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("1." + getName()); // superclass Thread�� getName() �ٷ� ȣ��
		}
	} // run() ��.
} // Ŭ���� ��.

class ThreadEx02 implements Runnable { // Runnable �������̽��� ���� --> Runnable���� �߻�޼��� run() �ۿ� ���⿡ Runnable ���� means run() ����
	public void run() {
		for(int i = 0; i < 5; i++) {
			// Thread.currentThread() -->  ���� �������� Thread�� ��ȯ�Ѵ�.
			System.out.println("2." + Thread.currentThread().getName());
			/* ThreadEx02�� ThreadŬ������ ������� ����!
			 * 	>> �׷��� �ٷ� �������� ���ϰ� ThreadŬ������ currentThread() �޼��� ����Ѵ�.
			 * 	>> currentThread()�� ���� �������� Thread�� ��ȯ�ϸ�, ���� �װ��� �̿��ؼ� Thread Ŭ������ ������ �� �ִ�.
			 */
		}
	} // run() ��.
} // Ŭ���� ��.