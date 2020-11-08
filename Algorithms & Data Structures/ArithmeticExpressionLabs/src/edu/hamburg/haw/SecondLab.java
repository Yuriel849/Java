package edu.hamburg.haw;

/**
 * Main class of the second lab session. Contains the static main method.
 * The main methods and related codes for the first lab session can be found in FirstLab.java.
 *
 * @author Yuriel
 * @version 08.11.2020.
 */
public class SecondLab {
    private static ArithmeticTerm term = new ArithmeticTerm("test");
    private static Double result = 0.0;

    public static void main(String[] args) {
        term.setExpression("( ( ( sin ( ( 4 * pi ) / 3 ) ) * ( exp ( - ( ( sqrt 2 ) - 1 ) / 8 ) ) ) / ( sqrt ( 6 * pi ) ) )");
        System.out.println(term.convert());

        // Problem 5 Task 2 - Construct a tree with the expression "( ( ( sqrt 4 ) * ( 2 ^ 3 ) ) / 2 )".
        Tree.BiNode four = new Tree.BiNode("4");
        Tree.BiNode sqrt = new Tree.BiNode("sqrt", null, four);
        Tree.BiNode twoFirst = new Tree.BiNode("2");
        Tree.BiNode three = new Tree.BiNode("3");
        Tree.BiNode pow = new Tree.BiNode("^", twoFirst, three);
        Tree.BiNode mult = new Tree.BiNode("*", sqrt, pow);
        Tree.BiNode twoSecond = new Tree.BiNode("2");
        Tree.BiNode div = new Tree.BiNode("/", mult, twoSecond);

        Tree tree = new Tree(div);
        // Problem 5 Task 3 - Call inorderTraversal() on tree from Task 2.
        System.out.println("Inorder Traversal : " + tree.inorderTraversal());
        // Problem 5 Task 4 - Call infixGenerator() on tree from Task 2. Check by converting to postfix and evaluating.
        String result = tree.infixGenerator();
        System.out.println("Parenthesized Infix Expression : "+ result);
        term.setExpression(result);
        term.setExpression(term.convert());
        System.out.println("Evaluated result : " + term.evaluate());
    }
}