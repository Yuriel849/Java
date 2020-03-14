package threads;

import java.util.ArrayList;

/* 동기화 했을 때 예제
 * 	>> 여전히 문제가 있다!!
 *  	>> 동기화했으나 한 쓰레드가 기다리면서 lock을 쥐고 있기 때문에, 다른 쓰레드가 작동을 못한다
 *  	>> 끝없이 한 쓰레드는 lock을 쥐고 기다리며, 나머지 쓰레드는 그 한 쓰레드 때문에 자기들 일도 하지 못하고 기다린다.
 *  		>> wait() & notify()로 해결!
 */

class Table2 {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6;
	
	private ArrayList<String> dishes = new ArrayList<> ();
	
	public synchronized void add(String dish) { // synchronized method
		if(dishes.size() >= MAX_FOOD	 ) { return; }
		dishes.add(dish);
		System.out.println("Dishes: " + dishes.toString());
	}
	
	public boolean remove(String dishName) {
		synchronized(this) { // synchronized block
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
		}
		
		return false;
	}
	
	public int dishNum() { return dishNames.length; }
}

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
}

class Cook2 implements Runnable {
	private Table2 table;
	
	Cook2(Table2 table) {
		this.table = table;
	}
	
	public void run() {
		while(true) {
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}

class E15_Thread15 {
	public static void main(String[] args) throws Exception {
		Table2 table = new Table2();
		
		new Thread(new Cook2(table), "COOK1").start();
		new Thread(new Customer2(table, "donut"), "CUST1").start();
		new Thread(new Customer2(table, "burger"), "CUST2").start();

		Thread.sleep(5000);
		System.exit(0);
	}
}