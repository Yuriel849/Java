import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the sort method in the Insertion class.
 * Checks that the number of copy and comparison operations in the algorithm
 * matches the theoretically expected number of operations.
 */
class InsertionTest {
    @Test
    void sort() {
        int N = 4;

        int cmp = 3; // Theoretical value for compare (N - 1)
        int cpy = 0; // Theoretical value for copy 0

        Records records = new Records(N);
        records.shuffle();
        records.insertionSort();
        assertEquals(cmp, Sort.getCompares());
        assertEquals(cpy, Sort.getCopies());
    }
}