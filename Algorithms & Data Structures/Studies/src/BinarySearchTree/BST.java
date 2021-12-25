package BinarySearchTree;

import java.util.Iterator;
import java.util.Stack;

/**
 * A variation of the Sedgewick implementation of a binary search tree.
 *
 * @author Yuriel
 * @version 2021.12.25.
 */
public class BST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private Node root;
    private int max, sumDepths, numNodes;
    // Maximum tree depth, sum of all Nodes' depths, number of Nodes in the tree

    public int getNumNodes() { return numNodes; }

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

    public Iterator<Key> iterator() {
        max = 0;
        sumDepths = 0;
        numNodes = 0;
        return new BSTIterator();
    }

    /**
     * Inserts the given key into the tree with null as the value.
     * To be used when only the key is used and the value is unnecessary.
     * @param key
     */
    public void put(Key key) { root = put(root, key, (Value) Integer.valueOf(0), 0); }

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
     * Gets the depth of the Node with the given key.
     * @param key
     * @return Depth of the Node with the given key. Returns -1 if there is no Node with the given key.
     */
    public int getDepth(Key key) {
        Node x = root;
        while(x != null) {
            int cmp = key.compareTo(x.key);
            if(cmp == 0 && x.val != null) return x.depth;
            else if(cmp < 0) x = x.left;
            else x = x.right;
        }
        return -1;
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

    /**
     * Deletes the node with the given key from the binary search tree.
     * The deleted node is the return value of this method.
     * Reconstructs the tree so it remains a binary tree after deleting the node.
     * @param key
     */
    public Node delete(Key key) {
        Node parent = null, target = root;
        while(target != null) {
            parent = target;
            int cmp = key.compareTo(target.key);
            if(cmp == 0 && target.val != null) break;
            else if(cmp < 0) target = target.left;
            else target = target.right;
        }
        // Step 1: Find the target node and its parent node.
        // Step 2: Replace the target node with the target node's left child node.
        // Step 3: Move the
        return null;
    }

    /**
     * Traverses the tree in order and prints the key of each node.
     */
    public void inorderTraversal() { inorderTraversal(root); }

    /**
     * A private method called recursively to handle inorder traversal of the tree.
     * @param node
     */
    private void inorderTraversal(Node node) {
        Stack<Node> stack = new Stack<>();
        while(node != null || !stack.isEmpty()) {
            if(node!= null) {
                stack.add(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.print(node.key + "  ");
                node = node.right;
            }
        }
    }

    /**
     * Finds and returns the node with the smallest key.
     * The values of nodes are not considered.
     * This is achieved by going down the left children from the root, until the leftmost node is found.
     */
    public Node minKey() { return minKey(root); }

    /**
     * A private method called recursively to find the node with the smallest key.
     * @param node
     */
    private Node minKey(Node node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return minKey(node.left);
    }

    /**
     * Finds and returns the node with the largest key.
     * The values of nodes are not considered.
     * This is achieved by going down the right children from the root, until the rightmost node is found.
     */
    public Node maxKey() { return maxKey(root); }

    /**
     * A private method called recursively to find the node with the largest key.
     * @param node
     */
    private Node maxKey(Node node) {
        if (node == null) return null;
        if (node.right == null) return node;
        return maxKey(node.right);
    }

    /**
     * Finds the inorder predecessor and successor nodes for the given key.
     * If a predecessor or successor is not found, returns null instead of a node.
     * For example, if the key is 55,
     * a predecessor will the node with the largest key that is smaller than 55,
     * and a successor will be the node with the smallest key that is larger than 55.
     * @param key
     * @return Array holding the predecessor and successor nodes.
     * Array values are null if no predecessor or successor exists.
     */
    public Node[] inorderPredSuc(Key key) { return inorderPredSuc(root, key); }

    /**
     * A private method called recursively to find the inorder predecessor and successor nodes for the given key.
     * @param node
     * @param key
     * @return Array holding the predecessor and successor nodes.
     */
    private Node[] inorderPredSuc(Node node, Key key) {
        // Array to return, initialize with null.
        Object[] predSuc = { null, null };
        if(node != null) {
            int cmp = key.compareTo(node.key);
            if(cmp == 0) {
                predSuc[0] = findPred(node.left);
                predSuc[1] = findSuc(node.right);
            } else if(cmp < 0) {
                predSuc[1] = node;
                predSuc = inorderPredSuc(node.left, key);
            } else if(cmp > 0) {
                predSuc[0] = node;
                predSuc = inorderPredSuc(node.right, key);
            }
        }
        return (Node[]) predSuc;
    }

    /**
     * Finds the inorder predecessor node for the given node,
     * by searching for the rightmost child of the given node's left child.
     * This will be the node with the largest key in the given node's left subtree.
     * @param node
     * @return The predecessor node.
     */
    private Node findPred(Node node) {
        if(node != null)
            while(node.right != null)
                node = node.right;
        return node;
    }

    /**
     * Finds the inorder successor node for the given node,
     * by searching for the leftmost child of the given node's right child.
     * This will be the node with the smallest key in the given node's right subtree.
     * @param node
     * @return The successor node.
     */
    private Node findSuc(Node node) {
        if(node != null)
            while(node.left != null)
                node = node.left;
        return node;
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
     * @return The rounded integer value of the mean tree depth.
     */
    public int meanTreeDepth() {
        maxTreeDepth();
        return Math.round((float) sumDepths / numNodes);
    }
}