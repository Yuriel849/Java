package edu.hamburg.haw;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * A class to contain an Arithmetic Expression and carry out operations on it.
 * A FPAE or an expression in postfix (Reverse Polish) notation can be converted and/or evaluated.
 * @author Yuriel
 * @version 08.11.2020.
 */
public class ArithmeticTerm {
    private String expression;

    /**
     * Constructor, instantiates ArithmeticTerm with the designated expression.
     * @param expression The expression of the new ArithmeticTerm object to be created.
     */
    public ArithmeticTerm(String expression) { this.expression = expression; }

    /**
     * Returns the expression as a string value.
     * Effectively a getter/accessor method.
     * @return The expression.
     */
    public String toString() {
        return expression;
    }

    /**
     * Sets a new expression.
     * @param expression The new expression to replace the old.
     */
    public void setExpression(String expression) { this.expression = expression; }

    /**
     * Tokenizes the expression and places it in reverse order.
     * The new reversed expression replaces the old expression.
     * For example, "4 * 10" becomes "10 * 4".
     */
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

    /**
     * Converts a FPAE into postfix notation.
     *
     * @return The FPAE in postfix notation.
     */
    public String convert() {
        Stack<String> operators = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(expression);
        String result = "";
        int parenthesesCount = 0;
        boolean parenthesisError = false, negative = false;
        int parenAtNeg = -10;

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if(token.matches("[+-]?\\d*(e[+-]?\\d+|\\.[0-9]+)?")
                    && !token.equals("++") && !token.equals("--")
                    && !token.equals("+") && !token.equals("-")) {
                parenthesesCount--;
                result += Double.parseDouble(token) + " ";
            } else {
                switch (token) {
                    case "pi":
                        parenthesesCount--;
                        result += "pi "; break;
                    // Unary operators
                    case "sqrt": case "++": case "--": case "sin": case "cos": case "exp":
                        parenthesesCount--;
                    // Binary operators
                    case "+": case "-": case "*": case "/": case "^": case "%":
                        // Negative sign ("-")
                        if(negative == true && token.equals("-") && tokenizer.nextToken().equals("(")) {
                            result += "-1 ";
                            operators.push("*");
                            parenAtNeg = parenthesesCount;
                            parenthesesCount += 3;
                        } else {
                            operators.push(token);
                            parenthesesCount--;
                        }
                        negative = false;
                        break;
                    case ")":
                        if(operators.empty()) { // Terminates if popping an empty stack.
                            System.out.printf("The number of parentheses in %s is incorrect.", expression);
                            System.exit(2);
                        } else if (parenAtNeg == parenthesesCount) {
                            result += operators.pop() + " ";
                            parenAtNeg = -10;
                        }
                        result += operators.pop() + " ";
                        negative = false;
                        if(parenthesesCount > 0)
                            parenthesesCount--;
                        break;
                    case "(":
                        negative = true;
                        parenthesesCount += 3;
                        break;
                    default:
                        System.out.printf("Illegal value detected : %s", token);
                }
            }
        }
        
        if(!operators.empty()) { // Terminates if operators are still on the stack after processing an expression.
            System.out.printf("%s is not a valid FPAE.", expression);
            System.exit(2);
        } else if (parenthesesCount != 0) { // Terminates if the format inside a pair of parentheses is incorrect.
            System.out.printf("The format inside the parentheses in %s is incorrect.", expression);
            System.exit(2);
        }

        return result;
    }

    /**
     * Evaluates a postfix expression into the result.
     * @return The Double value of the result.
     */
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