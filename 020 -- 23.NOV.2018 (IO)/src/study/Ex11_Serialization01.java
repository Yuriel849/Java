package study;

// Ex07_Serialization02 * Ex08_Serialization03���� ����� UserInfo�� �ִ� Ŭ�����̴�.

@SuppressWarnings("serial")
class Ex11_Serialization01 implements java.io.Serializable {
	String name;
	transient String password; // "transient" �ٿ��⿡ "password"��� �̸��� ���� �� ���ڿ��� ����ȭ���� ���ܵȴ�!
	int age;				   // 	 >> ������ ������ȭ�ؼ� ����, "password"�� �� �ڸ��� �⺻�� "null"�̶�� ���ִ�!	
	
	public Ex11_Serialization01() {
		this("Unknown", "1111", 0);
	}
	
	public Ex11_Serialization01(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public String toString() {
		return "(" + name + "," + password + "," + age + ")";
	}
} // Ŭ���� ��.