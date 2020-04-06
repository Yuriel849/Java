package exercises.myVector;

// ������ ���� ������ ������ test�ϴ� ���� �߿�!!!
class Ex02_MyVectorAnswerTest {
	public static void main(String[] args) {
		Ex02_MyVectorAnswer v = new Ex02_MyVectorAnswer(2);
		System.out.println(v.isEmpty());
		for(int i = 0; i < 10; i++) {
			v.add(i + ""); // ���ڿ� ���ڿ� ���ϸ� ����� ���ڿ�
			System.out.println(v + ":capacity=" + v.capacity());
		}
		System.out.println(v.size());
		v.clear();
		System.out.println(v + ":capacity=" + v.capacity());
		System.out.println(v.size());

	}
	
}
