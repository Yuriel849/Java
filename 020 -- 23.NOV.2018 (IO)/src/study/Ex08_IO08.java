package study;

import java.io.*;

// 15-12 ����

class Ex08_IO08 {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			
			while(true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			} // ���ѹݺ��ε�, ������ �� ������ EOF ���ܰ� �߻��ϸ鼭 while���� �����.
		} catch(EOFException e) {
			System.out.println("������ ������ " + sum + "�Դϴ�.");
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			try { // ���ܰ� �߻��ϴ� ���ϴ� �������� dis�� close�Ѵ�. --> �Ź� close�ϱⰡ �������ϱ� try-with-resources ��� (ū �ǹ̴� ����)
				if(dis != null) { dis.close(); }
			} catch(IOException ie) { // close()�� ���� IOException ���ܸ� �߻���ų �� �ִ�.
				ie.printStackTrace();
			}
		} // try-catch�� ��.
	} // main() ��.
} // Ŭ���� ��.