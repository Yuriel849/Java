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

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
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
        int count = 0;

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals("+") || token.equals("-") || token.equals("*")
                    || token.equals("/") || token.equals("^") || token.equals("%")
                    || token.equals("sqrt") || token.equals("++") || token.equals("--")) {
                operators.push(token);
            } else if (token.equals("(")) {
                count++;
            } else if (token.equals(")")) {
                count--;
                result += operators.pop() + " ";
            } else if(token.matches("[+-]?\\d*(e[+-]?\\d+|\\.[0-9]+)?")) {
                result += Double.parseDouble(token) + " ";
            } else {
                System.out.printf("Illegal value detected : %s", token);
            }
        }

        if(count != 0) {
            System.out.printf("The number of parentheses is incorrect.");
            System.exit(1);
        }

        return result;
    }

    public Double evaluate() {
        StringTokenizer st = new StringTokenizer(expression);
        StackOfDoubles stack1 = new StackOfDoubles();

        while(st.hasMoreTokens()) {
            String s = st.nextToken();

            try {
                double d = Double.parseDouble(s);
                stack1.push(d);
            } catch(Exception e) {
                double d1 = stack1.pop();

                switch(s) {
                    case "+":
                        stack1.push(stack1.pop()+d1); break;
                    case "-":
                        stack1.push(stack1.pop()-d1); break;
                    case "/":
                        stack1.push(stack1.pop()/d1); break;
                    case "*":
                        stack1.push(stack1.pop()*d1); break;
                    case "^":
                        stack1.push(Math.pow(stack1.pop(),d1)); break;
                    case "sqrt":
                        stack1.push(Math.sqrt(d1)); break;
                    case "++":
                        stack1.push(d1+1); break;
                    case "--":
                        stack1.push(d1-1); break;
                }
            }
        }
        return stack1.pop();
    }
}