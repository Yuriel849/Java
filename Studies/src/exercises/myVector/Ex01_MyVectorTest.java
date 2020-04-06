package exercises.myVector;

import java.util.Vector;

class Ex01_MyVectorTest {
	public static void main(String[] args) {
		Ex03_MyVectorMod2 v = new Ex03_MyVectorMod2(5);
		// �� �ȵȴٸ� Vector ��ü�� ����/�����Ͽ� ����, ���غ���
		Vector v4 = new Vector();
		
		System.out.println("Name of instance is \"v\".");
		System.out.println("Is v Empty? = " + v.isEmpty());
		
		v.add("4");
		v.add("3");
		v.add("0");
		v.add("1");
		v.add("3");
		v.add("2");

		System.out.println("\nv's size & capacity = " + v.size() + " & " + v.capacity());
		System.out.println("toString = " + v); // ��ü�� �ְ� ����Ʈ�ϴ� ���� v.toString()�� ����!!
		System.out.println("What's at index=5? = " + v.get(5));
		System.out.println("Where is 0? index=" + v.indexOf("0"));
		System.out.println("remove(\"2\") = " + v.remove("2"));
		System.out.println("remove(\"3\") = " + v.remove("3"));

		System.out.println("\nAfter removing \"2\" & \"3\"...");
		System.out.println("v's size & capacity = " + v.size() + " & " + v.capacity());
		System.out.println("toString = " + v);
		System.out.println("Is v Empty? = " + v.isEmpty());

	}
}
