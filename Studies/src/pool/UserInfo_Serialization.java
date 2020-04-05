package pool;

// Class used by IO_Serialization_02 & IO_Serialization_03

// java.io.Serializable interface contains nothing but indicates this class is serializable
@SuppressWarnings("serial")
public class UserInfo_Serialization implements java.io.Serializable {
	String name;
	transient String password;
	int age;
	/* Password should not be exposed
	 * 	-> Excluded from serialization because of "transient" keyword
	 * 	-> Default value of "null" when deserialized
	 */
	
	public UserInfo_Serialization() {
		this("Unknown", "1111", 0);
	}
	
	public UserInfo_Serialization(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public String toString() {
		return "(" + name + "," + password + "," + age + ")";
	}
}