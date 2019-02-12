package study;

import study.Ex11_Serialization01;
import java.io.*;
import java.util.ArrayList;

class Ex12_Serialization02 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			Ex11_Serialization01 u1 = new Ex11_Serialization01("JavaMan", "1234", 30); // u1�� Ÿ���� �ݵ�� "java.io.Serializable"�� ������ Ŭ�����̾�� �Ѵ�.
			Ex11_Serialization01 u2 = new Ex11_Serialization01("C++ Man", "4321", 26);
			
			ArrayList<Ex11_Serialization01> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			
			// ��ü�� ����ȭ�Ѵ�.
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			out.close();
			System.out.println("����ȭ�� ���������� �������ϴ�.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main() ��.
} // Ŭ���� ��.
