package networking;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// 16-6 ���� --> Ex04_Networking 04�� ����ϱ� ���ؼ� (Ex03�� ����, Ex04�� Ŭ���̾�Ʈ)

public class Ex03_Networking03 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// ���������� �����Ͽ� 7777�� ��Ʈ�� ����(bind)�Ѵ�. --> Ŭ���̾�Ʈ�� �� ������ �����ϰ��� �ϴٸ� �� ������ ��Ʈ ��ȣ�� ����ؾ� �Ѵ�
			serverSocket = new ServerSocket(7777); // ��������!! --> ��û���� ���� (���� ��ſ��� �ƴϴ�!)
			System.out.println(getTime() + "������ �غ�Ǿ����ϴ�.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + "�����û�� ��ٸ��ϴ�.");
				// ���������� Ŭ���̾�Ʈ�� �����û�� �� ������ ������ ���߰� ��� ��ٸ���.
				// Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
				Socket socket = serverSocket.accept(); // ����!! --> ���� ����-Ŭ���̾�Ʈ ��ſ�
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�.");
				
				// ������ ��½�Ʈ���� ��´�.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				// ���� ����(remote socket)�� �����͸� ������.
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "�����͸� �����߽��ϴ�.");
				
				// ��Ʈ���� ������ �ݾ��ش�.
				dos.close();
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} // while�� ��.
	} // main() ��.
	
	// ����ð��� ���ڿ��� ��ȯ�ϴ� �޼���
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}

}
