package point;

public class Ex02_PointTest {
	public static void main(String[] args) {
		Ex01_Point p1 = new Ex01_Point(); // (x,y) == (1,1)
		Ex01_Point p2 = new Ex01_Point(3, 5);
		System.out.println(p1); // Q1-3 ����
		System.out.println(p2.toString());
		/* println(��ü��) == println(��ü.toString())
		 * 	>> toString ����ص� �Ȱ��� ������ ���� println�� ���
		 * 	>> println�� signature --> println(Object o) --> ������!!!
		 * 		>> �ְ��� parent�� Object Ÿ�� ���������� ���� �� toString �Լ��� ���ڿ��� ���� �� ����ϴ� ��
		 */
		
		double d = Ex01_Point.getDistance(p1, p2);
		double d2 = p2.getDistance(p2);
		System.out.println("�� p1 & p2 �� �Ÿ� : " + d); // Q1-7 ����
		System.out.println("�� p2 & p2 �� �Ÿ� : " + d2); // Q1-6 ����
		/* static �޼���� �׻� Ŭ���������� ȣ�� (��ü�� ������� �� ��)
		 * 	>> ������ ������ ������, ���� �ʴ�
		 */
		
		p1 = new Ex01_Point(1,2);
		p2 = new Ex01_Point(1,2);
		System.out.println(p1.equals(p2));
		
		Ex03_Point3D p3 = new Ex03_Point3D(1,2,5);
		Ex03_Point3D p4 = new Ex03_Point3D(1,2,5);
		System.out.println(p3); // Q1-11 ����
		System.out.println(p3.equals(p4));
		
		Ex04_Point4D p5 = new Ex04_Point4D(1,2,5,8);
		Ex04_Point4D p6 = new Ex04_Point4D(1,2,5,8);
		System.out.println(p5); // Q1-11 ����
		System.out.println(p5.equals(p6));
	}

}
