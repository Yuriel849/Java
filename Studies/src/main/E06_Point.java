package main;

import pool.Point;
import pool.Point3D;
import pool.Point4D;

public class E06_Point {
	public static void main(String[] args) {
		Point p1 = new Point(); // (x,y) == (1,1)
		Point p2 = new Point(3, 5);
		System.out.println(p1);
		System.out.println(p2.toString());
		/* println(object) == println(object.toString()) --> println(Object obj) --> polymorphism
		 * 	>> toString 출력해도 똑같이 나오는 것이 println의 기능  --> 최고위 parent인 Object 타입 참조변수로 받은 후 toString 함수로 문자열로 만든 후 출력하는 것
		 */
		
		double d = Point.getDistance(p1, p2);
		double d2 = p2.getDistance(p2);
		System.out.println("점 p1 & p2 간 거리 : " + d);
		System.out.println("점 p2 & p2 간 거리 : " + d2);
		
		p1 = new Point(1,2);
		p2 = new Point(1,2);
		System.out.println(p1.equals(p2));
		
		Point3D p3 = new Point3D(1,2,5);
		Point3D p4 = new Point3D(1,2,5);
		System.out.println(p3);
		System.out.println(p3.equals(p4));
		
		Point4D p5 = new Point4D(1,2,5,8);
		Point4D p6 = new Point4D(1,2,5,8);
		System.out.println(p5);
		System.out.println(p5.equals(p6));
	}
}