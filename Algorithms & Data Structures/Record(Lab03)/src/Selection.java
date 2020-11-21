/**
 * Class Selection from Sedgewick.
 * It was not type-safe because Comparable was used generically.
 * Here is the solution chosen by Java's Arrays.sort():
 * It might throw a ClassCastException if the object is not mutually comparable.
 * I would still prefer Sedgewick's solution because the compiler
 * tells me that my objects do not implement Comparable if they don't.
 * Not so here!
 *
 * @author Wolfgang Renz
 * @version Nov. 3, 2020
 */
public class Selection extends Sort {
    // Comparable is a raw type. References to generic type Comparable<T> should be parameterized
    public static void sort(Object[] a) {
        int N = a.length;
        System.out.println("Insertion, is sorted before sorting? : " + isSorted((Comparable[]) a, 0, N-1));
        for (int i = 0; i < N; i++) { // i: destination site
            int min = i; // index of minimum candidate
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j; // better minimum candidate found
                }
            }
            // now min is the index of the minimum
            exch(a, i, min);
        }
        System.out.println("Insertion, is sorted after sorting? : " + isSorted((Comparable[]) a, 0, N-1));
    }
}
