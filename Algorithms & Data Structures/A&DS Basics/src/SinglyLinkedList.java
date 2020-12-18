public class SinglyLinkedList<E> implements Cloneable {
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

    @Override
    public boolean equals(Object o) {
        if(o == null)                  // Null check of "o".
            return false;
        if(getClass() != o.getClass()) // Check if the two instances are of the same class.
            return false;

        // Use nonparameterized type; with "TYPE ERASURE" it is impossible to detect at runtime if lists have same type.
        SinglyLinkedList other = (SinglyLinkedList) o;
        if(size != other.size)
            return false;

        Node walkA = head;       // To traverse the current list.
        Node walkB = other.head; // To traverse the second list, "o".

        while(walkA != null) {
            if(!walkA.getElement().equals(walkB.getElement())) // If two lists have incompatible types, detected HERE.
                return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // Always use the inherited Object.clone() to create the initial shallow copy
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();

        if(size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;

            while(walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }

        return other;
    }
}