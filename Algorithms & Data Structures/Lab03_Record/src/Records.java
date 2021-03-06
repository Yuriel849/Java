import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

/**
 * Class Records:
 * Test of stability of divers sorting algorithms.<br>
 *
 * @author Wolfgang Renz
 * @version Nov. 3, 2020
 */
public class Records {
    // size for stable sort tests in main program:
    private final static int N= 8;
    // instance variables - replace the example below with your own
    private final int size;
    private Record[] recs;
    private List<Record> list;

    /**
     * Constructor for objects of class Records
     */
    public Records(int size) {
        // initialise instance variables
        this.size=size;
        recs= new Record[size];
        init();
    }

    private void init() {
        for (int i=0; i<size; i++) {
            // recs[i] = new Record(new Integer(i/4),"o"+i);
            // The constructor Integer(int) is deprecated since version 9
            // https://docs.oracle.com/javase/9/docs/api/java/lang/Integer.html#Integer-int-
            // "The static factory valueOf(int) is generally a better choice, as it is likely to yield significantly better space and time performance."
            recs[i] = new Record(Integer.valueOf(i/4),"o"+i);
        }
        list= Arrays.asList(recs);
    }

    @Override
    public String toString()
    {
        return list.toString();
    }

    public void shuffle() {
        Collections.shuffle(list, new Random(System.currentTimeMillis()));
        // recs= list.toArray(recs); // Not required because changes to list are reflected in array, and vice versa.
    }

    public void insertionSort() {
        Insertion.sort(recs);
    }

    public void selectionSort() {
        Selection.sort(recs);
    }

    public void quicksort() {
        Quicksort.sort(recs);
    }

    public static void main(String[] a) {
        Records recs= new Records(N);
        System.out.println(recs);

        System.out.println("\n Stable Sort Test for Insertion Sort:");
        recs.shuffle();
        System.out.println(recs);
        recs.insertionSort();
        System.out.println(recs);
        System.out.println("#(cmp) : " + Sort.getCompares() + ", #(cpy) : " + Sort.getCopies());


        System.out.println("\n Stable Sort Test for Selection Sort:");
        recs.shuffle();
        System.out.println(recs);
        recs.selectionSort();
        System.out.println(recs);
        System.out.println("#(cmp) : " + Sort.getCompares() + ", #(cpy) : " + Sort.getCopies());


        System.out.println("\n Stable Sort Test for Quicksort:");
        recs.shuffle();
        System.out.println(recs);
        recs.quicksort();
        System.out.println(recs);
        System.out.println("#(cmp) : " + Sort.getCompares() + ", #(cpy) : " + Sort.getCopies());
    }
}