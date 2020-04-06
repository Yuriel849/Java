package exercises.byChapter.chapter_13;

import javax.swing.JOptionPane;

class Exercise13_09 {
	public static void main(String[] args) throws Exception {
		Exercise13_09_1 th1 = new Exercise13_09_1();
		th1.start();
	
		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���.");
	
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
	
		th1.interrupt(); // �����忡�� �۾��� ���߶�� ��û�Ѵ�.
	} // main() ��.
} // Ŭ���� ��.

class Exercise13_09_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			try {
				Thread.sleep(1000); // 1�� ����
			} catch(InterruptedException e) {
				interrupt();
				/* Ȥ�� �ڰ� �ִ� ���¿��� interrupt�Ǹ� �ٽ� ����� interrupted ���´� �ٽ� false�� �ʱ�ȭ�ȴ�.
				 * 	>> ������ main �����忡�� interrupt�ϸ� �װ��� �����ϱ� ���ؼ��� ��
				 * 		>> �ٽ� �ڽ��� interrupt�ؼ� �����
				 */
			}
		}
		
		System.out.println("ī��Ʈ�� ����Ǿ����ϴ�.");
	} // run() ��.
} // Ŭ���� ��.