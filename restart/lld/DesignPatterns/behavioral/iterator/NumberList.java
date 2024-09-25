package restart.lld.DesignPatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

// Concrete collection implementation
class NumberList implements IterableCollection<Integer> {
    private List<Integer> numbers = new ArrayList<>();

    // Adds an element to the collection
    public void addNumber(int number) {
        numbers.add(number);
    }

    // Returns an iterator for the collection
    @Override
    public Iterator<Integer> createIterator() {
        return new ListIterator<>(numbers);
    }
}
