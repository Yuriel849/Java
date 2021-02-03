package edu.hamburg.haw;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Class Tree.
 * Represents a binary tree.
 * @author Yuriel
 * @version 03.02.2021.
 */
public class Tree {
    /**
     * Inner class BiNode
     * Represents a single node for a binary tree.
     */
    public static class BiNode {
        public String term;
        public BiNode left;
        public BiNode right;

        public BiNode(String term) {
            this(term, null, null);
        }

        public BiNode(String term, BiNode left, BiNode right) {
            this.term = term;
            this.left = left;
            this.right = right;
        }
    }

    private BiNode root;
    private StringBuilder result = new StringBuilder("");

    /**
     * Constructor, instantiates Tree with the designated BiNode as the root node.
     * @param root The root of the tree to be constructed.
     */
    public Tree(BiNode root) { this.root = root; }

    /**
     * Constructor, instantiates a Tree by constructing a binary tree from the designated postfix expression String.
     * @param postfix The postfix expression to convert into a binary tree.
     */
    public Tree(String postfix)
    {
        this.root = construct(postfix);
    }

    /**
     * Checks whether a BiNode has a child.
     * @param node The BiNode to check.
     */
    private boolean hasChild(BiNode node) { return node.left != null || node.right != null; }

    /**
     * Traverses the tree in order, with the given node as the root.
     * A private method called recursively.
     */
    private void inorderTraversal(BiNode node) {
        if((isOperator(node.term) && !hasChild(node))
                || (!isOperator(node.term) && hasChild(node))
                || (isUnaryOperator(node.term) && (node.left != null))) {
            System.out.println("This tree is incorrect.\nTerminating program.");
            System.exit(2);
        }

        if(node.left != null) inorderTraversal(node.left);
        result.append(node.term).append(" ");
        if(node.right != null) inorderTraversal(node.right);
    }

    /**
     * Traverses this tree in order.
     * @return The String representation of inorder traversal of this tree.
     */
    public String inorderTraversal() {
        result.delete(0, result.length());
        inorderTraversal(root);
        return result.toString().stripTrailing();
    }

    /**
     * Traverses the tree in order, using the given BiNode as the root node,
     * and creates a fully parenthesized infix expression with the node values.
     * @param node The root node.
     */
    private void infixGenerator(BiNode node) {
        // Terminate tree traversal if this tree is incorrect.
        if((isOperator(node.term) && !hasChild(node))
                || (!isOperator(node.term) && hasChild(node))
                || (isUnaryOperator(node.term) && (node.left != null))) {
            System.out.println("This tree is incorrect.\nTerminating program.");
            System.exit(2);
        }

        if(hasChild(node)) result.append("( ");
        if(node.left != null) infixGenerator(node.left);
        result.append(node.term).append(" ");
        if(node.right != null) infixGenerator(node.right);
        if(hasChild(node)) result.append(") ");
    }

    /**
     * Traverses this tree in order and creates a fully parenthesized infix expression.
     * @return The String representation of the infix expression created from this tree.
     */
    public String infixGenerator() {
        result.delete(0, result.length());
        infixGenerator(root);
        return result.toString().stripTrailing();
    }

    /**
     * Constructs a binary tree from the designated postfix expression String.
     * @param postfix The postfix expression to convert into a binary tree.
     * @return The root node of the newly constructed Tree.
     */
    BiNode construct(String postfix) {
        Stack<BiNode> stack1 = new Stack<>();
        StringTokenizer st = new StringTokenizer(postfix);
        while(st.hasMoreTokens()) {
            String s = st.nextToken();

            if(isOperator(s)) {
                if(s.equals("sqrt") || s.equals("sin") || s.equals("cos") || s.equals("exp")) {
                    if(stack1.isEmpty()) {
                        System.out.println("No Operand to perform task");
                        System.exit(2);
                    } else {
                        BiNode right = stack1.pop();
                        stack1.push(new BiNode(s,null,right));
                    }
                } else {
                    if(stack1.size()<2) {
                        System.out.println("Not enough Operands to perform task");
                        System.exit(2);
                    } else {
                        BiNode right = stack1.pop();
                        BiNode left = stack1.pop();
                        stack1.push(new BiNode(s,left,right));
                    }
                }
            } else if(s.matches("[+-]?\\d*(e[+-]?\\d+|\\.[0-9]+)?")) {
                stack1.push(new BiNode(s));
            } else if(s.equals("pi")) {
                stack1.push(new BiNode("3.141592"));
            } else {
                System.out.printf("%s is not a valid expression.", postfix);
                System.exit(2);
            }
        }

        if(!stack1.isEmpty()) {
            return stack1.pop();
        }
        return null;
    }

    /**
     * Checks whether the designated String is an operator or not.
     * @param s The operator String.
     * @return True, if the parameter s is an operator; false, if s is not an operator.
     */
    private boolean isOperator(String s) {
        switch (s) {
            case "*":
            case "/":
            case "^":
            case "+":
            case "-":
            case "sqrt":
            case "sin":
            case "cos":
            case "exp":
                return true;
            default:
                return false;
        }
    }

    /**
     * Checks whether the designated String is a unary operator or not.
     * @param s The operator String.
     * @return True, if the parameter s is a unary operator; false, if s is not a unary operator.
     */
    private boolean isUnaryOperator(String s) {
        switch (s) {
            case "sqrt":
            case "sin":
            case "cos":
            case "exp":
                return true;
            default:
                return false;
        }
    }
}