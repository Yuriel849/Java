/**
 * @author Yuriel
 * @version 27.11.2020.
 */
public class InsertionCase extends UseCase {
    /**
     * Constructor for objects of class InsertionCase.
     */
    public InsertionCase(InputCase inputCase, int size) {
        super(inputCase, size);
    }

    @Override
    public String toString() {
        return "Insertion sort, " + super.toString();
    }

    public void sortAndCount() {
        Insertion.sort(arr);
        comp = Insertion.getCompares();
        copy = Insertion.getCopies();
    }
}