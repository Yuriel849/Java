package study;

/* HEAP Memory
 * 	>> ���α׷� ���� �� �����Ǵ� �޸� ������ �����ϴ� ����
 * 	>> new �����ڿ� ���ؼ� �����ȴ�
 * 	1. ���� �����͸� �����ϴ� �޸� ����
 * 	2. �ڵ��ʱ�ȭ�� �����ȴ�
 * 	3. �ڵ������� �����ȴ� (via "garbage collector")
 */

/* �ҽ��ڵ带 �������ϸ� Ŭ���������� �ȴ�
 * 	>> �������ϸ鼭 main �޼ҵ�� main���� ����ϴ� �ٸ� Ŭ������ �ľ��Ѵ�
 * 	>> Ŭ���������� JVM���� �����ϸ� main & main�� ���� Ŭ������ �Բ� Method area �������� �ε��ȴ�
 * 	>> main�� �����ϴٰ� new�� ������ �ش� class�� Ȱ��ȭ��Ű�� class�� ��������� Heap �������� �ε��Ѵ�
 * 	>> (Ŭ������ Ȱ��ȭ��Ű�� ������ Ŭ������ �ε��� ����, �ٸ� �� ����)
 * 
 * Instance VS Object
 * 	>> new�� �̿��Ͽ� Ư�� Ŭ������ �� �� Ȱ��ȭ��Ű�� heap���� �ε��ϸ� �װ��� instance
 * 	>> new�� �̿��Ͽ� Ŭ������ Ȱ��ȭ���� Heap���� �ε��ϸ� �װ��� object (instance���� ������)
 * 		>> new�� �̿��Ͽ� �Ȱ��� Ŭ������ �ٽ� Ȱ��ȭ��Ű�� �ٸ� instance�� ���ܳ��� ��
 * 		>> ���� �̸��� ������� & ����޼ҵ带 ������
 * 		>> ��������� Heap ������ �ڽŸ��� ���� �޸� ������ ������ �Ӽ��� ���Ƶ� ���빰�� �ٸ���
 * 		>> ����޼ҵ�� instance �� �����ϸ� �Ȱ��� �����͸� ȣ���Ͽ� �Ȱ��� �����Ѵ�
 * 	ex)
 * 		Car c = new Car();
 * 		Car c2 = new Car();
 * 		c.start() == c2.start() --> �Ȱ��� �޼ҵ��
 * 		c.door != c2.door 		--> �̸��� ������, ���뵵 �ٸ��� �޸� ������ �ּҰ��� �ٸ��� 
 */

// main�� ��� Ŭ������ �տ� public�� �ʿ��ϴ�
public class Ex04_HeapMemory {
	public static void main(String[] args) {
		String str = new String("abc");
		
		/* Ŭ������ ��밡���� ���·� Ȱ��ȭ��Ų ���� �ٷ� ��ü
		 * 	>> Ȱ��ȭ��ų �� ��������� Heap�� �ε��ϰ� ����޼ҵ�� Method ������ �����ִ´�
		 * 		>> ��������� �� ��ü���� ���� �޶��� �� �ֱ� ������ ���� �޸� ���� Ȯ��
		 * 		>> ����޼ҵ�� �� ��ü���� �޶����� �ʰ� �Ȱ��� ������ ���� �޸� ������ �������� (Method ����)
		 * 			>> ����޼ҵ�� Heap�� ������, ���� Ŭ���� �Ҽ��̱⿡ ����޼ҵ带 �� �� �ְ� �����ϰ� �ִ�
		 */
		
		// Ŭ������ Heap�� �ε��Ͽ� Ȱ��ȭ��Ű�� --> ���� Car Ŭ������ ��� ����, �޼ҵ忡 ������ �� �ִ�
		Car c = new Car();
		/* Ŭ���� Ȱ��ȭ ��, �ּҰ��� �޴� ������ ������ �ڷ����� new �����ڿ� ���� �ڷ����ϰ� ��ġ�ؾ��Ѵ�!!!
		 * Bus car = new Car(); --> ����!!!
		 */
		
		c.start(); // Car Ŭ������ start �޼ҵ� ����
		c.start("����"); // start �޼ҵ� �� String �Ű������� �ִ� ���� ����
		System.out.println(c.color); // ���� Ŭ���� ������ ���� �������� �ʾҴٸ� ���⼭�� �ʱⰪ�� ���´�
		System.out.println(c.handle);
		System.out.println(c.door);
		c.color = "black";
		System.out.println(c.color);
		c.handle = 1;
		System.out.println(c.handle);

		c = null;
			/* c�� �����ϰ� �ִ� Ŭ���� Car�� ��ü�� �����
			 * Ŭ���� Car�� ��ü�� garbage collector SW�� ���� �����ȴ�
			 */
	}

}

// ������ Ŭ���� �����
class Car {
	String color; // ���� �������� �ʾҴ� --> String�� �ʱⰪ�� null
	int handle; // ���� �������� �ʾҴ� --> int�� �ʱⰪ�� 0
	int door = 4;
	
	public void start() {
		System.out.println("����մϴ�");
	}
	public void start(String str) {
		System.out.println(str + "�� ����մϴ�");
	}
	public void stop() {
		System.out.println("�����մϴ�");
	}
}
