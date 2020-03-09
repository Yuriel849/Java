package generics;

import pool.Fruit;
import pool.FruitBox;

class E05_WildCardTest {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		System.out.println(Juicer.makeJuice(fruitBox));
		System.out.println(Juicer.makeJuice(appleBox));
	} // main() 끝.
} // 클래스 끝.

class Juice {
	String name;
	
	Juice(String name) {
		this.name = name + "Juice";
	}
	
	public String toString() {
		return name;
	}
} // Juice 클래스 끝.

class Juicer {
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp = "";
		
		for(Fruit f: box.getList())
			{ tmp += f + " "; }
		return new Juice(tmp);	
	}
} // Juicer 클래스 끝.