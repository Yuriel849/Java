package io;

import java.io.*;
import java.util.Arrays;

// IO_01 upgrade --> Use array to increase efficiency

class IO_03 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // Smaller byte array than in IO_02
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));

		try {
			while(input.available() > 0) {
				input.read(temp); // == read(temp, 0, temp.length)
					// If there is still data to read from "input", reads and puts into "temp" as much data as "temp" can hold
					// Overwrites the previous data in "temp" --> If the new data from "input" does not completely fill "temp", part of the previous data in "temp" will remain
					// Returns the number of bytes read from "input"
				output.write(temp);
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
			}
		} catch(IOException e) {}
	}
		

	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp 	     : " + Arrays.toString(temp));
		System.out.println("Output Source: " + Arrays.toString(outSrc));
	}
}