package exercises.byChapter.chapter_09;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Pattern & Matcher.

class Exercise09_14 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
				"010-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		
		ArrayList<String> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println(">>");
			String input = scan.nextLine().trim();
			
			if(input.equals("")) {
				continue; // Continue while loop
			} else if(input.equalsIgnoreCase("Q")) {
				scan.close();
				System.exit(0);
			}

			Pattern p = Pattern.compile(".*" + input + ".*");
			for(int i = 0; i < phoneNumArr.length; i++) {
				String phone = phoneNumArr[i].replace("-", "");
				
				Matcher m = p.matcher(phone);
				if(m.matches()) {
					list.add(phoneNumArr[i]);
				}
			}
			
			if(list.size() > 0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("No matching phone numbers found.");
			}
		} // while loop
	} // main()
}