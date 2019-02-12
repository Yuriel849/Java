package point;

public class Ex04_Point4D extends Ex03_Point3D {
	int a;
	
	Ex04_Point4D() {
		this(1,1,1,1);
	}
	
	/* super() ������ & super ��������
	 * 	>> �ٷ� ���� parent class �ϳ��� �����Ѵ� (grandparent �̻� �������� �ʴ´�)
	 * 	>> ���� Ŭ������ ������� �Ϸķ� �̾����ִٸ�, super & super() ���� ���� �� Ŭ���� �ٷ� ���� parent �ϳ����� �����Ѵ�
	 */
	Ex04_Point4D(int x, int y, int z, int a) {
		super(x,y,z);
		this.a = a;
	}
	
	// System.out.println(p3.equals(p4)); --> true ���;� �Ѵ�.
	// Object�κ��� ��ӹ޾� Point���� �������̵� �ϰ� Point3D���� �������̵��� equals�� ���⼭ �ٽ� �������̵� �ϼ���.
		// parent Ÿ�� ���������� Point4D �ν��Ͻ��� �����ص� �޼���� ���� �ν��Ͻ����� �������̵��� �޼��带 �����Ѵ�.
	public boolean equals(Object obj) {
		// �� ���� x, y�� ���ؼ� ������ true.
		// �ƴϸ� false�� ��ȯ�Ͻÿ�.
		if (obj instanceof Ex04_Point4D) {
			Ex04_Point4D point = (Ex04_Point4D) obj; // parent Ÿ�Կ��� child�� child�� child Ÿ�� ���������� �ܹ��� ����ȯ
										   // Object --> Point --> Point3D --> Point4D ����ȯ
			if (this.x == point.x && this.y == point.y && this.z == point.z && this.a == point.a) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + ", a : " + a ;
	}
}
