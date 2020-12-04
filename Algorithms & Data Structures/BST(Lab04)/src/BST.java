import java.util.Iterator;
import java.util.Stack;

/**
 * @author Yuriel
 * @version 2020.12.04.
 */
public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>, Iterable<Key> {
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        Node(Key key, Value val) {
            this.key = key;
            this.val = val;
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
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if(cmp == 0) x.val = val;
        else if(cmp < 0) x.left = put(x.left, key, val);
        else x.right = put(x.right, key, val);
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp == 0 && x.val != null) return x.val;
            else if(cmp < 0) x = x.left;
            else x = x.right;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void remove(Key key) {
        if(contains(key))
            put(key, null);
    }

    public Iterator<Key> iterator() {
        return new BSTIterator();
    }
}
