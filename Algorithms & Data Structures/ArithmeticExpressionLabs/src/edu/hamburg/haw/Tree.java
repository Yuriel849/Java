package edu.hamburg.haw;

/**
 * Class Tree.
 * Represents a binary tree.
 * @author Yuriel
 * @version 08.11.2020.
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
     * Checks whether a BiNode has a child.
     * @param node The BiNode to check.
     */
    private boolean hasChild(BiNode node) { return node.left != null || node.right != null; }

    /**
     * Traverses the tree in order, with the given node as the root.
     * @param node The root node.
     */
    private void inorderTraversal(BiNode node) {
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
}