package threads;

import java.util.ArrayList;

// wait & notify 사용하기 --> Not always, but exception thrown because it is not synchronized

class E14_Thread {
	public static void main(String[] args) throws Exception {
		Table table = new Table(); // Object shared by multiple threads
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();

		// Terminate after 0.1 seconds (100 milliseconds)
		Thread.sleep(100);
		System.exit(0);
	}
}

class Customer implements Runnable {
	private Table table;
	private String food;
	
	Customer(Table table, String food) {
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

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {
		this.table = table;
	}
	
	public void run() {
		while(true) {
			int idx = (int)(Math.random() * table.dishNum()); // Cook randomly adds a dish to table
			table.add(table.dishNames[idx]);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
		}
	}
}

class Table {
	String[] dishNames = { "donut", "donut", "burger" };
	final int MAX_FOOD = 6; // Maximum number of dishes in table
	
	private ArrayList<String> dishes = new ArrayList<> ();
	
	public void add(String dish) {
		if(dishes.size() >= MAX_FOOD) { return; } // Does not add dish to table, if table is full
		dishes.add(dish);
		System.out.println("Dishes: " + dishes.toString());
	}
	
	public boolean remove(String dishName) { // Removes the designated dish from table
		for(int i = 0; i < dishes.size(); i++) {
			if(dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public int dishNum() { return dishNames.length; }
}