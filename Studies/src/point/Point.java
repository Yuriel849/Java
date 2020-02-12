package point;

public class Point {
	int x; // --> this.x --> instance variable, only exists when instance is created 
	int y;
	
	Point() {
		this(1, 1); // == Point(1,1) --> calls constructor Point(int, int)
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/* equals 호출하면서 parent의 참조변수를 이용했다.
	 * 	>> parent의 참조변수로는 parent에게는 없는 (child에게만 있는) 속성(변수)을 사용할 수 없다.
	 * 		>> Object형 참조변수 obj로는 Point 인스턴스의 x, y 멤버에 접근할 수 없다
	 * 			>> Object 클래스에는 x, y가 존재하지 않는다 (Object의 소스코드에 x, y가 없다)
	 * 		>> obj.x --> obj type의 소스코드로 가서 x라는 것을 실행하려고 시도 --> 없다!! --> 에러!!!
	 * 	>> child의 속성을 사용하기 위해서는 parent의 참조변수에서 child의 참조변수로 형변환해야 한다.
	 * 
	 * parent 타입으로 child 인스턴스 참조 --> 기능을 다 못쓸지언정 없는 기능을 사용하려하지 않는다. 문제없다.
	 * child 타입으로 parent 인스턴스 참조 --> 리모컨 역할인 child 타입에는 있지만
	 * 									인스턴스에는 없는 (parent에는 없는) 기능을 사용하려고 하는 에러!
	 *
	 * instanceof를 써야하는 이유
	 * 	>> equals 함수 입장에서는 obj가 어떤 클래스의 인스턴스인지 알 수가 없기 때문이다.
	 * 	>> 만약 obj가 Point와 아예 관련 없는 A라는 클래스라면? 완전히 이상한 것으로 형변환하면서 에러날 수 있다.
	 * 	>> 당연히 A 타입으로 형변환하면 Point 타입의 인스턴스를 사용할 수 없다.
	 */
	public boolean equals(Object obj) { // override equals() in Object class
		if (obj instanceof Point) { // first check if obj is Point type object before casting
			Point point = (Point) obj; // instanceof로 확인 후 parent형 --> child형 참조변수로 형변환
			return (this.x == point.x && this.y == point.y); // == if (this.x == point.x && this.y == point.y) { return true; }
		}
		return false;
	}
	
	public String toString() {
		return "x : " + x + ", y : " + y;
	}
	
	double getDistance(Point p) {
		return getDistance(p, this); // 같은 클래스 내 메서드니까 소속 클래스를 명시하지 않아도 찾아간다
		/* static double getDistance(Point p) -->> 에러!!!
		 * 	>> "this" 자체는 지역변수이지만 this는 인스턴스 자신을 가리키는 참조변수다
		 * 	>> 여기서 this는 메서드 호출할 때 사용한 객체 자신을 의미 --> 즉, 이 메서드는 객체를 생성해야만 사용 가능
		 * 	>> static 붙이면 클래스 메서드 --> iv 없어도 된다 --> 객체가 있을 때 & 없을 때 둘 다 사용가능해야 한다
		 * 	>> this는 객체가 없을 때는 (iv 없이는) 사용할 수 없다 --> this & static 메서드는 모순된다
		 * 		>> static method는 this 사용할 수 없다!!!
		 */
	}
	
	static double getDistance(Point p1, Point p2) {
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)); // local variables, not instance variables
	}
}