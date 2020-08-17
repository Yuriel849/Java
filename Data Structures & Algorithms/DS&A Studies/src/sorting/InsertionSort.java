package sorting;

/**
 * The Insertion Sort is a simple sorting algorithm, by which each element in the array is considered separately,
 *      placing the element in the correct index relative to the other elements before (to the left of) it.
 */

public class InsertionSort {
    /** Insertion Sort of an array of characters into ascending order. */
    public static void insertionSort(char[] data) {
        int n = data.length;
        for(int k = 1; k < n; k++) { // Starts with second character in the array, data[1].
            char cur = data[k];
            int j = k;
            while(j > 0 && data[j-1] > cur) { // Move data[j-1] as many times as necessary.
                data[j] = data[j-1];
                j--;
            }
            data[j] = cur; // Insert cur into the array, after moving data[j-1] to the right.
        }
    }
}
