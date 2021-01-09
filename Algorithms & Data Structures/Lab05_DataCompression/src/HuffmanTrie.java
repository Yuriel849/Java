/**
 * Huffman Trie class.
 *
 * Parts of the code were taken from: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Huffman.java.html
 *
 * @author Yuriel
 * @version 2021.01.03.
 */

public class HuffmanTrie {
    // Alphabet size of extended ASCII
    private static final int R = 256;

    // Node inner class for Huffman trie
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Constructs a Huffman trie from the given String input.
     *
     * @param input The source String to convert into a Huffman trie.
     * @return The root Node of the constructed Huffman trie.
     */
    public static Node constructTrie(String input) {
        int[] freq = new int[R];
        for(int i = 0; i < input.length(); i++) {
            freq[(int)input.charAt(i)]++;
        }

        MinPQ<Node> pq = new MinPQ<Node>();
        for(int i = 0; i < 128; i++)
            if(freq[i] > 0)
                pq.insert(new Node((char) i, freq[i], null, null));

        while(pq.size() > 1) {
            Node x = pq.delMin();
            Node y = pq.delMin();
            Node parent = new Node('*', x.freq + y.freq, x, y);
            pq.insert(parent);
        }

        return pq.delMin();
    }

    /**
     * Encodes a Huffman trie into a String, by going over the trie in pre-order traversal.
     * THe trie's inner nodes are represented by a star ("*").
     *
     * @param root The root of the Huffman trie to be encoded.
     * @return The String representation of the encoded Huffman trie.
     */
    public static String encodeTrie(Node root) {
        return preorderTraversal(root);
    }

    private static String preorderTraversal(Node node) {
        System.out.print(node.ch);
        String value = "" + node.ch;
        if(node.left != null)
            value += preorderTraversal(node.left);
        if(node.right != null)
            value += preorderTraversal(node.right);
        return value;
    }

    public static void main(String[] args) {
        String s1 = "she_sells_sea_shells_by_the_seashore";
        String s2 = "selly_sells_her_shorts_by_the_seattle_store";

        // Generate tree T1
        String t1 = encodeTrie(constructTrie(s1));
        System.out.println("\n" + t1);
        // Generate tree T3
//        String t3 = encodeTrie(constructTrie(s2));
//        System.out.println(t3);


    }
}
