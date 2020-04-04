package io;

import java.io.*;

// 15-26 예제

class IO_08 {
	public static void main(String[] args) {
//					   	번호, 국어, 영어, 수학
		int[] score = {  1, 100,  90,  90,
						 2,  70,  90, 100,
						 3, 100, 100, 100,
						 4,  70,  60,  80,
						 5,  70,  90, 100
		};
		
		try {
			@SuppressWarnings("resource")
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
			for(int i = 0; i < score.length; i++) {
				raf.writeInt(score[i]);
			} // File pointer is at the end of the file
			
			raf.seek(0); // Moves file pointer to the start of the file
			while(true) {
				System.out.println(raf.readInt());
			}
		} catch(EOFException eof) { // Thrown if there is nothing more to read
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} // try-catch
	}
}