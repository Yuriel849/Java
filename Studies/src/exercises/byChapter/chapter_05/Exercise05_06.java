package exercises.byChapter.chapter_05;

/* For a given amount of money and a given range of denominations,
 * 	break down into the minimum number of bills 
 * 	that would be required to have that amount of money.
 */

class Exercise05_06 {
	public static void main(String[] args) {
		// Possible bill sizes: 500, 100, 50, 10
		int[] billUnit = { 500, 100, 50, 10 };
		
		int money = 2680;
		System.out.println("money = " + money);

		for(int i = 0; i < billUnit.length; i++) {
			int num = money / billUnit[i];
			System.out.println(billUnit[i] + "-euro : " + num);
			money %= billUnit[i];
		}
	}
}