package study;

import study.Ex11_Serialization01;
import java.io.*;
import java.util.ArrayList;

class Ex13_Serialization03 {
	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName); 	// �̰� �ϳ��� ��� ��Ʈ��!
			BufferedInputStream bis = new BufferedInputStream(fis); // 	>> ������Ʈ�� 01
			ObjectInputStream in = new ObjectInputStream(bis); 		// 	>> ������Ʈ�� 02
			
			// ��ü�� ���� ���� ����� ������ ��ġ�ؾ��Ѵ�.
			Ex11_Serialization01 u1 = (Ex11_Serialization01) in.readObject();
			Ex11_Serialization01 u2 = (Ex11_Serialization01) in.readObject();
			ArrayList list = (ArrayList)in.readObject();
			
			/* ����� ��, u1 & u2�� list�� add()�� �Ŀ� list�� �����͸� ����ߴ�.
			 * 	>> ��, UserInfo.ser�� �ִ� 3��° �����ʹ� ArrayList���� �� �� �ִ� �� �ϳ��� �������̴�.
			 * 		>> �� ��ġ�� ArrayList�� �ƴ� ���� ���� �������� --> 3��° �����ʹ� ArrayList�θ� ����ȯ ������ �����Ͷ�� �ǹ̴�.
			 * 	>> (recommendation!) �ƿ� �������� ��ü(i.e. u1 & u2)�� ���� �ʰ� ó������ ��� ��ü�� ArrayList���� �÷��ǿ� ��Ƽ� ����ȭ�ϴ� ���� ����.
			 * 		>> ��ü�� ������ �Ű� �� �ʿ� ���� �÷��� �ϳ��� ����ȭ & ������ȭ�ϸ� �Ǳ� �����̴�.
			 */
	
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main() ��.
} // Ŭ���� ��.
