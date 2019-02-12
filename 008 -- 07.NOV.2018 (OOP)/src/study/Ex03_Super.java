package study;

class Ex03_Super {
	public static void main(String[] args) {
		PointA p = new PointA();
		Point3D p3 = new Point3D(1,2,3);	
	}
}
	
	class PointA {
		int x;
		int y;
		
		PointA() {} // �⺻������
		
		PointA(int x, int y) { // ����� ���� ������
			this.x = x;
			this.y = y;
		}
	}
	
	class Point3D extends PointA {
		int z;
		
		Point3D(int x, int y, int z) {
//			this.x = x; // Point3D class�� ���� ��� �ʱ�ȭ --> ���� ��� �ʱ�ȭ�� ������ �ϴ� ���� �ùٸ���
//			this.y = y; // Point3D class�� ���� ��� �ʱ�ȭ --> �ڼտ��� ���� ��� �ʱ�ȭ�ϸ� �ڵ� �ߺ��� �߻�
			// super(); --> �⺻������ ȣ�� (���� PointA Ŭ������ �⺻�����ڰ� ������ ����)
			super(1, 1); // ���� �޼��� Point(int x, int y) ȣ�� --> ������ �� this(x,y)���� ȣ���ϴ� �Ͱ� ���
					 	 // �����ڰ� �����ڸ� ȣ���� ���� �׻� ȣ���ϴ� �������� ù �ٿ� ��ġ�ؾ�
			  			 // ���� ����ڰ� �ۼ����� �ʴ´ٸ�, �����Ϸ��� �ڵ����� super(); �߰��Ѵ� (������ ������ ȣ��)
			this.z = z;
		}
	}
