package study;

import java.io.*;
import java.util.Arrays;

// Ex01_IO01 ���׷��̵� --> �迭�� �̿��ؼ� IO ȿ���� ���

class Ex03_IO03 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[4]; // ���� ������ �迭�� ũ�Ⱑ �ٸ���.
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));

		try {
			while(input.available() > 0) {
				input.read(temp); // read() --> input���κ��� �о�� ������ �迭 temp�� ��´�.
					// read(byte[] b, 0, b.length)�� ���� --> input���� �����ͼ� b�� �� �� �ִ¸�ŭ �� ä��� (input���� �о�� ���� ���Ҵٴ� ���� ��)
					// ������ temp �迭�� �ִ� ������ ����� --> ���� temp�� ��� ĭ�� ������ ����� �ʴ´ٸ�, ���� ���뵵 ���� ���´�.
					// read() ��ȯ���� �� ���� �о����� int�� ���ڴ�!
				output.write(temp); // write() --> �迭 temp�� ��� ��� ������ ����Ѵ�.
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
			}
		} catch(IOException e) {}
	} // main() ��.
		

	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp 	     : " + Arrays.toString(temp));
		System.out.println("Output Source: " + Arrays.toString(outSrc));

	} // printArrays() ��.
} // Ŭ���� ��.