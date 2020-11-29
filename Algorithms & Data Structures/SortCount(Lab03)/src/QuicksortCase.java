/**
 * UseCase for Quicksort.
 *
 * @author Yuriel
 * @version 29.11.2020.
 */
public class QuicksortCase extends UseCase {
    /**
     * Constructor for objects of class QuicksortCase.
     */
    public QuicksortCase(InputCase inputCase, int size) {
        super(inputCase, size);
    }

    @Override
    public String toString() {
        return "Quicksort, " + super.toString();
    }

    public void sortAndCount() {
        Quicksort.sort(arr);
        comp = Insertion.getCompares();
        copy = Insertion.getCopies();
    }
}