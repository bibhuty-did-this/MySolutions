package restart.lld.DesignPatterns.behavioral.iterator;

// Iterator interface defines basic methods to traverse the collection
interface Iterator<T> {
    boolean hasNext();  // Check if there are more elements

    T next();           // Fetch the next element
}
