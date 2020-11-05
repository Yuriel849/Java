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

    public Tree(BiNode root) {
        this.root = root;
    }
}
