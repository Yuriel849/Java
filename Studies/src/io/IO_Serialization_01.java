package io;

import java.io.*;
import java.util.ArrayList;

import pool.UserInfo_Serialization;

class IO_Serialization_01 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			// UserInfo_Serialization MUST have implemented the java.io.Serializable interface 
			UserInfo_Serialization u1 = new UserInfo_Serialization("JavaMan", "1234", 30);
			UserInfo_Serialization u2 = new UserInfo_Serialization("C++ Man", "4321", 26);
			
			ArrayList<UserInfo_Serialization> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			// Serialize objects
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			out.close();
			System.out.println("Serialization successful.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}