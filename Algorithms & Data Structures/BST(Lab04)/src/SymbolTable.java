import java.util.Iterator;

public interface SymbolTable<Key extends Comparable<Key>, Value> {
    void put(Key key, Value val);

    Value get(Key key);

    boolean contains(Key key);

    void remove(Key key);

    Iterator<Key> iterator();
}
