package edu.hamburg.haw;

public class Main {

    public static void main(String[] args) {
        String testString1 = "5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *";
        String testString2 = "( 5.1 * ((( 9 + 8.88 ) ^ (( sqrt 4 ) / 6 )) - 7 ))";

        ArithmeticTerm term = new ArithmeticTerm(testString1);
	    System.out.println(term.toString());
	    term.reverse();
        System.out.println(term.toString());

        term = new ArithmeticTerm(testString2);
        System.out.println(term.toString());
        term.reverse();
        System.out.println(term.toString());
    }
}
