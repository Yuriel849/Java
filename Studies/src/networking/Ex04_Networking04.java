package networking;

import java.io.*;
import java.net.*;

// 16-7 ����

class Ex04_Networking04 {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			
			System.out.println("������ �������Դϴ�. ����IP : " + serverIp);
			// ������ �����Ͽ� ������ ��û�մϴ�.
			Socket socket = new Socket(serverIp, 7777);
			
			// ������ �Է½�Ʈ���� ��´�.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			// �������κ��� ���� �����͸� ����Ѵ�.
			System.out.println("�����κ��� ���� �޼��� : " + dis.readUTF());
			System.out.println("������ �����մϴ�.");
			
			// ��Ʈ���� ������ �ݴ´�.
			dis.close();
			socket.close();
			System.out.println("������ ����Ǿ����ϴ�.");
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main() ��.
} // Ŭ���� ��.