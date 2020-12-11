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
 * @version    2020.12.09.
 */
public class WordCounter
{
    // Associate each word with a count.
    private BST<String, Integer> counts;
    private BST<Integer, HashSet<String>> inverted;
    // will contain the histogram with the integer over the words

    /**
     * Create a WordCounter
     */
    public WordCounter()
    {
        counts = new BST<>();
        updateInverted(); //instance variable
    }

    /**
     * Update the usage count of all words in input.
     * @param input A set of words entered by the user.
     */
    public void addWords(HashSet<String> input)
    {
        for(String word : input) {
            addWord(word);
        }
    }

    /**
     * Method addWord and update the counts of all words
     *
     * @param word A word to be added
     */
    public void addWord(String word)
    {
        Integer counter = counts.get(word);
        counts.put(word, counter == null ? 1 : counter + 1);
        updateInverted();
    }

    private void updateInverted() // always to be called after changing counts!!
    // in order to keep inverted consistent!!!
    {
        inverted = new BST<Integer, HashSet<String>>();
        Iterator iterator = counts.iterator();
        while(iterator.hasNext()) {
            String word = (String) iterator.next();
            int counter = counts.get(word); // returns the number of occurencies of the word
            // i.e. the y-values in the histogram !
            HashSet<String> tmp = inverted.get(counts.get(word));// returns the hashSet of words
            // in inverted for the y-value 
            // or null if that integer is not in the keys of inverted
            if(tmp == null) tmp = new HashSet<String>();
            // inverted.getOrDefault(counter, new HashSet<String>());
            tmp.add(word);
            inverted.put(counter, tmp);
        }
    }

    /**
     * Method calculateInverted 
     * to demonstrate the implementation of problems 8,9 in Lab 3
     * contains redundant code taken from method private updateInverted
     * Think the HashMap in terms of Histogram and inverted Histogram (sketch in the lecture)
     *
     * @return The return value
     */
    public BST<Integer, HashSet<String> > calculateInverted()
    {
        BST<Integer, HashSet<String>> inverted = new BST<>();
        Iterator iterator = counts.iterator();
        while(iterator.hasNext()) {
            String word = (String) iterator.next();
            int counter= counts.get(word); // returns the number of occurencies of the word
            // i.e. the y-values in the histogram !
            HashSet<String> tmp = inverted.get(counts.get(word));// returns the hashSet of words
            // in inverted for the y-value 
            // or null if that integer is not in the keys of inverted
            if(tmp == null) tmp = new HashSet<String>();
            // inverted.getOrDefault(counter, new HashSet<String>()); // replaces the last 2 lines
            tmp.add(word);
            inverted.put(counter, tmp);
        }
        return inverted;
    }

    /**
     * print the HashMap containing the counted words
     */
    public void print()
    {
//        System.out.println(iteratePrint(counts));
//        System.out.println(iteratePrint(inverted));
        System.out.println("Number of nodes : " + counts.getNumNodes());
        System.out.println("Maximum tree depth : " + counts.maxTreeDepth());
        System.out.println("Mean tree depth : " + counts.meanTreeDepth());
    }

    /**
     * Format the contents of the RedBlackBST object passed as an argument into a readable string.
     * @param tree The RedBlackBST object passed as an argument.
     */
    private String iteratePrint(BST tree) {
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
}