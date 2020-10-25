package edu.hamburg.haw;

/**
 * A custom stack implementation using an array of doubles.
 * @author Yuriel
 * @version 25.10.2020.
 */
public class StackOfDoubles {
    private double[] stackArray;
    private int N = 0;

    /**
     * Default constructor, creates a stack with size 1.
     */
    public StackOfDoubles() {
        this(1);
    }

    /**
     * Constructor, creates a stack with the designated size.
     * @param capacity The desired capacity (size) of the new stack.
     */
    public StackOfDoubles(int capacity) {
        stackArray = new double[capacity];
    }

    /**
     * Checks if the stack is empty.
     * @return True if the stack is empty, false if not.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * Pushes a double value to the stack.
     * Array is resized as necessary.
     * @param newDouble The double to push to the stack.
     */
    public void push(double newDouble) {
        if(N >= stackArray.length) {
            resize(stackArray.length * 2);
        }
        stackArray[N++] = newDouble;
    }

    /**
     * Pops a double value from the stack.
     * Resizes the array to half its previous size when the current array is using only 25% of its full capacity.
     * @return The double value popped from the stack.
     */
    public double pop() {
        double result = stackArray[--N];
        if(!isEmpty() && N <= (double) stackArray.length / 4) {
            resize(stackArray.length / 2);
        }
        return result;
    }

    /**
     * Resizes the stack (i.e. internal array) and copies the items of the previous stack to the new one.
     * @param capacity The desired size of the new array.
     */
    private void resize(int capacity) {
        double[] newArray = new double[capacity];
        for(int i = 0; i < N; i++) {
            newArray[i] = stackArray[i];
        }
        stackArray = newArray;
    }
}
