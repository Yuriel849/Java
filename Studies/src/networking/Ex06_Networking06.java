package networking;

import java.io.*;
import java.net.*;
import java.util.*;

// 16-14����

class Ex06_Networking06 {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java Ex06_Networking06 ��ȭ��");
			System.exit(0);
		}
		
		try {
			String serverIp = "10.10.10.194";
			// ������ �����Ͽ� ������ ��û�Ѵ�.
			Socket socket = new Socket(serverIp, 7777);
			System.out.println("������ ����Ǿ����ϴ�.");
			Thread sender = new Thread(new ClientSender(socket, args[0]));
			Thread receiver = new Thread(new ClientReceiver(socket));
			
			sender.start();
			receiver.start();
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(Exception e) {}
	} // main() ��.
	
	
	static class ClientSender extends Thread {
		Socket socket;
		DataOutputStream out;
		String name;
		
		ClientSender(Socket socket, String name) {
			this.socket = socket;
			try {
				out = new DataOutputStream(socket.getOutputStream());
				this.name = name;
			} catch(Exception e) {}
		}
		
		public void run() {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			try {
				if(out != null) {
					out.writeUTF(name);
				}
				
				while(out != null) {
					out.writeUTF("[" + name + "]" + scan.nextLine());
				}
			} catch(IOException e) {}
		} // run() ��.
	} // CLientSender ���� Ŭ���� ��.
	
	
	static class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		
		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch(IOException e) {}
		}
		
		public void run() {
			while(in != null) {
				try {
					System.out.println(in.readUTF());
				} catch(IOException e) {}
			}
		} // run() ��.
	} // ClientReceiver ���� Ŭ���� ��.
} // Ŭ���� ��.