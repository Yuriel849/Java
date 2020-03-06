package enumsAnnotation;

import java.util.Date;

class Parent {
	void method01() {
		System.out.println("Parent method()");
	}
}

class Child extends Parent {
	@Override // "@Override"를 메서드 앞에 붙이면 컴파일러에서 오버라이딩을 제대로 했는지 확인해준다
	@Deprecated // 메서드(method01())가 deprecated라고 알리는 목적
	void method01() {
		System.out.println("Child Method");
	}
}

class E02_Annotation {
	@SuppressWarnings("deprecation") // 경고 메세지 억지용
	public static void main(String[] args) {
		Child c = new Child();
		c.method01();
		Date d = new Date();
		d.getDate(); // Strikethrough and warning because Date.getDate() is deprecated
	}
}