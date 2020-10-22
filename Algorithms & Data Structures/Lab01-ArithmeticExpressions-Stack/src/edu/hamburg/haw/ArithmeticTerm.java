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
        StringTokenizer tokenizer = new StringTokenizer(expression, " ", false);

        while(tokenizer.hasMoreTokens()) {
            reverseStack.push(tokenizer.nextToken());
        }

        expression = "";
        while(!reverseStack.empty()) {
            expression += reverseStack.pop() + " ";
        }
    }
}
