package study;

class Ex03_InterfaceTest03 {
	public static void main(String[] args) {
		A3 a = new A3();
		a.methodA(); // OR a.methodA(new B3());
	}
}

class A3 {
	void methodA() { // OR methodA(I3 i)
		I3 i = InstanceManager.getInstance(); // A Ŭ������ �Ű������� ǥ���ϴ� ��� ��3�� Ŭ������ ���� �޼��忡�� ���� �ñ��.
		i.methodB();
		System.out.println(i.toString()); // i�� ObjectŬ������ �޼��� ȣ�� ����
	}
}

interface I3 {
	public static int add() { return 1 + 2; } // �������̽��� static �޼��带 �־ ��������.
											  // �̹� ������ ���̱⿡ <�������̽���>.<static�޼����>�� �ٷ� ����� �� �ִ�.  
	public abstract void methodB();
}

class B3 implements I3 {
	public void methodB() { 
		System.out.println("methodB in B3 class");
		System.out.println(I3.add());
	}
	
	public String toString() { return "class B3"; }
}

class InstanceManager {
	public static I3 getInstance() {
		return new B3();
	}
}