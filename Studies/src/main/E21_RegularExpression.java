package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class E21_RegularExpression {
	public static void main(String[] args) {
		String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.",
							"c0", "car", "combat", "count", "data", "disc"};
		
		Pattern p = Pattern.compile("c[a-z]*"); // All words in lowercase letters starting with "c"

		for(int i = 0; i < data.length; i++) {
			Matcher m = p.matcher(data[i]);
			if(m.matches()) { System.out.print(data[i] + ","); }
		}
	}
}