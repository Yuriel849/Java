package exercises.byChapter.chapter_13;

// ������ th1�� �����ؼ� �����Ų �� 6�� �ڿ� ������Ų��.
//	>> ������ ������ �����Ű�� ������Ų �������� �� �ʰ� ���� �Ŀ����� �����.
//	>> �� ������ �����ϰ� �����带 ������Ű�� ��ü���� �ٷ� �����ǵ��� �ڵ带 �����϶�.
//		>> stopped�� ���°� �ٲ� th1�� �� ��� sleep ���̸� ������ �� ����. �׷��� sleep�� interrupt�� �ʿ䰡 �ִ�.

public class Exercise13_07 {
	static boolean stopped = false;
	
	public static void main(String[] args) {
		Thread5 th1 = new Thread5();
		th1.start();
		
		try {
			Thread.sleep(6*1000);
		} catch(Exception e) {}
		stopped = true; // �����带 ������Ų��.
		th1.interrupt();
		System.out.println("stopped");
	} // main() ��.
} // Ŭ���� ��.

class Thread5 extends Thread {
	public void run() {
	// Exercise13_7.stopped�� ���� false�� ���� �ݺ��Ѵ�.
		for(int i=0; !Exercise13_07.stopped; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(3*1000);
			} catch(Exception e) {}
		}
	} // run() ��.
} // Thread5 Ŭ���� ��.