/**
 * Abstract class Sort is responsible for operations and their counting.
 * Its original was not type-safe because Comparable was used generically.
 * Here is the solution chosen by Java's Arrays.sort():
 * It might throw a ClassCastException if the object is not mutually comparable.
 * I would still prefer Sedgewick's solution because the compiler
 * tells me that my objects do not implement Comparable if they don't.
 * Not so here!
 *
 * @author Wolfgang Renz
 * @version Nov. 3, 2020
 */
public abstract class Sort {
    private static int compares = 0, copies = 0;

    /**
     * Resets the counter for comparison and copy operations.
     * @author Yuriel
     * @version 22.11.2020.
     */
    protected static void reset() {
        compares = 0;
        copies = 0;
    }

    /**
     * Returns the number of comparison operations.
     * @return The number of comparison operations.
     * @author Yuriel
     * @version 22.11.2020.
     */
    public static int getCompares() {
        return compares;
    }

    /**
     * Returns the number of copy operations.
     * @return The number of copy operations.
     * @author Yuriel
     * @version 22.11.2020.
     */
    public static int getCopies() {
        return copies;
    }

    protected static void exch(Object[] a, int i, int j) {
        copies += 3; // 3 copy operations to exchange two values (incl. temp)
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static boolean less(Object v, Object w) {
        compares++;
        return (((Comparable)v).compareTo((Comparable)w) < 0);
    }

    /**
     * Checks if the array 'a' is sorted for left <= array-index < right.
     * @author Yuriel
     * @version 18.11.2020.
     */
    protected static boolean isSorted(Object[] a, int left, int right) {
        boolean sorted = true;
        Comparable[] arr = (Comparable[]) a;

        for(int i = left; i < right; i++)
            if(arr[i].compareTo(arr[i+1]) > 0) // compareTo() should return 0 or negative integer if 'a' is sorted.
                sorted = false;

        return sorted;
    }

    /**
     * Checks if all array elements in the range left <= array-index < border are
     * smaller than all elements in the range border <= array-index < right.
     * @author Yuriel
     * @version 18.11.2020.
     */
    protected static boolean isPartitioned(Object[] a, int left, int border, int right) {
        boolean partitioned = false;
        Comparable leftPart = (Comparable) a[left], rightPart = (Comparable) a[border];

        // Find largest element in left partition.
        for(int i = left+1; i < border; i++)
            if(leftPart.compareTo(a[i]) < 0)
                leftPart = (Comparable) a[i];

        // Find smallest element in right partition.
        for(int i = border+1; i < right; i++)
            if(rightPart.compareTo(a[i]) > 0)
                rightPart = (Comparable) a[i];

        // Compare, largest element in left should be equal or smaller than smallest element in right.
        if(leftPart.compareTo(rightPart) <= 0)
            partitioned = true;

        return partitioned;
    }
}