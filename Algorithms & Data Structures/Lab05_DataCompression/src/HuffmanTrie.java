import java.util.HashMap;
import java.util.Map;

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
    // Lookup table matching characters and their Huffman trie binary codes
    private static HashMap<Character, String> charBinaryCodes = new HashMap<>();

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
     * The trie's inner nodes are represented by a star ("*").
     *
     * @param root The root of the Huffman trie to be encoded.
     * @return The String representation of the encoded Huffman trie.
     */
    public static String encodeTrie(Node root) {
        return preorderTraversal(root);
    }

    private static String preorderTraversal(Node node) {
        String value = "" + node.ch;
        if(node.left != null)
            value += preorderTraversal(node.left);
        if(node.right != null)
            value += preorderTraversal(node.right);
        return value;
    }

    public static String encode(Node root, String source) {
        setCharBinaryCodes(root, new StringBuilder());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            result.append(charBinaryCodes.get(c));
        }

        return result.toString();
    }

    private static void setCharBinaryCodes (Node node, StringBuilder prefix) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                charBinaryCodes.put(node.ch, prefix.toString());
            } else {
                prefix.append('0');
                setCharBinaryCodes(node.left, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
                prefix.append('1');
                setCharBinaryCodes(node.right, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s1 = "she_sells_sea_shells_by_the_seashore";
        String s2 = "selly_sells_her_shorts_by_the_seattle_store";

        Node root = constructTrie(s1); // Generate tree T1
        String t1 = encodeTrie(root);  // Generate String representation of T1
        String encodedS1 = encode(root, s1); // Encode s1 with T1
        System.out.printf("T1 as String : %s \ns1 encoded : %s \nNumber of bits : %d \n", t1, encodedS1, encodedS1.length());

        root = constructTrie(s2); // Generate tree T1
        String t3 = encodeTrie(root);  // Generate String representation of T1
        String encodedS2 = encode(root, s2); // Encode s1 with T1
        System.out.printf("T3 as String : %s \ns2 encoded : %s \nNumber of bits : %d \n", t3, encodedS2, encodedS2.length());
    }
}
