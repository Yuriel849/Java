package main;

public class E04_TypeConversion {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		float f = 3.99f; // same as float f = (float) 3.99;
		System.out.println((int) f); // 반올림 없이 소수점 이하를 그냥 버린다

		int i = 3;
		char ch = (char) (i+'0'); // 숫자 3 --> 문자 '3'
		System.out.println(ch);
		
		i = '9' - '0'; // 문자 '9' --> 숫자 9
		System.out.println(i);
		
		String s = i + ""; // 숫자 9 --> 문자열 "9"
		System.out.println(i);
		
		i = Integer.parseInt("3"); // 문자열 "3" --> 숫자 3
		System.out.println(i);
		
		double d = (double) i; // 숫자 3 --> 실수 3.0
		System.out.println(d); // == System.out.println(d = 5.0); == System.out.println(5.0);
		
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b);
		// byte c = a + b; --> byte + byte --> int + int --> int를 byte에 대입 불가!!
		System.out.println(c);
		
		int h = 1_000_000; // 숫자에 언더스코어 아무데나 넣어도 문제 없음
		int e = 100_0_000; // 다만 숫자의 맨 앞에 언더스코어 넣을 수는 없음 (ex) _1000)

		long g = (long) h * e; // 어차피 A, B 둘 중 하나가 long으로 커지면 나머지 하나도 따라서 자동 형변환 한다
		System.out.println(g); // 오버플로우 발생
	}
}