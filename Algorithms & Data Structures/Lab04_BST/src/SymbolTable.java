import java.util.Iterator;

/**
 * Interface defining several methods that must be implemented by a symbol table.
 * Implementing classes: BST, RedBlackBST
 */
public interface SymbolTable<Key extends Comparable<Key>, Value> {
    void put(Key key, Value val);

    Value get(Key key);

    boolean contains(Key key);

    void remove(Key key);

    Iterator<Key> iterator();
}
