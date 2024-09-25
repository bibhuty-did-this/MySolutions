package restart.lld.DesignPatterns.behavioral.iterator;

// Collection interface that allows returning an iterator
interface IterableCollection<T> {
    Iterator<T> createIterator();  // Create and return an iterator for the collection
}
