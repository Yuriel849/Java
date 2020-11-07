package edu.hamburg.haw;

public class Node {
    private String item;
    private Node left;
    private Node right;

    public Node(String item) {
        this(item, null, null);
    }

    public Node(String item, Node left, Node right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }
}
