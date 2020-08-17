public class SinglyLinkedList<E> {
    /* nested Node class
        -> Strong encapsulation, internal implementation of nodes is hidden from the outside.
        -> Easy to differentiate this node type from nodes used in other classes or structures.
     */
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null; // head node of the list (null if empty)
    private Node<E> tail = null; // tail node of the list (null if empty)
    private int size = 0;        // Number of nodes in the list
    public SinglyLinkedList() {} // Constructor, creates an empty list when instantiated

    // Accessor methods
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {
        if(isEmpty())
            return null;
        return head.getElement();
    }
    public E last() {
        if(isEmpty())
            return null;
        return tail.getElement();
    }

    // Mutator methods
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if(size == 0)
            tail = head;
        size++;
    }
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if(isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
    public E removeFirst() {
        if(isEmpty())
            return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if(size == 0)
            tail = null;
        return answer;
    }
}