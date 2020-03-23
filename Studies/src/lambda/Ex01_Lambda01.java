package lambda;

// Example of using a basic lambda expression 

class MyClass {
	// A method must always be inside a class
	int max(int a, int b) {
		return a > b ? a : b;
	}	
}

class Ex01_Lambda01 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		/* Lambda Expression
		 * 	<-> (1) Create a class (2) Create a method (3) Instantiate object (4) Run
		 */

		MyClass m = new MyClass();
		int result = m.max(3, 5);
		System.out.println(result);
		
		
		// Anonymous object instead of max method in class MyClass
		Object obj = new Object() {
			int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		
		// Lambda expression assigned to obj2 object
//		Object obj2 = (a,b) -> a > b ? a : b;
		
		/* Lambda Expression
		 * 메서드를 식으로 간단히 표현하기 위한 것 --> (목적) 간단히 표현한 후 메서드처럼 사용할 수 있어야 한다.
		 * 람다식은 이름이 없다 --> 부를 이름이 없으니 호출하기 어렵다 --> 메서드를 호출할 때는 이름이 필요하다 --> 그럼 람다식도 사용하려면 이름이 필요하다
		 * 람다식(익명객체)을 다룰려면? 참조변수가 필요 --> 람다식을 호출할 수 있는 이름(메서드명)이 필요 --> 함수형 인터페이스 사용 --> 하나의 추상 메서드만 있는데 여기에 람다식을 연결(람다식에 이름을 붙여준다)한다
		 * 함수형 인터페이스가 단 하나의 추상메서드만 가질 수 있는 이유는, 추상메서드가 2개 이상이면 어느 것과 람다식을 연결해줘야할지 알 수 없기 때문이다
		 * "@FunctionalInterface"에 의해 추상메서드가 한 개인지 2개 이상인지 확인된다 --> 한 개만 있는게 아니면 에러 난다.
		 */

		MyFunction f = (a,b) -> a > b ? a : b;
		
		result = f.max(3, 5);
		System.out.println(result);
	}
}

// Functional interface may only have one abstract method (default and static methods optional)
@FunctionalInterface
interface MyFunction {
	int max(int a, int b);
}