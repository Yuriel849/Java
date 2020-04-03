package io;

import java.io.*;
import java.util.Arrays;

// IO_01 upgrade --> Use array to increase efficiency

class IO_02 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		input.read(temp, 0, temp.length); // Writes temp.length number of elements to temp array, starting from index=0
		output.write(temp, 5, 5); // Outputs 5 elements from temp array, starting from index=5
				
		outSrc = output.toByteArray(); // Converts from stream to byte array
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("temp 	     : " + Arrays.toString(temp));
		System.out.println("Output Source: " + Arrays.toString(outSrc));
	}
}