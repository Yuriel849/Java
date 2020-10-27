package edu.hamburg.haw;

/**
 * Main class of this lab-01 project. Contains the static main method.
 * @author Yuriel
 * @version 25.10.2020.
 */
public class Main {
    private static ArithmeticTerm term = new ArithmeticTerm("test");
    private static Double result = 0.0;
    // Test Strings
    private static String testString1 = "5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *";
    // FPAE convert() and evaluate() test cases.
    private static String evaluateTest1 = "( ( 4.3 * 1e-1 ) - ( ( ++ .4 ) + 5.5 ) )";
    private static String evaluateTest2 = "( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7 ) )";
    private static String evaluateTest3 = "( ( ( sqrt ( 5 * 72.401 ) ) + 8.1530 ) / ( -12.458 ^ +5 ) )";
    private static String evaluateTest4 = "( ( 5 % 3 ) * ( ( ( 0.5 ^ 30 ) - 9.2 ) / ( -.15 + ( sqrt 9 ) ) ) )";
    private static String evaluateTest5 = "( ( ( ( ( 10 + 2 ) - ( 8.1027 * 2.23234 ) ) / ( sqrt ( sqrt 35 ) ) ) % 15.2350 ) ^ 2 )";

    public static void main(String[] args) {
        // PROBLEM 1.2 : Test toString() & reverse() with test string 1.
//        term.setExpression(testString1);
//	      System.out.println(term.toString());
//	      term.reverse();
//        System.out.println(term.toString());
        // PROBLEM 1.2 : Test toString() & reverse() with test string 2.
//        term.setExpression(evaluateTest2);
//        System.out.println(term.toString());
//        term.reverse();
//        System.out.println(term.toString());

        main2();
    }

    /**
     * Problem 3.
     * Converts a Fully Parenthesized Arithmetic Expression (FPAE) into postfix notation, which is then evaluated.
     */
    public static void main2() {
        // Test Case 1
        term.setExpression(evaluateTest1);
        term.setExpression(term.convert());
        result = term.evaluate();
        System.out.printf("\n\"%s\" evaluates to \"%f\"", evaluateTest1, result);
        // Test Case 2
        term.setExpression(evaluateTest2);
        term.setExpression(term.convert());
        result = term.evaluate();
        System.out.printf("\n\"%s\" evaluates to \"%f\"", evaluateTest2, result);
        // Test Case 3
        term.setExpression(evaluateTest3);
        term.setExpression(term.convert());
        result = term.evaluate();
        System.out.printf("\n\"%s\" evaluates to \"%f\"", evaluateTest3, result);
        // Test Case 4
        term.setExpression(evaluateTest4);
        term.setExpression(term.convert());
        result = term.evaluate();
        System.out.printf("\n\"%s\" evaluates to \"%f\"", evaluateTest4, result);
        // Test Case 5
        term.setExpression(evaluateTest5);
        term.setExpression(term.convert());
        result = term.evaluate();
        System.out.printf("\n\"%s\" evaluates to \"%f\"", evaluateTest5, result);
    }
}