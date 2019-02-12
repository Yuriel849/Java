package threads;

import java.util.ArrayList;

/* ����ȭ ���� �� ����
 * 	>> ������ ������ �ִ�!!
 *  	>> ����ȭ������ �� �����尡 ��ٸ��鼭 lock�� ��� �ֱ� ������, �ٸ� �����尡 �۵��� ���Ѵ�
 *  	>> ������ �� ������� lock�� ��� ��ٸ���, ������ ������� �� �� ������ ������ �ڱ�� �ϵ� ���� ���ϰ� ��ٸ���.
 *  		>> wait() & notify()�� �ذ�!
 */

class Customer2 implements Runnable {
	private Table2 table;
	private String food;
	
	Customer2(Table2 table, String food) {
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood()) {
				System.out.println(name + " ate a " + food);
			} else {
				System.out.println(name + " failed to eat. :(");
			}
		}
	}
	
	boolean eatFood() { return table.remove(food); }
} // Ŭ���� ��.

class Cook2 implements Runnable {
	private Table2 table;
	
	Cook2(Table2 table) {
		this.table = table;
	}
	
	public void run() {
		while(true) {
			// ������ �丮�� �ϳ� �����ؼ� table�� �߰��Ѵ�.
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
} // Ŭ���� ��.

class Table2 {
	String[] dishNames = { "donut", "donut", "burger" }; // donut�� �� ���� ���´�.
	final int MAX_FOOD = 6; // ���̺� ���� �� �ִ� �ִ� ������ ����
	
	private ArrayList<String> dishes = new ArrayList<> ();
	
	public synchronized void add(String dish) { // synchronized�� �߰�
		// ���̺� ������ ����á����, ���̺� ������ �߰����� �ʴ´�.
		if(dishes.size() >= MAX_FOOD	 ) { return; }
		dishes.add(dish);
		System.out.println("Dishes: " + dishes.toString());
	}
	
	public boolean remove(String dishName) {
		synchronized(this) {
			// ������ �丮�� ��ġ�ϴ� �丮�� ���̺��� �����Ѵ�.
			while(dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				try { Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
			
			for(int i = 0; i < dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		} // synchronized
		
		return false;
	}
	
	public int dishNum() { return dishNames.length; }
} // Ŭ���� ��.

class Ex15_Thread15 {
	public static void main(String[] args) throws Exception {
		Table2 table = new Table2(); // ���� �����尡 �����ϴ� ��ü
		
		new Thread(new Cook2(table), "COOK1").start();
		new Thread(new Customer2(table, "donut"), "CUST1").start();
		new Thread(new Customer2(table, "burger"), "CUST2").start();

		// 0.1�� (100 millis) �Ŀ� ���� �����Ѵ�.
		Thread.sleep(5000);
		System.exit(0);
	} // main() ��.
} // Ŭ���� ��.