package study;

import java.io.*;

// 15-26 ����

class Ex09_IO09 {
	public static void main(String[] args) {
//					   	��ȣ, ����, ����, ����
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
			} // ���������Ͱ� ������ �̵��� ���´� (�翬�� ���Ͽ� ����ϸ鼭 ���������ʹ� �� �ڿ� ��ġ�Ѵ�)
			
			raf.seek(0); // ���������͸� �� ó������ �̵���Ų�� --> ������ ���������Ͱ� �̹� ���� �ִ��ϱ� ��ٷ� EOF ���´�!
			while(true) {
				System.out.println(raf.readInt());
			}
		} catch(EOFException eof) {
			// readInt()�� ȣ�� ���� �� �� �̻� ���� ������ ������ EOFException �߻�!
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} // try-catch�� ��.
	} // main() ��.
} // Ŭ���� ��.