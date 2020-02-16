package point;

public class Point4D extends Point3D {
	int a;
	
	Point4D() {
		this(1,1,1,1);
	}
	
	/* super() 생성자 & super 참조변수
	 * 	>> 바로 위의 parent class 하나에 접근한다 (grandparent 이상에 접근하지 않는다)
	 * 	>> 여러 클래스가 상속으로 일렬로 이어져있다면, super & super() 썼을 때는 그 클래스 바로 위의 parent 하나에만 접근한다
	 */
	Point4D(int x, int y, int z, int a) {
		super(x,y,z);
		this.a = a;
	}
	
	// parent 타입 참조변수로 Point4D 인스턴스를 조작해도 메서드는 현재 인스턴스에서 오버라이딩한 메서드를 실행한다.
	public boolean equals(Object obj) {
		if (obj instanceof Point4D) {
			Point4D point = (Point4D) obj; // cast type Object --> Point --> Point3D --> Point4D
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