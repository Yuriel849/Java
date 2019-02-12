package study;

import java.io.*;
import java.util.Arrays;

class Ex05_IO05 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			// BufferedOutputStream�� ���� ũ�⸦ 5�� �Ѵ�.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			// ���� 123.txt�� 1���� 9���� ����Ѵ�.
			for(int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
			bos.close(); // ������Ʈ���� �ݾƾ� �Ѵ�! --> flush()�� ���� ȣ���Ͽ� ���ۿ� ���� ������ ����� �� ��ݽ�Ʈ���� close()�� ȣ���Ѵ�.
//			fos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main() ��.
} // Ŭ���� ��.