package main;

import java.util.Calendar;
import java.util.Date;

public class E24_Date_Calendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // Create Calendar instance with current date and time
		Calendar cal2 = Calendar.getInstance();
		
		System.out.println("현재 날짜와 시간으로 Calendar 생성한 직후");
		System.out.println(cal);
		System.out.println(cal2);
		
		cal.clear(); // Delete current date and time data --> Can now set new date and time
		cal2.clear(); // If set() used without using clear(), different values are set
					  // 	--> Because time is recorded in nanoseconds
		
		System.out.println("clear()로 기존 설정 삭제 직후");
		System.out.println(cal); // After using clear(), all values are "?" or default values
		
		cal.set(2008, 10, 13); // Month 0 is January, Date is unchanged
		cal2.set(2008, 10, 13);
		
		System.out.println("set()으로 년,월,일 새롭게 설정 직후");
		// Because set() used after clear(), only the data set with set() is filled in
		System.out.println(cal);
		System.out.println(cal2);
		
		System.out.println();
		System.out.println(cal.equals(cal2));
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		// Convert to Date so data is printed in Date format, instead of printing all data in cal
		System.out.println(new Date(cal.getTimeInMillis()));
	}
}