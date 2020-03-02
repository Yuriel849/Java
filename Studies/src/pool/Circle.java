package pool;

public class Circle implements Cloneable {
	public Point p; // Point
	public double r; // Radius
	
	public Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}
	
	public Circle shallowCopy() {
		Object obj = null;
		
		try {
			obj = super.clone();
			// super.clone() --> return type is Object but actual return value is copy of the class that called super.clone()
		} catch (CloneNotSupportedException e) { }
		
		return (Circle) obj;
	}
	
	public Circle deepCopy() {
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) { }
		Circle c = (Circle) obj;
		c.p = new Point(this.p.getX(), this.p.getY()); // Creates a new Point instance for the clone
		
		return c;
	}
	
	public String toString() {
		return "[p=" + p + ", r=" + r + "]";
	}
}