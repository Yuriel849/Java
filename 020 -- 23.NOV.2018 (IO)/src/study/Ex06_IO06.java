package study;

import java.io.*;
// 15-8 ����

class Ex06_IO06 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("sample.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(100);
			dos.writeFloat(20f);
			dos.writeBoolean(true);
			// binary data(2����)�� ����ȴ� --> ������ ��� ����� ���� �� ����!
			//		>> eclipse���� ������ ���� int���� float���� boolean ������ �𸥴� --> Ÿ���� �𸣴ϱ� 2���� ���� �״�� �����ش�!
			//					<--> �ݸ�, println�� ��� ���� ���ڷ� ����Ͽ� ����Ѵ�.
			// 		>> 16������ �����Ϳ��� ���� ����� ���� �� �ִ� (16������ ǥ���ǰ�����)
			
			dos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main() ��.
} // Ŭ���� ��.