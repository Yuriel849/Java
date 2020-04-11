package networking;

import java.io.*;
import java.net.*;

// Client for Ex03_Networking

class Ex04_Networking04 {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			
			System.out.println("Connecting to server at " + serverIp);

			Socket socket = new Socket(serverIp, 7777);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("Message received from server\n >> " + dis.readUTF());
			System.out.println("Terminating client.");
			
			dis.close();
			socket.close();
			System.out.println("Client terminated.");
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}