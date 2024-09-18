package restart.lld.DesignPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

// Client code using the iterator
public class IteratorDesignPattern {
    public static void main(String[] args) {
        NumberList numberList = new NumberList();
        numberList.addNumber(1);
        numberList.addNumber(2);
        numberList.addNumber(3);

        // Obtain the iterator to traverse the collection
        Iterator<Integer> iterator = numberList.createIterator();

        // Use the iterator to print each element
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}