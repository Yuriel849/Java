package study;

import java.io.*;
import java.util.Arrays;

// Ex03_IO03 ���׷��̵� --> �迭�� �̿��ؼ� IO ȿ���� ���

class Ex04_IO04 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // ���� ������ �迭�� ũ�Ⱑ �ٸ���.
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		try {
			while(input.available() > 0) {
				int len = input.read(temp); // read() ��ȯ���� �� ���� �о����� int�� ���ڴ�!
				output.write(temp, 0, len); // ��Ȯ�� read()�� �о� �� ������ŭ�� write�Ѵ�.
			}
		} catch(IOException e) {}
		
		outSrc = output.toByteArray(); // ��Ʈ���� ������ byte �迭�� ��ȯ�Ѵ�.
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("temp 	     : " + Arrays.toString(temp));
		System.out.println("Output Source: " + Arrays.toString(outSrc));
	} // main() ��.
} // Ŭ���� ��.