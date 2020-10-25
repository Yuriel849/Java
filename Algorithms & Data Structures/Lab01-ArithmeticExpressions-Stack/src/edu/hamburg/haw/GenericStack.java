package edu.hamburg.haw;

import java.util.LinkedList;

/**
 * A custom stack implementation using generics and a linked list implementation.
 * @author Yuriel
 * @version 25.10.2020.
 */
public class GenericStack<T> {
    private class Node {
        T item;
        Node next;
    }
    private Node first = null;

    /**
     * Checks if the stack is empty.
     * @return True if the stack is empty, false if not.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Pushes an item to the stack.
     * @param item The item to push to the stack.
     */
    public void push(T item) {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
    }

    /**
     * Pops an item from the stack.
     * @return The item popped from the stack.
     */
    public T pop() {
        T result = first.item;
        first = first.next;
        return result;
    }
}