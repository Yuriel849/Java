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
    protected static void exch(Object[] a, int i, int j) {
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static boolean less(Object v, Object w) {
        // type cast to Record
        return (((Comparable)v).compareTo((Comparable)w) < 0);
    }
}
