package main;

import pool.Time;

public class E05_AccessModifier {
	public static void main(String[] args) {
		Time t = new Time();
		// t.hour = 10;
			/* hour 변수를 private으로 바꾸면 "not visible" 에러난다
			 * 	>> not visible --> 보이지 않는다 --> private이기 때문에 "존재하지만 밖에서 안보인다" 의미
			 * 변수의 특징 --> scope & visibility
			 * 	>> scope --> 변수가 어디 코드부터 어디 코드까지 살아 있는가?
			 * 	>> visibility --> 살아 있는데 보이는가? 여기서 그것을 사용할 수 있는가?
			 */
		
		System.out.println(t.getHour());
		t.setHour(10);
		System.out.println(t.getHour());
	}
}