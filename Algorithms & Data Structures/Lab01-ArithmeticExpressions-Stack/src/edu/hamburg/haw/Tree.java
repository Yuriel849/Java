package edu.hamburg.haw;

public class Tree {
    private class BiNode {
        public String item;
        public BiNode left;
        public BiNode right;
    }

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }
}
