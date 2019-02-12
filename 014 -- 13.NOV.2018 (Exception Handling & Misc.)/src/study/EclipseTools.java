package study;

// "source" tab --> "Generate hashCode() and equals()", "Generate toString" etc.
//						--> hashCode() & equals() ���� �ִ� ���� ���� ���ÿ� �������̵��ؾ� �Ѵٴ� �ǹ��̴�.

public class EclipseTools {
	int a;
	int b;
	int c;
	int d;
	
	// "source" --> "Generate toString()"
	@Override
	public String toString() {
		return "EclipseTools [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}

	// "source" --> "Generate constructor with fields"
	public EclipseTools(int a, int b, int c, int d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
}
