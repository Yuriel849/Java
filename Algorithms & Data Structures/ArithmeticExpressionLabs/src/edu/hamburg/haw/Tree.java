package edu.hamburg.haw;

import java.util.function.BinaryOperator;

public class Tree {
    public static class BiNode {
        public String item;
        public BiNode left;
        public BiNode right;

        public BiNode(String item) {
            this(item, null, null);
        }

        public BiNode(String item, BiNode left, BiNode right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    private BiNode root;
    private StringBuilder result = new StringBuilder("");

    public Tree(BiNode root) {
        this.root = root;
    }

    public String getResult() {
        return result.toString();
    }

    private void inorderTraversal(BiNode node) {
        if(node.left != null) inorderTraversal(node.left);
        result.append(node.item).append(" ");
        if(node.right != null) inorderTraversal(node.right);
    }

    public void inorderTraversal() {
        result.delete(0, result.length());
        inorderTraversal(root);
    }

    private void infixGenerator(BiNode node) {
        if(node.left != null) {
            result.append("( ");
            infixGenerator(node.left);
        }
        result.append(node.item).append(" ");
        if(node.right != null) {
            infixGenerator(node.right);
            result.append(") ");
        }
    }

    public void infixGenerator() {
        result.delete(0, result.length());
        result.append("( ");
        infixGenerator(root);
    }
}
