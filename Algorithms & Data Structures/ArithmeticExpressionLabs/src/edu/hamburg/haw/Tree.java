package edu.hamburg.haw;

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
        return result.toString().stripTrailing();
    }

    private boolean hasChild(BiNode node) { return node.left != null || node.right != null; }

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
        if(hasChild(node)) result.append("( ");
        if(node.left != null) infixGenerator(node.left);
        result.append(node.item).append(" ");
        if(node.right != null) infixGenerator(node.right);
        if(hasChild(node)) result.append(") ");
    }

    public void infixGenerator() {
        result.delete(0, result.length());
        infixGenerator(root);
    }
}
