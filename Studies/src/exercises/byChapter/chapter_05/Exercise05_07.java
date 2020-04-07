package exercises.byChapter.chapter_05;

// Take the amount of money as user input from the command console

class Exercise05_07 {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java Exercise05_7 3120");
			System.exit(0);
		}
		
		int money = Integer.parseInt(args[0]);
		
		System.out.println("money = " + money);
		
		int[] billUnit = { 500, 100, 50, 10 };
		int[] bills    = {  5,   5,  5,  5 };
		
		for(int i = 0; i < billUnit.length; i++) {
			int billNum = 0;
			billNum = money / billUnit[i];

			if(billNum > bills[i]) {
				billNum = bills[i];
				bills[i] = 0;
			} else {
				bills[i] -= billNum;
			}

			money -= billNum * billUnit[i];
		} // for loop
		
		if(money > 0) {
			System.out.println("Insufficient number of bills for this amount.");
			System.exit(0);
		}
		
		System.out.println(" = REMAINING BILLS = ");
		
		for(int i = 0; i < billUnit.length; i++) {
			System.out.println(billUnit[i] + "-euro : " + bills[i]);
		}
	}
}