public class DoublyLinkedList<E> {
    /* nested Node class
    -> Strong encapsulation, internal implementation of nodes is hidden from the outside.
    -> Easy to differentiate this node type from nodes used in other classes or structures.
 */
    private static class Node<E> {
        private E element;    // Reference to the element stored at this node.
        private Node<E> prev; // Reference to the previous node in the list.
        private Node<E> next; // Reference to the subsequent node in the list.

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }
        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setPrev(Node<E> p) {
            prev = p;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    /* Sentinel (a.k.a. guard) nodes
        -> One "header" node preceding the first element in the linked list,
                & one "trailer" node following the last element in the linked list.
        -> All insertions and deletions can be handled in the same way,
                because every node will always be added and removed from in between two preexisting nodes.
     */
    private Node<E> header;  // Header sentinel.
    private Node<E> trailer; // Trailer sentinel.
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null); // Create header.
        trailer = new Node<>(null, header, null); // Trailer is preceded by trailer.
        header.setNext(trailer);                        // Header is followed by trailer.
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public E first() {
        if(isEmpty())
            return null;
        return header.getNext().getElement(); // First element is right after the header.
    }
    public E last() {
        if(isEmpty())
            return null;
        return trailer.getPrev().getElement(); // Last element is right before the trailer.
    }

    // Public mutator methods
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }
    public E removeFirst() {
        if(isEmpty())
            return null;
        return remove(header.getNext());
    }
    public E removeLast() {
        if(isEmpty())
            return null;
        return remove(trailer.getPrev());
    }

    // Private mutator methods
    // Adds element "e" to the linked list in between the given nodes, "predecessor" and "successor".
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    // Removes the given node "node" from the list and returns its element.
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}
