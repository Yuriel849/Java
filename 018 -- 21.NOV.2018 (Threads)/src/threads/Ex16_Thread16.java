package threads;

import java.util.ArrayList;

// Ex14_Thread14 --> Ex15_Thread15 --> Ex16_Thread16

/* ���� ����
 * 	>> ����ȭ ���� ��
 * 	>> ����ȭ������ �� �����尡 ��ٸ��鼭 lock�� ��� �ֱ� ������, �ٸ� �����尡 �۵��� ���Ѵ�
 * 		>> ������ �� ������� lock�� ��� ��ٸ���, ������ ������� �� �� ������ ������ �ڱ�� �ϵ� ���� ���ϰ� ��ٸ���.
 * 	>> wait() & notify()�� �ذ�!
 * 	>> wait() & notify()�δ� ��Ȯ�� Ư�� ��󿡰� notify()���� ���Ѵ�
 * 	>> lock & condition���� �ذ�!
 * 		>> ������ --> wait�� lock Ǯ�� �ٽ� Ȱ��ȭ�Ǵ� �� --> �̷��� �ٽ� Ȱ��ȭ�� ���� reentrant
 */

class Customer3 implements Runnable {
	private Table3 table;
	private String food;
	
	Customer3(Table3 table, String food) {
		this.table = table;
		this.food = food;
	}

	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			table.remove(food);
			System.out.println(name + " ate a " + food);
		}
	}
}

class Cook3 implements Runnable {
	private Table3 table;
	
	Cook3(Table3 table) {
		this.table = table;
	}
	
	public void run() {
		while(true) {
			// ������ �丮�� �ϳ� �����ؼ� table�� �߰��Ѵ�.
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
	}
}

class Table3 {
	String[] dishNames = { "donut", "donut", "burger" }; // donut�� Ȯ���� �� ���� (�� ���� ���´�)
	final int MAX_FOOD = 6; // ���̺� ���� �� �ִ� �ִ� ������ ����
	
	private ArrayList<String> dishes = new ArrayList<> ();
	
	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");
			try {
				wait(); // COOK �����带 ��ٸ��� �Ѵ�.
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		dishes.add(dish);
		notify(); // ��ٸ��� �ִ� CUST�� �����.
		System.out.println("Dishes: " + dishes.toString());
	}
	
	public boolean remove(String dishName) {
		synchronized(this) {
			String name = Thread.currentThread().getName();
			
			while(dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				try {
					wait(); // CUST �����带 ��ٸ��� �Ѵ�.
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			
			while(true) {
				for(int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); // ���ڰ� �ִ� COOK�� ����� ����
						return true;
					}
				}
				
				try {
					System.out.println(name + "is waiting.");
					wait(); // ���ϴ� ������ ���� CUST �����带 ��ٸ��� �Ѵ�.
					Thread.sleep(500);
				} catch(InterruptedException e) {}
			}
		} // synchronized
	}
	
	public int dishNum() { return dishNames.length; }
}

class Ex16_Thread16 {
	public static void main(String[] args) throws Exception {
		Table3 table = new Table3(); // ���� �����尡 �����ϴ� ��ü
		
		new Thread(new Cook3(table), "COOK1").start();
		new Thread(new Customer3(table, "donut"), "CUST1").start();
		new Thread(new Customer3(table, "burger"), "CUST2").start();

		Thread.sleep(50000);
		System.exit(0);
	}
}