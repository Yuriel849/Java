package io;

import java.io.*;
import java.util.ArrayList;

import pool.UserInfo_Serialization;

class IO_Serialization_02 {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream in = new ObjectInputStream(bis);
			
			// Order of deserialization must match order of serialization
			UserInfo_Serialization u1 = (UserInfo_Serialization) in.readObject();
			UserInfo_Serialization u2 = (UserInfo_Serialization) in.readObject();
			ArrayList list = (ArrayList) in.readObject();
			
			/* 출력할 때, u1 & u2를 list에 add()한 후에 list의 데이터를 출력했다.
			 * 	>> 즉, UserInfo.ser에 있는 3번째 데이터는 ArrayList에서 쓸 수 있는 단 하나의 데이터이다.
			 * 		>> 이 위치에 ArrayList가 아닌 것이 오면 에러난다 --> 3번째 데이터는 ArrayList로만 형변환 가능한 데이터라는 의미다.
			 * 	>> (recommendation!) 아예 개별적인 객체(i.e. u1 & u2)를 쓰지 않고 처음부터 모든 객체를 ArrayList같은 컬렉션에 담아서 직렬화하는 것이 좋다.
			 * 		>> 객체의 순서를 신경 쓸 필요 없이 컬렉션 하나만 직렬화 & 역직렬화하면 되기 때문이다.
			 */
	
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}