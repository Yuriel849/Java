package study;

public class Ex02_DrawShape {
	public static void main(String[] args) {
		/* 15��° �ٰ� ���� ����
		 * Point p1 = new Point(1,1);
		 * Point p2 = new Point(2,2);
		 * Point p3 = new Point(3,3);
		 * 
		 * Point[] pArr = new Point[3]; --> ��ü �迭 --> �������� �迭 --> ���� ���������� �ϳ��� ������� ��
		 * pArr[0] = p1;
		 * pArr[1] = p2;
		 * pArr[2] = p3;
		 */	
		Point[] p = { new Point(100,100),
				new Point(140, 50),
				new Point(200,100) };
		
		Triangle t = new Triangle(p);
		
		/* 25��° �ٰ� ���� ���� 
		 * Point p = new Point(150,150);
		 * Circle c = new Circle(p,50);
		 */
		Circle c = new Circle(new Point(150,150), 50);
		
		t.draw(); // �ﰢ���� �׸���.
		c.draw(); // ���� �׸���.
	}
}

class Shape {
	String color = "black";
	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
}

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	Point() {
		this(0,0);
	}
	
	String getXY() {
		return "(" + x + "," + y + ")"; // x & y�� ���� ���ڿ��� ��ȯ
	}
}

class Circle extends Shape {
	Point center; // ���� ������ǥ
	int r; // ������
	
	Circle() {
		this(new Point(0,0), 100); // Circle(Point center, int r)�� ȣ��
	}
	
	Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	void draw() { // ���� �׸��� ��ſ� ���� ������ ����ϵ��� �Ѵ�.
		System.out.printf("[center=(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, color);
	}
}

class Triangle extends Shape {
	Point[] p = new Point[3];
	
	Triangle(Point[] p) {
		this.p = p;
	}
	
	void draw() {
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s}%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
	}
}
