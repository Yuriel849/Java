package main;

/* Math class, function round()
 * 		returns the closest integer value, rounding up for .5
 * Math class, function rint()
 * 		returns the closest double value that is equal to a mathematical integer
 * 		if two double values that are integers are equally close, returns the even integer value 
 */

public class E18_Round_Rint {
	public static void main(String[] args) {
		double sum = 0;
		double sum1 = 0;
		double sum2 = 0;
		
		for(int i = 0; i < 10; i++) {
			double x = i + 0.5;
			sum += x;
			sum1 += Math.round(x);
			sum2 += Math.rint(x);
			System.out.printf("%3.1f\t %2d\t%3.1f %n", x, Math.round(x), Math.rint(x));
		}
		
		System.out.println("sum = " + sum);
		System.out.println("sum1 = " + sum1);
		System.out.println("sum2 = " + sum2);
	}
}