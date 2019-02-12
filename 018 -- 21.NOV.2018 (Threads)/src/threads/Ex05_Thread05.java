package threads;

// ���󾲷���

class Ex05_Thread05 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new Ex05_Thread05());
		t.setDaemon(true); // �� �κ��� ������ run()������ ���ѹݺ��� ���� ������ ������� �ʴ´�.
		t.start();
		
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(i);
			
			if(i == 5) { autoSave = true; }
		}
		
		System.out.println("���α׷��� �����մϴ�.");
	} // main() ��.

	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000); // 3�ʸ���
			} catch (InterruptedException e) {}
			// autoSave�� ���� true�̸� autoSave()�� ȣ���Ѵ�.
			if(autoSave) {
				autoSave();
			}
		}
	} // run() ��.
	
	public void autoSave() {
		System.out.println("�۾������� �ڵ�����Ǿ����ϴ�.");
	} // autoSave() ��.
} // Ŭ���� ��.