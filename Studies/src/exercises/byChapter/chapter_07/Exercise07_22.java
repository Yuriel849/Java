package exercises.byChapter.chapter_07;

// ���� ���簢��, ���� ���ϱ⸦ ������ ShapeŬ������ �ۼ��϶�.

class Exercise07_22 {
	// �־��� �迭�� ��� �������� ���̸� ��� ���ؼ� ��ȯ�Ѵ�.
	static double sumArea(Shape[] arr) {
		double sum = 0;
		for(Shape s : arr) {
			sum += s.calcArea();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Rectangle(3,4), new Circle(1) };
		System.out.println("������ ��: " + sumArea(arr));
	}
}

abstract class Shape {
	Point p;
	
	Shape() {
		this(new Point(0,0));
	}
	
	Shape(Point p) {
		this.p = p;
	}
	
	// ������ ������ ����ؼ� ��ȯ�ϴ� �޼���
	abstract double calcArea();
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
} // �߻�Ŭ���� Shape ��.

class Point {
	int x;
	int y;
	
	Point() {
		this(0,0);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + x + "," + y + "]";
	}
} // Point Ŭ���� ��.

class Circle extends Shape {
	double r;
	
	Circle() {
		this(new Point(0,0), 1);
	}
	
	Circle(double x) {
		this(new Point(0,0), x);
	}
	
	Circle(Point p, double x) {
		super(p);
		this.r = x;
	}
	
	double calcArea() {
		return Math.PI * r * r;
	}
} // Circle Ŭ���� ��.

class Rectangle extends Shape {
	double width, height;
	
	Rectangle() {
		this(new Point(0,0), 1, 1);
	}
	
	Rectangle(double x, double y) {
		this(new Point(0,0), x, y);
	}
	
	Rectangle(Point p, double x, double y) {
		super(p);
		this.width = x;
		this.height = y;
	}
	
	double calcArea() {
		return width * height;
	}
	
	boolean isSquare() {
		return width == height && width*height != 0; // ���� �Ǵ� ���̰� 0�� �ƴϾ�� �Ѵ� (���̿� ���̸� ������ �� 0�� �ƴϾ�� �Ѵ�)
	}
} // Rectangle Ŭ���� ��.