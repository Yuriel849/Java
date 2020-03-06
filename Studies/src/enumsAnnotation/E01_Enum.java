package enumsAnnotation;

// "Direction"이라는 타입의 객체는 4개의 값만을 가질 수 있다.
enum Direction { EAST, SOUTH, WEST, NORTH } // Values are 0, 1, 2, 3

class E01_Enum {
	public static void main(String[] args) {
		// Three different ways to get enums
		Direction d1 = Direction.EAST; // == new Direction("EAST") --> Cannot use constructor with enum
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		
		System.out.println("d1==d2 ? " + (d1==d2));
		System.out.println("d1==d3 ? " + (d1==d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3)); // Java uses typesafe enum
//		System.out.println("d2 > d3 ? " + (d2 > d3)); --> Error! --> Cannot use > & < with enum
		System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
		System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));
		
		switch(d1) {
			case EAST: // Direction.EAST라고 쓸 수 없다.
				System.out.println("The direction is EAST."); break;
			case SOUTH:
				System.out.println("The direction is SOUTH."); break;
			case WEST:
				System.out.println("The direction is WEST."); break;
			case NORTH:
				System.out.println("The direction is NORTH."); break;
			default:
				System.out.println("Invalid direction."); break;
		}

		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr) // for(Direction d : Direction.values())
			System.out.printf("%s=%d%n", d.name(), d.ordinal());
	}
}