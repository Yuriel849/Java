import java.util.Iterator;
import java.util.Stack;

/**
 * A variation of the Sedgewick implementation of a left-leaning red-black binary search tree.
 *
 * @author Yuriel
 * @version 2020.12.11.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>, Iterable<Key> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int max, sumDepths, numNodes; // Maximum tree depth, Sum of all Nodes' depths, Number of Nodes in the tree

    public int getNumNodes() { return numNodes; }

    private class Node {
        Key key;
        Value val;
        int depth;
        Node left, right;
        boolean color; // Color of incoming link from parent Node.
        Node(Key key, Value val, int depth, boolean color) {
            this.key = key;
            this.val = val;
            this.depth = depth;
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
            sumDepths += x.depth;
            numNodes++;
            if(x.depth > max) max = x.depth;
            pushLeft(x.right);
            return x.key;
        }
    }

    /**
     * Inserts the given key and value into the tree.
     * If the key already exists, the given value overwrites the preexisting value.
     * If the key does not exist, a new node is created with this key and value.
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        root = insert(root, key, val, 0);
        root.color = BLACK;
    }

    /**
     * A private method called recursively to handle the insertion.
     * @param x
     * @param key
     * @param val
     * @param parentDepth
     */
    private Node insert(Node x, Key key, Value val, int parentDepth) {
        if(x == null) return new Node(key, val, parentDepth, RED);
        if(isRed(x.left) && isRed(x.left.left)) x = splitFourNode(x);
        int cmp = key.compareTo(x.key);
        if(cmp == 0) x.val = val;
        else if(cmp < 0) x.left = insert(x.left, key, val, parentDepth + 1);
        else x.right = insert(x.right, key, val, parentDepth + 1);
        if(isRed(x.right)) x = leanLeft(x);
        return x;
    }

    /**
     * Gets the value of the given key from the binary search tree.
     * If the key does not exist, returns null.
     */
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

    /**
     * Checks if the given key exists in the binary search tree and returns true or false.
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void remove(Key key) {
    }

    public Iterator<Key> iterator() {
        max = 0;
        sumDepths = 0;
        numNodes = 0;
        return new BSTIterator();
    }

    /**
     * Affects a local transformation to balance the binary search tree by rotating two connected nodes to the left.
     */
    private Node rotateLeft(Node h) {
        Node v = h.right;
        h.right = v.left;
        v.left = h;
        h.depth++;
        v.depth--;
        return v;
    }

    /**
     * Affects a local transformation to balance the binary search tree by rotating two connected nodes to the right.
     */
    private Node rotateRight(Node h) {
        Node u = h.left;
        h.left = u.right;
        u.right = h;
        h.depth++;
        u.depth--;
        return u;
    }

    /**
     * Checks whether the given node's relationship with its parent node is red or black.
     * @return true if red, false if black or if this node is null.
     */
    private boolean isRed(Node x) {
        if (x == null) return false;
        return (x.color == RED);
    }

    /**
     * Splits a 4-node by moving the middle key to the parent node and making two new 2-nodes from the remaining keys.
     */
    private Node splitFourNode(Node h) {
        Node x = rotateRight(h);
        x.left.color = BLACK;
        return x;
    }

    /**
     * Makes this part of the tree lean left to create a left-leaning tree.
     */
    private Node leanLeft(Node h) {
        Node x = rotateLeft(h);
        x.color = x.left.color;
        x.left.color = RED;
        return x;
    }

    /**
     * Returns the maximum depth of the tree.
     * @return The maximum tree depth of this binary search tree.
     */
    public int maxTreeDepth() {
        Iterator<Key> iterator = iterator();
        while(iterator.hasNext()) iterator.next();
        return max;
    }

    /**
     * Calculate the mean depth of the tree as the sum of all Nodes' depths divided by the number of Nodes.
     * @return The mean tree depth.
     */
    public int meanTreeDepth() {
        maxTreeDepth();
        return sumDepths / numNodes;
    }
}
