package generics;

import java.util.ArrayList;

class Ex04_GenericsTest {
	public static void main(String[] args) {
		FruitBox.<Apple>makeJuice(new FruitBox<Apple>()); // ��ü ���� ���� ���׸� �޼��� makeJuice ȣ��
			// �Ϲ������� ����Ÿ�� �տ� ��ġ�� <T>�� �Ű������� <T>�� ���� ������ ������ �� �ִ�.
		FruitBox.makeJuice(new FruitBox<Apple>());
		FruitBox.makeJuice(new FruitBox<Toy>()); // ���ϵ�ī�� ������� Fruit�� child Ÿ�Ը� �Էµ� �� �ִ� --> Toy ��� �Ұ�
	}

}

class Fruit { }
class Apple extends Fruit { }
class Grape extends Fruit { }
class Juice { }
class Toy { }

class FruitBox1<T> { // Ŭ������ <T>�� ��ü ���� ������ Ÿ���� �����ȴ�
	// ���׸� �޼��� --> <T>�� �޼��� �������� ����� �������� ���׸� ���
	static <T extends Fruit> Juice makeJuice(FruitBox<? extends Fruit> box) { // ToyŬ���� ���� ��ġ �ʴ� Ÿ���� ��ü�� �ԷµǴ� ���� ���� ���� ���ϵ�ī�� ���
		// ����Ÿ�� Juice �տ� ��ġ�� <T>�� Ŭ���� ������� <T>�� ���þ���! --> �ش� �޼����� ȣ�� ������ <T>�� Ÿ���� �����ȴ�
		return null;
	}
	
	// ���ϵ� ī�尡 ���� �޼��� --> ���� Ÿ���� ���׸��� �Է��� �������� ���׸� ���
	static Juice makeJuiceW(FruitBox<Fruit> box) {
		return null;
	}
	
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item) {
		list.add(item);
	}
	
	T get(int i) {
		return list.get(i);
	}
} // FruitBox<T> Ŭ���� ��.