package restart.lld.DesignPatterns.iterator;

import java.util.List;

// Concrete Iterator implementation for a list
class ListIterator<T> implements Iterator<T> {
    private List<T> list;  // Reference to the collection
    private int position = 0;  // Track current position

    public ListIterator(List<T> list) {
        this.list = list;  // Initialize with the collection to be traversed
    }

    @Override
    public boolean hasNext() {
        return position < list.size();  // True if elements remain
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            return list.get(position++);  // Return next element, then increment position
        }
        return null;
    }
}
