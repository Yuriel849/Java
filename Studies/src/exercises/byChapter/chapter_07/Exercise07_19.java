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
	Product[] cart = new Product[3]; // ������ ��ǰ�� �����ϱ� ���� �迭
	int idx = 0; // Product �迭 card�� ���� index
	
	void buy(Product p) {
		// ���� ���� ������ ������ ���Ͽ� ���� ���� ������ �޼��带 �����Ѵ�.
		if(p.price > money) {
			System.out.println("�ܾ��� �����Ͽ� " + p + "�� �� �� �����ϴ�.");
			return;
		}
		
		// ���� ���� ����ϸ�, ��ǰ�� ������ ���� ������ ����.
		money -= p.price;
		
		// ��ٱ��Ͽ� ������ ������ ��´�. (add�޼��� ȣ��)
		add(p);
	} // buy() ��.
	
	void add(Product p) {
		// idx�� ���� ��ٱ����� ũ�⺸�� ���ų� ũ�� -->
		if(idx >= cart.length) {
				// ������ ��ٱ��Ϻ��� 2�� ū ���ο� �迭�� �����Ѵ�.
			Product[] temp = new Product[cart.length * 2];
				// ������ ��ٱ����� ������ ���ο� �迭�� �����Ѵ�.
			System.arraycopy(cart, 0, temp, 0, cart.length);
				// ���ο� ��ٱ��Ͽ� ������ ��ٱ��ϸ� �ٲ۴�.
			cart = temp;
		}

		// ������ ��ٱ���(cart)�� �����Ѵ�. �׸��� idx�� ���� 1 ������Ų��.
		cart[idx++] = p;
	} // add() ��.
	
	void summary() {
		// ��ٱ��Ͽ� ��� ���ǵ��� ����� ����� ����Ѵ�.
		String str = "������ ���� : ";
		for(int i = 0; i < cart.length; i++) {
			if(i > 0) { str += ", "; }
			str += cart[i];
		}
		System.out.println(str);
		
		// ��ٱ��Ͽ� ��� ���ǵ��� ������ ��� ���ؼ� ����Ѵ�.
		str = "����� �ݾ� : ";
		int sum = 0;
		for(int i = 0; i < cart.length; i++) {
			sum += cart[i].price;
		}
		System.out.println(str + sum);
		
		// ������ ��� ���� �ݾ�(money)�� ����Ѵ�.
		System.out.println("���� �ݾ� : " + money);
		
	} // summary() ��.
} // Buyer Ŭ���� ��.

class Product {
	int price; // ��ǰ�� ����
	
	Product(int price) {
		this.price = price;
	}
} // Product Ŭ���� ��.

class Tv extends Product {
	Tv() {
		super(100);
	}
	
	public String toString() {
		return "Tv";
	}
} // Tv Ŭ���� ��.

class Computer extends Product {
	Computer() {
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
} // Computer Ŭ���� ��.

class Audio extends Product {
	Audio() {
		super(50);
	}
	
	public String toString() {
		return "Audio";
	}
} // Audio Ŭ���� ��.