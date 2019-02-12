package threads;

// ����ȭ ���� --> ����ȭ�� �� �Ǿ��ִ�.

public class Ex13_Thread13 {
	public static void main(String[] args) {
		Runnable r = new RunnableEx13();
		new Thread(r).start(); // ThreadGroup�� ���� �����ǹǷ� gc ����� �ƴϴ�.
		new Thread(r).start();
	} // main() ��.
} // Ŭ���� ��.

class Account {
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	public void withdraw(int money) {
		if(balance >= money) {
			try { Thread.sleep(1000);
			} catch (InterruptedException e) {}
			balance -= money;
		}
	}
} // Ŭ���� ��.

class RunnableEx13 implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300 ���� �� ���� ���Ƿ� �����ؼ� ��� (withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:" + acc.getBalance());
		}
	}
} // Ŭ���� ��.