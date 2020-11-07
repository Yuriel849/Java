package edu.hamburg.haw;

/**
 * Main class of the second lab session. Contains the static main method.
 * @author Yuriel
 * @version 07.11.2020.
 */
public class SecondLab {
    private static ArithmeticTerm term = new ArithmeticTerm("test");
    private static Double result = 0.0;

    public static void main(String[] args) {
//        term.setExpression("( ( ( sin ( ( 4 * 3.14 ) / 3 ) ) * exp ( ( - ( ( sqrt 2 ) - 1 ) ) / 8 ) ) / sqrt ( 6 * 3.14 ) )");
//        System.out.println(term.convert());

        // Problem 5 Task 2 - Constructor a tree with the expression ( ( ( sqrt 4 ) * ( 2 ^ 3 ) ) / 2 ).
        Tree.BiNode four = new Tree.BiNode("4");
        Tree.BiNode sqrt = new Tree.BiNode("sqrt", null, four);
        Tree.BiNode twoFirst = new Tree.BiNode("2");
        Tree.BiNode three = new Tree.BiNode("3");
        Tree.BiNode pow = new Tree.BiNode("^", twoFirst, three);
        Tree.BiNode mult = new Tree.BiNode("*", sqrt, pow);
        Tree.BiNode twoSecond = new Tree.BiNode("2");
        Tree.BiNode div = new Tree.BiNode("/", mult, twoSecond);

        Tree tree = new Tree(div);
        // Problem 5 Task 3 - Call inorderTraversal() on the tree from Task 2.
        tree.inorderTraversal();
        System.out.println(tree.getResult());
        // Problem 5 Task 4 - Call infixGenerator() on the tree from Task 2.
        tree.infixGenerator();
        String result = tree.getResult();
        System.out.println(result);
        term.setExpression(result);
        term.setExpression(term.convert());
        System.out.println(term.evaluate());
    }
}