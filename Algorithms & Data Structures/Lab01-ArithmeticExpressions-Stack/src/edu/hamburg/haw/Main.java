package edu.hamburg.haw;

public class Main {
    private static ArithmeticTerm term;
    // Test Strings
    private static String testString1 = "5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *";
    private static String evaluateTest1 = "( ( 4.3 * 1e-1 ) - ( ( ++ .4 ) + 5.5 ) )";
    private static String evaluateTest2 = "( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7 ) )";
    private static String evaluateTest3 = "( ( ( sqrt ( 5 * 72.401 ) ) + 8.1530 ) / ( -12.458 ^ +5 ) )";
    private static String evaluateTest4 = "( ( 5 % 3 ) * ( ( ( 0.5 ^ 30 ) - 9.2 ) / ( -.15 + ( sqrt 9 ) ) ) )";
    private static String evaluateTest5 = "( ( ( ( ( 10 + 2 ) - ( 8.1027 * 2.23234 ) ) / ( sqrt ( sqrt 35 ) ) ) % 15.2350 ) ^ 2 )";

    public static void main(String[] args) {
        // PROBLEM 1.2 : Test toString() & reverse() with test string 1.
//        term = new ArithmeticTerm(testString1);
//	      System.out.println(term.toString());
//	      term.reverse();
//        System.out.println(term.toString());
        // PROBLEM 1.2 : Test toString() & reverse() with test string 2.
//        term = new ArithmeticTerm(evaluateTest2);
//        System.out.println(term.toString());
//        term.reverse();
//        System.out.println(term.toString());

        // PROBLEM 3.1 : Test evaluate() with 5 test cases.
//        term = new ArithmeticTerm(evaluateTest1);
//        System.out.println(term.convert());
//        term = new ArithmeticTerm(evaluateTest2);
//        System.out.println(term.convert());
//        term = new ArithmeticTerm(evaluateTest3);
//        System.out.println(term.convert());
//        term = new ArithmeticTerm(evaluateTest4);
//        System.out.println(term.convert());
//        term = new ArithmeticTerm(evaluateTest5);
//        System.out.println(term.convert());

        main2();
    }

    public static void main2() {
        term = new ArithmeticTerm(evaluateTest5);
        term.setExpression(term.convert());
        Double result = term.evaluate();
        System.out.printf("\n\"%s\" evalutes to \"%f\"\n", evaluateTest5, result);
    }
}