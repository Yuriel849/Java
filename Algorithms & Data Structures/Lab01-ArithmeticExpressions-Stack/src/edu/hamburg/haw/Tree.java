package edu.hamburg.haw;

import javax.print.DocFlavor;

public class Tree {
    private class BiNode {
        public String item;
        public BiNode left;
        public BiNode right;

        BiNode(String item) {
            this(item, null, null);
        }

        BiNode(String item, BiNode left, BiNode right) {
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
