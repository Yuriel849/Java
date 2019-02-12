package study;

import java.io.*;

// 15-33 ����

class Ex10_IO10 {
	static int found = 0;

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("USAGE : java Ex05_DataStream DIRECTORY KEYWORD");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		String keyword = args[1];
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("��ȿ���� ���� ���丮�Դϴ�.");
			System.exit(0);
		}
		
		try {
			findInFiles(dir, keyword);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("�� " + found + "���� ���ο��� '" + keyword + "'��/�� �߰��Ͽ����ϴ�.");
	} // main() ��.
	
	public static void findInFiles(File dir, String keyword) throws IOException {
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				findInFiles(files[i], keyword);
			} else {
				String filename = files[i].getName();
				String extension = filename.substring(filename.lastIndexOf(".")+1);
				extension = "," + extension + ","; // �յڿ� ��ǥ�� ���� ������ �����ڸ� ��Ȯ���ϱ� ���� ��. 
				
				if(",java,txt,bak,".indexOf(extension) == -1) { // file extension�� java OR txt OR bak�� �ƴ� ��� continue.
					continue;
				}
				
				filename = dir.getAbsolutePath() + File.separator + filename;
				
				FileReader fr = new FileReader(files[i]);
				BufferedReader br = new BufferedReader(fr);
				
				String data = "";
				int lineNum = 0;
				
				while((data = br.readLine()) != null) {
					lineNum++;
					if(data.indexOf(keyword) != -1) {
						found++;
						System.out.println("[" + filename + "(" + lineNum + ")" + "]" + data);
					}
				} // while�� ��.
				
				br.close();
			}
		} // for�� ��.
	} // findInFiles() ��.
} // Ŭ���� ��.