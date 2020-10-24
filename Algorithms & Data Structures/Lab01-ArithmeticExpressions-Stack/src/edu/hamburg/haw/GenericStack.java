package edu.hamburg.haw;

import java.util.LinkedList;

public class GenericStack<T> {
    private class Node {
        T item;
        Node next;
    }
    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
    }

    public T pop() {
        T result = first.item;
        first = first.next;
        return result;
    }
}