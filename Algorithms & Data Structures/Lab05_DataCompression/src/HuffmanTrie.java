/**
 *
 * Parts of the code were taken from: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Huffman.java.html
 */
public class HuffmanTrie {
    // alphabet size of extended ASCII
    private static final int R = 256;

    // Huffman trie node
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

    public static Node constructTrie(String input) {
        int[] freq = new int[R];
        for(int i = 0; i < input.length(); i++) {
            freq[(int)input.charAt(i)]++;
        }

        for(int i = 0; i < R; i++)
            if(freq[i] > 0)
                System.out.printf((char) i + " : " + freq[i] + "\n");

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

    public static void main(String[] args) {
        String s1 = "she_sells_sea_shells_by_the_seashore";
        Node root = constructTrie(s1);
    }
}
