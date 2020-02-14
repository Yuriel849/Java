package main;

public class Ex02_Variables {
	public static void main(String args[]) {
		float f; // float type variable

		f = 0.1f; // 접미사가 없으면 default type, double로 설정되기에 에러
		f = 0.1F;
		f = (float)10.1; // 접미사 붙이는 대신 강제형변환 시킨 것
		
		/* double d = 3.14f;
		 * 에러 없다!!!
		 * 	>> d는 double(8byte로 표현)로 float(4byte로 표현)인 3.14f보다 크다
		 * 	>> 작은 자료형의 데이터를 더 큰 자료형에 넣는 것은 자료손실 없이 변환되어 넣어지기에 문제없다!!!
		 */
		
		char ch = 'G';
		
		System.out.printf("ch : %c\n", ch);
		System.out.printf("ch : %c\n", ch + ('a' - 'A'));

		ch = 'f';
		
		System.out.printf("ch : %c\n", ch);
		System.out.printf("ch : %c\n", ch - ('a' - 'A'));
	}	
}