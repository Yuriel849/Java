package study;

class Ex06_Test {
	public static void main(String[] args) {
		Child c = new Child();
			/* ������ ȣ�� ����
			 * 	>> Child() --> Child(int x) --> Parent() --> Parent(int x) --> Object()
			 */
		System.out.println("x="+c.getX(5));
			/* ��°���� "x=200"
			 * 	>> getX �޼���� x�� ��ȯ�� ��, x�� �������� ������� �ʾҴ�. �׷��� �Ҽ� Ŭ������ �ν��Ͻ� ���� x�� ��ȯ�Ѵ�.
			 * 	>> ���� Child Ŭ�������� �������̵������� ����� �޶����� ��.
			 */
	}
}

class Parent {
	int x=100;
	Parent() {
		this(200); // Parent(int x)�� ȣ��
		}
	Parent(int x) {
		this.x = x;
		}
	int getX(int a) {
		return x;
		}
	}

class Child extends Parent {
	int x = 3000;
	Child() {
		this(1000); // Child(int x)�� ȣ��
		}
	Child(int x) {
		this.x = x;
		}
	int getX(int a) {
		return x;
	}
}