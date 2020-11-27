/**
 *  This class UseCase is for demonstration only!
 *  It shows how to use enum in switch/case, loop over it's values and its name printing.
 *
 * @author Wolfgang Renz, HAW Hamburg 
 * @version Nov. 14, 2020
 */
public abstract class UseCase {
    public static final int kmax= 13;
    public static final int Nmax= (int) Math.round(Math.pow(2, kmax));
    public static final int M= 20;  // sample size
    public static Integer[] arr;

    // instance variables:
    private InputCase inputCase;
    private int size;
    private int iterations; // for averaging a sample
    protected int comp, copy; // results to be written by sub-class

    abstract void sortAndCount();

    protected UseCase(InputCase inputCase, int size) {
        // initialise instance variables
        this.size = size;
        this.inputCase= inputCase;
        arr = new Integer[size];
        if (inputCase == InputCase.AVG) {
            iterations = M;
        } else {
            iterations= 1;
        }

        switch(inputCase) {
            case SORTED:
                initAscending();
                break;
            case REVERSE:
                initDescending();
                break;
            case RANDOM:
            case AVG:
                initRandom();
                break;

            default:
                ;
        }
    }

    @Override
    public String toString() {
        return inputCase + " case for size " + size + ":";
    }

    String getResults(String format) {
        sortAndCount();
        String results;
        // do the formatting job !
        results = " " + comp + " " + copy + " " + format; // for demo only
        return results;
    }

    public void writeResults(String format) {
        System.out.print (size + " "); // first part of suitable format
        format= format.substring(0);   // skip part consumed
        System.out.println(getResults(format));
    }

    public static void makeTable(String sortCase) {
        for (InputCase tableCase: InputCase.values()) {
            int N=1;
            System.out.println(tableCase + " case:");
            System.out.println("Formatted Columns Header: N, #(cmp), #(cmp)");
            String format= "suitable format";
            for(int k=1; k<=kmax; k++) {
                N*= 2;
                UseCase usecase = null;
                switch(sortCase) {
                    case "SortCase": usecase= new SortCase(tableCase, N); break;
                    case "InsertionCase": usecase= new InsertionCase(tableCase, N); break;
                }
                // check for all sort cases and instantiate them accordingly!
                if(usecase != null) {
                    usecase.writeResults(format);
                }
            }
        }
    }

    private void initAscending() {
        initRandom();
        Insertion.sort(arr);
    }

    private void initDescending() {
        initRandom();
        Insertion.reverseSort(arr);
    }

    private void initRandom() {
        for(int i = 0; i < size; i++)
            arr[i] = (int) (Math.random() * size * 3);
    }

    public static void main(String arg [] ) {
        makeTable("InsertionCase");

        System.out.println("\nFor testing use single use cases like this:\n");
        UseCase usecase = new InsertionCase( InputCase.REVERSE, 4);
        System.out.println(usecase + usecase.getResults("... formatted"));

    }
}