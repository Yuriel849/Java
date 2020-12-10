import java.util.Iterator;
import java.util.Stack;

/**
 * A variation of the Sedgewick implementation of a binary search tree.
 *
 * @author Yuriel
 * @version 2020.12.07.
 */
public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>, Iterable<Key> {
    private Node root;
    private int max,   // Maximum tree depth, sum of all Nodes' depths, number of Nodes in the tree
            sumDepths, // Sum of all Nodes' depths
            numNodes;  // Number of Nodes in the tree

    private class Node {
        Key key;
        Value val;
        int depth;
        Node left, right;
        Node(Key key, Value val, int depth) {
            this.key = key;
            this.val = val;
            this.depth = depth;
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

        BSTIterator() { pushLeft(root); }

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
        root = put(root, key, val, 0);
    }

    /**
     * A private method called recursively to handle the insertion.
     * @param x
     * @param key
     * @param val
     * @param parentDepth
     */
    private Node put(Node x, Key key, Value val, int parentDepth) {
        if(x == null) return new Node(key, val, parentDepth);
        int cmp = key.compareTo(x.key);
        if(cmp == 0) x.val = val;
        else if(cmp < 0) x.left = put(x.left, key, val, parentDepth+1);
        else x.right = put(x.right, key, val, parentDepth+1);
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
            if(cmp == 0 && x.val != null) return x.val;
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

    /**
     * Removes the node with the given key from the binary search tree.
     * Does not perform true deletion but just sets the value of the node with the given key to null.
     */
    public void remove(Key key) {
        if(contains(key))
            put(key, null);
    }

    public Iterator<Key> iterator() {
        max = 0;
        sumDepths = 0;
        numNodes = 0;
        return new BSTIterator();
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