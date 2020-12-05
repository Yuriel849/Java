import java.util.Iterator;
import java.util.Stack;

/**
 * @author Yuriel
 * @version 2020.12.04.
 */
public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>, Iterable<Key> {
    private Node root;
    private int max, sumDepths, numNodes; // Maximum tree depth, Sum of all Nodes' depths, Number of Nodes in the tree

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

    /**
     * Returns the maximum depth of the tree.
     * @return The maximum tree depth of this binary search tree.
     */
    public int maxTreeDepth() {
        max = 0;
        sumDepths = 0;
        numNodes = 0;
        traverse(root, max + 1);
        return max;
    }

    /**
     * Traverse the tree in pre-order.
     * @param node The current Node.
     * @param depth The tree depth at the current Node (Node's depth + 1).
     */
    private void traverse(Node node, int depth) {
        sumDepths += depth - 1; // Node's depth is (tree's depth - 1)
        numNodes++;
        if(depth > max) max = depth;
        if(node.left != null) traverse(node.left, depth + 1);
        if(node.right != null) traverse(node.right, depth + 1);
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
