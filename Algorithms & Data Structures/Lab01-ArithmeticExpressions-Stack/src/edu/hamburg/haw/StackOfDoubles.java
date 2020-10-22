package edu.hamburg.haw;

public class StackOfDoubles {
    private double[] stackArray;
    private int N = 0;

    public StackOfDoubles() {
        this(1);
    }

    public StackOfDoubles(int capacity) {
        stackArray = new double[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(double newDouble) {
        if(N >= stackArray.length) {
            resize(stackArray.length * 2);
        }
        stackArray[N++] = newDouble;
    }

    public double pop() {
        double result = stackArray[--N];
        if(N == stackArray.length / 4) {
            resize(stackArray.length / 2);
        }
        return result;
    }

    private void resize(int capacity) {
        double[] newArray = new double[capacity];
        for(int i = 0; i < N; i++) {
            newArray[i] = stackArray[i];
        }
        stackArray = newArray;
    }
}
