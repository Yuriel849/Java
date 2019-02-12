package generics;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	public String toString() {
		return "Fruit";
	}
} // Fruit Ŭ���� ��.

class Apple extends Fruit implements Eatable {
	public String toString() {
		return "Apple";
	}
} // Apple Ŭ���� ��.

class Grape extends Fruit {
	public String toString() {
		return "Grape";
	}
} // Grape Ŭ���� ��.

class Toy {
	public String toString() {
		return "Toy";
	}
} // Toy Ŭ���� ��.

class Ex02_GenericsTest {
	public static void main(String[] args) {
		// ArrayList<T> list = new ArrayList<T>(); --> 2���� T�� ���� Ŭ�������� ����� �Ѵ�.
		// ArrayList<Fruit> list = new ArrayList<Apple>(); --> T�� ���� Ŭ������ �� parent-child ���� ������!
		List<Apple> list = new ArrayList<Apple>(); // --> Ŭ���� �� parent-child ����� ���� ����.
		
		FruitBox<Apple> appleBox = new FruitBox<Apple>(); // Fruit������ Eatable �������̽��� �������� �ʾ�����, Apple���� ������������ ��� �����ϴ�.
//		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>(); // Fruit�� childŬ���������� Eatable �������̽��� �������� �ʾҴ�.
//		FruitBox<Toy> toyBox = new FruitBox<Toy>(); // <T> ��ġ�� �� �� �ִ� Ŭ������ Fruit�� childŬ�����̰� Eatable �������̽��� ������ Ŭ������ �� �� �ִ�.
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple()); // void add(Fruit item) --> Fruit Ŭ������ child�� Apple Ŭ���� �ν��Ͻ��� ���� �� �ִ�.
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
//		appleBox.add(new Toy()); --> ���� --> Box(Apple)���� Apple�� ���� �� ����.
		
		toyBox.add(new Toy());
//		toyBox.add(new Apple()); --> ���� --> Box(Toy)���� Apple�� ���� �� ����.
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
	} // main() ��.
} // Ŭ���� ��.

interface Eatable { } // �������̽��� �Ȱ��� extends ���
class FruitBox<T extends Fruit & Eatable> extends Box<T> { }

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
} // Box<T> ���׸� Ŭ���� ��.