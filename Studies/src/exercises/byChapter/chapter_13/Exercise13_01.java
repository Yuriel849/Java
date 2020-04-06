package exercises.byChapter.chapter_13;

// Thread Ŭ�����κ��� ��� �޴� �ڵ带 Runnable �������̽��� �����ϵ��� �����϶�.

class Exercise13_01 {
	public static void main(String args[]) {
		Thread th1 = new Thread(new Thread1());
		th1.start();
	}
} // Ŭ���� ��.

class Thread1 implements Runnable {
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.print('-');
		}
	}
} // Thread1 Ŭ���� ��.

	// ������ Thread�� ��ӹ��� Ŭ����
//class Thread1 extends Thread {
//	public void run() {
//		for (int i = 0; i < 300; i++) {
//			System.out.print('-');
//		}
//	}
//}