/**
 * Class Insertion from Sedgewick.
 * It was not type-safe because Comparable was used generically.
 * Here is the solution chosen by Java's Arrays.sort():
 * It might throw a ClassCastException if the object is not mutually comparable.
 * I would still prefer Sedgewick's solution because the compiler
 * tells me that my objects do not implement Comparable if they don't.
 * Not so here!
 *
 * @author Wolfgang Renz
 * @version Nov. 12, 2020
 */
public class Insertion extends Sort {
    // Comparable is a raw type. References to generic type Comparable<T> should be parameterized
    public static void sort(Object[] a) {
        reset();
        int N = a.length;
        System.out.println("Insertion, is sorted before sorting? : " + isSorted(a, 0, N-1));
        System.out.println("Insertion, is partitioned before sorting? : " + isPartitioned(a, 0, (N-1)/2, N-1));
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                } else {
                    break; // input dependent
                }
            }
            assert isSorted(a, 0, i);
        }
        System.out.println("Insertion, is sorted after sorting? : " + isSorted(a, 0, N-1));
        System.out.println("Insertion, is partitioned after sorting? : " + isPartitioned(a, 0, (N-1)/2, N-1));
    }
}
