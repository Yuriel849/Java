package point;

public class Point3D extends Point {
	int z;
	
	Point3D() {
		this(1,1,1);
	}

	Point3D(int x, int y, int z) {
		super(x,y); // calls parent's constructor
		this.z = z;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point3D) {
			Point3D point = (Point3D) obj; // cast parent type to child type
			if (this.x == point.x && this.y == point.y && this.z == point.z) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + ", z : " + z;
	}
}