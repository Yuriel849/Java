package io;

import java.io.*;

class IO_07 {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			
			while(true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			} // Infinite loop, but EOFException occurs after file has been read
		} catch(EOFException e) {
			System.out.println("Total score is " + sum + " points.");
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			try { // dis must be closed whether or not exception is thrown --> May change to try-with-resources to automatically close (Not much difference)
				if(dis != null) { dis.close(); }
			} catch(IOException ie) { // Stream.close() may throw IOException
				ie.printStackTrace();
			}
		} // try-catch
	}
}