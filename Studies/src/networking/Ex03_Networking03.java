package networking;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// Server for Ex04_Networking

public class Ex03_Networking03 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + "Server started.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + "Waiting for connection request.");
				Socket socket = serverSocket.accept(); // serverSocket stops and waits for connection request
				System.out.println(getTime() + socket.getInetAddress() + " : requests connection.");
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "Message sent from server to client.");
				
				dos.close();
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		} // while loop (infinite)
	}
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}