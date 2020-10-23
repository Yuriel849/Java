package edu.hamburg.haw;

import java.util.Stack;
import java.util.StringTokenizer;

public class ArithmeticTerm {
    private String expression;

    public ArithmeticTerm(String expression) {
        this.expression = expression;
    }

    public String toString() {
        return expression;
    }

    public void reverse() {
        Stack<String> reverseStack = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);

        while(tokenizer.hasMoreTokens()) {
            reverseStack.push(tokenizer.nextToken());
        }

        expression = "";
        while(!reverseStack.empty()) {
            expression += reverseStack.pop() + " ";
        }
    }

    public String convert() {
        Stack<String> operators = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);
        String result = "";
        int parenthesesCount = 0; // Counts the number of opening parentheses, reduced for each closing parenthesis.
        int count = 0; // Counts number of operands & operators after each opening parenthesis.

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals("+") || token.equals("-") || token.equals("*")
                    || token.equals("/") || token.equals("^") || token.equals("%")
                    || token.equals("sqrt")) {
                operators.push(token);
            } else if (token.equals("(")) {
                parenthesesCount++;
            } else if (token.equals(")")) {
                parenthesesCount--;
                result += operators.pop() + " ";
            } else if(token.matches("[+-]?\\d*(e[+-]?\\d+|\\.[0-9]+)?")) {
                result += Double.parseDouble(token) + " ";
                count++;
            } else {
                System.out.printf("Illegal value detected : %s", token);
            }
        }

        if(parenthesesCount != 0) {
            System.out.printf("The number of parentheses is incorrect.");
            System.exit(1);
        }

        return result;
    }
}
