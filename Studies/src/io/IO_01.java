package io;

import java.io.*;
import java.util.Arrays;

class IO_01 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		// ByteArrayInput/OutputStream -> Used to read from and write to byte arrays (for accessing memory)
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
		while((data = input.read()) != -1) { // If input.read returns -1, means there is nothing more to read
			output.write(data);
		}
		
		outSrc = output.toByteArray(); // Converts the contents of the stream to a byte array
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source: " + Arrays.toString(outSrc));
	}
}