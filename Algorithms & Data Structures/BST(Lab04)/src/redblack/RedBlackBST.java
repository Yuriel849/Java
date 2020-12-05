package redblack;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Yuriel
 * @version 2020.12.05.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int max, sumDepths, numNodes; // Maximum tree depth, Sum of all Nodes' depths, Number of Nodes in the tree

    private class Node {
        Key key;
        Value val;
        Node left, right;
        boolean color; // Color of incoming link from parent Node.
        Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    private class BSTIterator implements Iterator<Key> {
        private Stack<Node> stack = new Stack<>();

        private void pushLeft(Node x) {
            while(x != null) {
                stack.push(x);
                x = x.left;
            }
        }

        BSTIterator() {
            pushLeft(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Key next() {
            Node x = stack.pop();
            pushLeft(x.right);
            return x.key;
        }
    }

    public void put(Key key, Value val) {
        root = insert(root, key, val);
        root.color = BLACK;
    }

    private Node insert(Node x, Key key, Value val) {
        if(x == null) return new Node(key, val, RED);
        if(isRed(x.left) && isRed(x.left.left)) x = splitFourNode(x);
        int cmp = key.compareTo(x.key);
        if(cmp == 0) x.val = val;
        else if(cmp < 0) x.left = insert(x.left, key, val);
        else x.right = insert(x.right, key, val);
        if(isRed(x.right)) x = leanLeft(x);
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp == 0) return x.val;
            else if(cmp < 0) x = x.left;
            else x = x.right;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void remove(Key key) {
    }

    public Iterator<Key> iterator() {
        return new BSTIterator();
    }

    private Node rotateLeft(Node h) {
        Node v = h.right;
        h.right = v.left;
        v.left = h;
        return v;
    }

    private Node rotateRight(Node h) {
        Node u = h.left;
        h.left = u.right;
        u.right = h;
        return u;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return (x.color == RED);
    }

    private Node splitFourNode(Node h) {
        Node x = rotateRight(h);
        x.left.color = BLACK;
        return x;
    }

    private Node leanLeft(Node h) {
        Node x = rotateLeft(h);
        x.color = x.left.color;
        x.left.color = RED;
        return x;
    }
}
