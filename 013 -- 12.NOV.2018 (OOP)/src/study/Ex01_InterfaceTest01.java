package study;

class Ex01_InterfaceTest01 {
	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B()); /* AŬ������ ��ü a�� methodA �޼��带 ȣ��, ���ڷδ� BŬ������ ��ü�� ���Ӱ� �����Ͽ� ����
							 * methodA������ �Ű������� BŬ������ ��ü�� �޾Ƽ� �� ��ü�� methodB �޼��� ȣ��
							 * 	>> �޼����� ������� AŬ���� ���忡���� methodB�� �����θ� ���� ȣ���ؼ� ����Ѵ�.
							 * 	>> ������ BŬ������ ������ �ٲ�� AŬ������ �۵����ϰ�, �׷��� AŬ������ ����ϴ� main()������ ��������.
							 * 		>> �������̽��� �����ϸ� �̷� ������ �ذ��� �� �ִ�.	
							 */
	}
}

class A {
	public void methodA(B b) {
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("methodB()");
	}
}