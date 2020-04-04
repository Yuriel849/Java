package io;

import java.io.*;

class IO_05 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5); // Set buffer size as 5
			for(int i = '1'; i <= '9'; i++) { // Outputs int 1 ~ 9 to file "123.txt"
				bos.write(i);
			}
			bos.close(); // Shut BufferedOutputStream -> Calls flush before closing both streams
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}