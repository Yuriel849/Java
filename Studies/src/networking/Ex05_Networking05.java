package networking;

import java.io.*;
import java.net.*;
import java.util.*;

// 16-13 ���� --> Ex06_Networking06�� ����ϱ� ���ؼ�

class Ex05_Networking05 {
	@SuppressWarnings("rawtypes")
	HashMap clients;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Ex05_Networking05() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);
	}
	
	
	public static void main(String[] args) {
		new Ex05_Networking05().start();
	}
	
	
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("������ ���۵Ǿ����ϴ�.");
			
			while(true) {
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "���� �����Ͽ����ϴ�.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // start() ��.
	
	
	@SuppressWarnings("rawtypes")
	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream)clients.get(it.next());
				out.writeUTF(msg);
			} catch(Exception e) {}
		}
	} // sendToAll() ��.
	
	
	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch(IOException e) {}
		}
		
		@SuppressWarnings("unchecked")
		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "���� ���Խ��ϴ�.");
				
				clients.put(name, out);
				System.out.println("���� ���������� ���� " + clients.size() + "�Դϴ�.");
				
				while(in != null) {
					sendToAll(in.readUTF());
				}
			} catch(IOException e) {
				// ignore
			} finally {
				sendToAll("#" + name + "���� �������ϴ�.");
				clients.remove(name);
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "���� ������ �����Ͽ����ϴ�.");
				System.out.println("���� ���������� ���� " + clients.size() + "�Դϴ�.");
			} // try-catch-finally�� ��.
		} // run() ��.
	} // ServerReceiver ���� Ŭ���� ��.
} // Ŭ���� ��.