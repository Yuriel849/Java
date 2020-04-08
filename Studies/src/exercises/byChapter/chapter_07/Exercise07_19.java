package exercises.byChapter.chapter_07;

class Exercise07_19 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}
}

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // Product type array of size 3
	int idx = 0; // Index for the array "cart"
	
	void buy(Product p) {
		if(p.price > money) { // If the buyer doesn't have enough money...
			System.out.println("You only have " + money + " euros, you cannot afford this " + p + ".");
			return;
		}
		
		money -= p.price;
		
		add(p);
	} // buy()
	
	void add(Product p) {
		if(idx >= cart.length) { // If the cart is not large enough...
			Product[] temp = new Product[cart.length * 2];
			System.arraycopy(cart, 0, temp, 0, cart.length);
			cart = temp;
		}

		cart[idx++] = p;
	} // add()
	
	void summary() {
		String str = "Cart Summary : ";
		for(int i = 0; i < cart.length; i++) {
			if(i > 0) { str += ", "; }
			str += cart[i];
		}
		System.out.println(str);
		
		str = "Total price : ";
		int sum = 0;
		for(int i = 0; i < cart.length; i++) {
			sum += cart[i].price;
		}
		System.out.println(str + sum);
		
		System.out.println("Remaining money : " + money);
	} // summary()
} // Buyer class

class Product {
	int price;
	
	Product(int price) {
		this.price = price;
	}
} // Product class

class Tv extends Product {
	Tv() {
		super(100);
	}
	
	public String toString() {
		return "Tv";
	}
} // Tv class

class Computer extends Product {
	Computer() {
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
} // Computer class

class Audio extends Product {
	Audio() {
		super(50);
	}
	
	public String toString() {
		return "Audio";
	}
} // Audio class