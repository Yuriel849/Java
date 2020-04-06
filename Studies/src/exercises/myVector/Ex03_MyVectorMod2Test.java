package exercises.myVector;

import java.util.Vector;

class Ex03_MyVectorMod2Test {
	public static void main(String[] args) {
		Ex03_MyVectorMod2 v = new Ex03_MyVectorMod2(5);
		// �� �ȵȴٸ� Vector ��ü�� ����/�����Ͽ� ����, ���غ���
		Vector v4 = new Vector();
		
		System.out.println("Name of instance is \"v\".");
		System.out.println("Is v Empty? = " + v.isEmpty());

		System.out.println("Now adding 10 objects to v...");
		for(int i = 0; i < 10; i++) {
			v.add(i + ""); // �Է°��� ���ڿ� ���·� �Էµȴ�
		}

		System.out.println("\nv's size & capacity = " + v.size() + " & " + v.capacity());
		System.out.println("toString = " + v); // ��ü�� �ְ� ����Ʈ�ϴ� ���� v.toString()�� ����!!
		System.out.println("What's at index=5? = " + v.get(5));
		System.out.println("Where is 4? index=" + v.indexOf("4"));
		System.out.println("remove(\"2\") = " + v.remove("2"));
		System.out.println("remove(\"8\") = " + v.remove("8"));

		System.out.println("\nAfter removing \"2\" & \"8\"...");
		System.out.println("v's size & capacity = " + v.size() + " & " + v.capacity());
		System.out.println("toString = " + v);
		System.out.println("Is v Empty? = " + v.isEmpty());

	}
}
