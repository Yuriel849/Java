package exercises.byChapter.chapter_13;

// ������� main �����忡�� ���ܰ� �߻��ϸ鼭 ����Ǿ�� ������, eclipse���� �׷��� ������� �ʴ´�.

class Exercise13_06 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception	{
		Thread4 th1 = new Thread4();
		th1.setDaemon(true);
		th1.start();
		
		try {
			th1.sleep(5*1000);
		} catch(Exception e) {}
		
		throw new Exception("��~!!!");
	} // main() ��.
} // Ŭ���� ��.

class Thread4 extends Thread {
	public void run() {
		for(int i=0; i < 10; i++) {
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch(Exception e) {}
		}
	} // run() ��.
} // Thread4 Ŭ���� ��.