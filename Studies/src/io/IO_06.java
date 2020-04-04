package io;

import java.io.*;

class IO_06 {
	public static void main(String[] args) {
		int[] score = { 100, 90, 95, 85, 50 };

		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("sample.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(100);
			dos.writeFloat(20f);
			dos.writeBoolean(true);
			// binary data(2진수)로 저장된다 --> 파일을 열어도 사람이 읽을 수 없다!
			//		>> eclipse에서 열었을 때는 int인지 float인지 boolean 값인지 모른다 --> 타입을 모르니까 2진수 원형 그대로 보여준다!
			//					<--> 반면, println은 모든 것을 문자로 취급하여 출력한다.
			// 		>> 16진수용 에디터에서 열면 제대로 읽을 수 있다 (16진수로 표현되겠지만)
			
			for(int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]);
			}
			
			dos.close();
		} catch(IOException e) { // Stream.close() may throw IOException
			e.printStackTrace();
		}
	}
}