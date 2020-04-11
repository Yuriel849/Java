package threads;

import java.util.ArrayList;

// E14_Thread14 --> E15_Thread15 --> E16_Thread16

/* 발전 순서
 * 	>> 동기화 했을 때
 * 	>> 동기화했으나 한 쓰레드가 기다리면서 lock을 쥐고 있기 때문에, 다른 쓰레드가 작동을 못한다
 * 		>> 끝없이 한 쓰레드는 lock을 쥐고 기다리며, 나머지 쓰레드는 그 한 쓰레드 때문에 자기들 일도 하지 못하고 기다린다.
 * 	>> wait() & notify()로 해결!
 * 	>> wait() & notify()로는 정확히 특정 대상에게 notify()하지 못한다
 * 	>> lock & condition으로 해결!
 * 		>> 재진입 --> wait로 lock 풀고 다시 활성화되는 것 --> 이렇게 다시 활성화된 것이 reentrant
 */

class E16_Thread {
	public static void main(String[] args) throws Exception {
		Table3 table = new Table3(); // Object shared by multiple threads
		
		new Thread(new Cook3(table), "COOK").start();
		new Thread(new Customer3(table, "donut"), "CUST1").start();
		new Thread(new Customer3(table, "burger"), "CUST2").start();

		// Terminate after 50 seconds (50000 milliseconds)
		Thread.sleep(50000);
		System.exit(0);
	}
}

class Table3 {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6; // Maximum number of dishes in table
	
	private ArrayList<String> dishes = new ArrayList<> ();
	
	public synchronized void add(String dish) { // synchronized method
		while(dishes.size() >= MAX_FOOD) { // Does not add dish to table, if table is full
			String name = Thread.currentThread().getName();
			System.out.println(name + " is waiting.");
			try {
				wait(); // COOK thread waits
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		dishes.add(dish);
		notify(); // Waiting CUST thread is notified 
		System.out.println("Dishes: " + dishes.toString());
	}
	
	public boolean remove(String dishName) { // Removes the designated dish from table
		synchronized(this) { // synchronized block
			String name = Thread.currentThread().getName();
			
			while(dishes.size() == 0) {
				System.out.println(name + " is waiting.");
				try {
					wait(); // CUST thread waits
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			
			while(true) {
				for(int i = 0; i < dishes.size(); i++) {
					if(dishName.equals(dishes.get(i))) {
						dishes.remove(i);
						notify(); // Waiting COOK thread is notified
						return true;
					}
				}
				
				try {
					System.out.println(name + " is waiting.");
					wait(); // CUST thread waits for desired dish
					Thread.sleep(500);
				} catch(InterruptedException e) {}
			}
		}
	}
	
	public int dishNum() { return dishNames.length; }
}

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
			int idx = (int)(Math.random() * table.dishNum()); // Cook randomly addes a dish to table
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
	}
}