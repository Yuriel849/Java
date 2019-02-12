package study;

import java.io.*;
import java.util.Arrays;

// Ex01_IO01 ���׷��̵� --> �迭�� �̿��ؼ� IO ȿ���� ���

class Ex02_IO02 {
	public static void main(String[] args) {
		byte[] inSrc = { 0,1,2,3,4,5,6,7,8,9 };
		byte[] outSrc = null;
		
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		input.read(temp, 0, temp.length); // input�迭���� index�� 0���� temp�� ���̸�ŭ�� ������ temp�� ����
		output.write(temp, 5, 5); // temp �迭���� index�� 5���� 5�� ���� �����ͼ� output�� ����
				
		outSrc = output.toByteArray(); // ��Ʈ���� ������ byte �迭�� ��ȯ�Ѵ�.
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("temp 	     : " + Arrays.toString(temp));
		System.out.println("Output Source: " + Arrays.toString(outSrc));
	}
} // Ŭ���� ��.