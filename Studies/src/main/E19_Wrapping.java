package main;

class E19_Wrapping {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		int i = 10;
		
		// Casting primitive type to reference type (casting may be omitted) --> autoboxing
		Integer intg = (Integer) i; // Integer intg = Integer.valueOf(i);
		Object obj = (Object) i; // Object obj = (Object)Integer.valueOf(i);
		
		Long lng = 100L; // Long lng = new Long(100L);
		
		int i2 = intg + 10; // Primitive-reference operations possible
		long l = intg + lng; // Addition between reference types possible

		Integer intg2 = new Integer(20);
		int i3 = (int) intg2; // Casting reference type to primitive type (casting may be omitted)
		
		Integer intg3 = intg2 + i3;
		
		System.out.println("i          =" +i);
		System.out.println("intg       =" +intg);
		System.out.println("obj        =" +obj);
		System.out.println("lng        =" +lng);
		System.out.println("intg + 10  =" +i2);
		System.out.println("intg + lng =" +l);
		System.out.println("intg2      =" +intg2);
		System.out.println("i3         =" +i3);
		System.out.println("intg2 + i3 =" +intg3);
	}
}