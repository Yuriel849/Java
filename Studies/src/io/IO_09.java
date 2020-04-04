package io;

import java.io.*;

class IO_09 {
	static int found = 0;

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("USAGE : java IO_09 DIRECTORY KEYWORD"); // Two arguments, DIRECTOR & KEYWORD
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		String keyword = args[1];
		
		if(!dir.exists() || !dir.isDirectory()) { // If dir does not exist or is not a directory
			System.out.println("This is not a valid directory.");
			System.exit(0);
		}
		
		try {
			findInFiles(dir, keyword);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Found '" + keyword + "' on " + found + " number of lines.");
	} // main()
	
	public static void findInFiles(File dir, String keyword) throws IOException {
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isDirectory()) {
				findInFiles(files[i], keyword); // Recursive for directories
			} else {
				String filename = files[i].getName();
				String extension = filename.substring(filename.lastIndexOf(".")+1);
				extension = "," + extension + ","; // Put commas before and after the the extension
				
				if(",java,txt,bak,".indexOf(extension) == -1) { // Continue if file extension is NOT java OR txt OR bak
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
				}
				
				br.close();
			}
		}
	} // findInFiles()
}