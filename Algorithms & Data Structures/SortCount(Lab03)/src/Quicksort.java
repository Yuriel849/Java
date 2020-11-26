/**
 * Class Quicksort from Sedgewick.
 *
 * @author Yuriel
 * @version 19.11.2020.
 */
public class Quicksort extends Sort {
    // Comparable is a raw type. References to generic type Comparable<T> should be parameterized
    public static void sort(Object[] a) {
        reset();
        int N = a.length;
        System.out.println("Quicksort, is sorted before sorting? : " + isSorted(a, 0, N-1));
        sort(a, 0, N - 1);
        System.out.println("Quicksort, is sorted before sorting? : " + isSorted(a, 0, N-1));
    }

    private static void sort(Object[] a, int l, int r) {
        if(r <= l) return;
        int m = partition(a, l, r);
        assert isPartitioned(a, l, m, r);
        sort(a, l, m-1);
        sort(a, m+1, r);
    }

    private static int partition(Object[] a, int l, int r) {
        int i = l - 1;
        int j = r;

        while(true) {
            while(less(a[++i], a[r]))
                if(i == r) break;
            while(less(a[r], a[--j]))
                if(j == l) break;
            if(i >= j) break;
            exch(a, i, j);
        }

        exch(a, i, r);
        return i;
    }
}