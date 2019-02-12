package point;

public class Ex01_Point {
	int x; // --> this.x --> iv (�ν��Ͻ� ����)
	int y; // --> ��ü�� �����ؾ߸� �����Ѵ�
	
	Ex01_Point() {
		this(1, 1); // == Point(1,1) --> �Ʒ� Point(int x, int y) ������ ȣ��
					// �ڵ� �ߺ� ���Ϸ��� this() ���
	}
	
	Ex01_Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// System.out.println(p.equals(p2)); --> true ���;� �Ѵ�.
	// Object�κ��� ��ӹ��� equals�� �������̵� �ϼ���.
	public boolean equals(Object obj) {
		// �� ���� x, y�� ���ؼ� ������ true.
		// �ƴϸ� false�� ��ȯ�Ͻÿ�.
		if (obj instanceof Ex01_Point) { // ����ȯ�ϱ� ���� obj�� Point�� ��ü�� �±�� ���� ���� Ȯ���ؾ� �Ѵ�.
			Ex01_Point point = (Ex01_Point) obj; // instanceof�� Ȯ�� �� parent�� --> child�� ���������� ����ȯ
			return (this.x == point.x && this.y == point.y); // this�� x, y & point�� �����ϴ� x, y�� ������ ��
			}
//			if (this.x == point.x && this.y == point.y) {
//				return true;
		return false;
	}
			/* equals ȣ���ϸ鼭 parent�� ���������� �̿��ߴ�.
			 * 	>> parent�� ���������δ� parent���Դ� ���� (child���Ը� �ִ�) �Ӽ�(����)�� ����� �� ����.
			 * 		>> Object�� �������� obj�δ� Point �ν��Ͻ��� x, y ����� ������ �� ����
			 * 			>> Object Ŭ�������� x, y�� �������� �ʴ´� (Object�� �ҽ��ڵ忡 x, y�� ����)
			 * 		>> obj.x --> obj type�� �ҽ��ڵ�� ���� x��� ���� �����Ϸ��� �õ� --> ����!! --> ����!!!
			 * 	>> child�� �Ӽ��� ����ϱ� ���ؼ��� parent�� ������������ child�� ���������� ����ȯ�ؾ� �Ѵ�.
			 * 
			 * parent Ÿ������ child �ν��Ͻ� ���� --> ����� �� ���������� ���� ����� ����Ϸ����� �ʴ´�. ��������.
			 * child Ÿ������ parent �ν��Ͻ� ���� --> ������ ������ child Ÿ�Կ��� ������
			 * 									�ν��Ͻ����� ���� (parent���� ����) ����� ����Ϸ��� �ϴ� ����!
			 *
			 * instanceof�� ����ϴ� ����
			 * 	>> equals �Լ� ���忡���� obj�� � Ŭ������ �ν��Ͻ����� �� ���� ���� �����̴�.
			 * 	>> ���� obj�� Point�� �ƿ� ���� ���� A��� Ŭ�������? ������ �̻��� ������ ����ȯ�ϸ鼭 ������ �� �ִ�.
			 * 	>> �翬�� A Ÿ������ ����ȯ�ϸ� Point Ÿ���� �ν��Ͻ��� ����� �� ����.
			 */
	
	/* toString()�� �������̵��϶�
	 * 	>> ��� Ŭ�������� superclass�� Object class�� �ִ�
	 * 	>> Object�� toString() �޼��带 ���⼭ �������̵��϶�
	 * 	>> Object�� toString() �޼����� ������ ���⼭ ������
	 */
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
	
	// <��ü1>.getDistance(<��ü2>);�� ȣ�� --> ���� ���� <��ü2>��� �θ��� �ϳ��� ��ü �ȿ� ��� �μ�����
	double getDistance(Ex01_Point p) {
		/* static double getDistance(Point p) -->> ����!!!
		 * 	>> "this" ��ü�� �������������� this�� �ν��Ͻ� �ڽ��� ����Ű�� ����������
		 * 	>> ���⼭ this�� �޼��� ȣ���� �� ����� ��ü �ڽ��� �ǹ� --> ��, �� �޼���� ��ü�� �����ؾ߸� ��� ����
		 * 	>> static ���̸� Ŭ���� �޼��� --> iv ��� �ȴ� --> ��ü�� ���� �� & ���� �� �� �� ��밡���ؾ� �Ѵ�
		 * 	>> this�� ��ü�� ���� ���� (iv ���̴�) ����� �� ���� --> this & static �޼���� ����ȴ�
		 * 		>> static method�� this ����� �� ����!!!
		 * 		>> ���� "�ڹ��� ���� 3��" 297pg.�� ���
		 */
		return getDistance(p, this); // --> ������� Point.getDistance(p, this)��� Ŭ������ ����ؾ� �Ѵ�
									 // --> ������ ����� ���� Ŭ���� �� �޼���ϱ� �Ҽ� Ŭ������ ������� �ʾƵ� ã�ư���
		/* static method ����� instance method ����ؾ�
		 * 	>> static�� instance ȣ�� �Ұ��� --> static�� �׻� ���������� instance�� ȣ���ϴ� ������ �������� ���� ���� �ִ�
		 * 	>> instance�� static ȣ�� ���� --> instance�� �����ϴ� �����̸� static�� �ݵ�� �����Ѵ�
		 */		
//		int a = this.x - p.x;
//		int b = this.y - p.y;
//		return Math.sqrt(a*a + b*b); // --> ������ Math.sqrt�� double�� ��ȯ�ϱ⿡ ����ȯ���� �ʾƵ� �ȴ�
	}
	
	// Point p1, Point p2 --> �� �Լ��� ȣ���ϴ� �����κ��� ������ ������ �ּҰ��� ���� �޴� ��
	static double getDistance(Ex01_Point p1, Ex01_Point p2) {
//		double square = Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2);
//		double result = Math.sqrt(square); 
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
		// ���⼭ p2.x, p2.y ����� instance���� �ƴϴ� --> ����������
	}
}
