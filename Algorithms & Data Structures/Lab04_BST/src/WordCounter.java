import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Keep a record of how many times each word was
 * entered by users.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    1.0 (2016.02.29)
 *
 * Modified to use the BST class instead of HashMaps.
 * @author     Yuriel
 * @version    2020.12.17.
 */
public class WordCounter {
    private RedBlackBST<String, Integer> counts; // Associate each word with a count.
    private RedBlackBST<Integer, HashSet<String>> inverted; // Histogram with the integer over the words.

    /**
     * Create a WordCounter
     */
    public WordCounter() {
        counts = new RedBlackBST<>();
        updateInverted(); //instance variable
    }

    /**
     * Update the usage count of all words in input.
     * @param input A set of words entered by the user.
     */
    public void addWords(HashSet<String> input) {
        for(String word : input) {
            addWord(word);
        }
    }

    /**
     * Method addWord and update the counts of all words.
     * @param word A word to be added.
     */
    public void addWord(String word) {
        Integer counter = counts.get(word);
        counts.put(word, counter == null ? 1 : counter + 1);
        updateInverted();
    }

    /**
     * Always called after changing "counts" in order to keep "inverted" consistent.
     */
    private void updateInverted() {
        inverted = new RedBlackBST<Integer, HashSet<String>>();
        changeInverted(inverted); // Ignores returned BST.
    }

    /**
     * Method calculateInverted to demonstrate the implementation of problems 8,9 in Lab 3.
     * Think of the HashMap in terms of Histogram and inverted Histogram (sketch in the lecture).
     * @return A (RedBlack)BST object.
     */
    public RedBlackBST<Integer, HashSet<String> > calculateInverted() {
        return changeInverted(new RedBlackBST<Integer, HashSet<String>>());
    }

    /**
     * Private method called by both updateInverted() and calculateInverted().
     * Created to remove duplicate code.
     * updateInverted() ignores the returned BST, while calculateInverted() returns the returned BST.
     * @param bst A (RedBlack)BST object.
     * @return The "bst" passed as an argument, after updating with the contents of "count".
     */
    private RedBlackBST<Integer, HashSet<String>> changeInverted(RedBlackBST<Integer, HashSet<String>> bst) {
        Iterator iterator = counts.iterator();
        while(iterator.hasNext()) {
            String word = (String) iterator.next();
            int counter= counts.get(word); // returns the number of occurencies of the word
            // i.e. the y-values in the histogram !
            HashSet<String> tmp = bst.get(counts.get(word));// returns the hashSet of words
            // in inverted for the y-value
            // or null if that integer is not in the keys of inverted
            if(tmp == null) tmp = new HashSet<String>();
            // inverted.getOrDefault(counter, new HashSet<String>()); // replaces the last 2 lines
            tmp.add(word);
            bst.put(counter, tmp);
        }
        return bst;
    }

    /**
     * print the HashMap containing the counted words
     */
    public void print() {
        //System.out.println(iteratePrint(counts));
        //System.out.println(iteratePrint(inverted));
        System.out.println("Histogram : ");
        getDepthHistogram();
        System.out.println("Number of nodes : " + counts.getNumNodes());
        System.out.println("Maximum tree depth : " + counts.maxTreeDepth());
        System.out.println("Mean tree depth : " + counts.meanTreeDepth());
    }

    /**
     * Format the contents of the (RedBlack)BST object passed as an argument into a readable string.
     * @param tree The (RedBlack)BST object passed as an argument.
     * @return The contents of the (RedBlack)BST argument as a String.
     */
    private String iteratePrint(RedBlackBST tree) {
        StringBuilder string = new StringBuilder();
        string.append("{ ");
        Iterator iterator = tree.iterator();
        while(iterator.hasNext()) {
            Comparable word = (Comparable) iterator.next();
            string.append(word + "=" + tree.get(word) + ", ");
        }
        string.append(" }");
        return string.toString();
    }

    /**
     * Prints a node depth histogram of the (RedBlack)BST "counts".
     */
    private void getDepthHistogram() {
        HashMap<Integer, Integer> histogram = new HashMap<>(); // Key is depth, value is number of nodes at that depth.
        Iterator iterator = counts.iterator();
        int depth;
        while(iterator.hasNext()) {
            depth = counts.getDepth((String) iterator.next());
            histogram.put(depth, histogram.getOrDefault(depth, 0) + 1);
        }
        System.out.println(histogram);
    }
}