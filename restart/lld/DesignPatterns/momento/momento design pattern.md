# Memento Design Pattern

The **Memento Design Pattern** is a behavioral design pattern that provides the ability to restore an object to its previous state. This is useful when you need to implement undo functionality or maintain history of changes in an object without exposing its internal structure.

## Participants in the Memento Pattern:

1. **Originator**: The object whose state is being saved and restored.
2. **Memento**: An object that stores the state of the `Originator`. It is an opaque object, meaning that only the `Originator` can access its contents.
3. **Caretaker**: Manages the mementos. It requests the `Originator` to save its state and can request the `Originator` to restore a previous state.

## Structure of Memento Pattern:

- The **Originator** creates a `Memento` containing a snapshot of its current state.
- The **Caretaker** is responsible for keeping track of mementos, typically in a stack or a list.
- The **Originator** can revert to a previous state by using the `Memento`.

## Example:

### Memento Class:
```java
// Memento
public class Memento {
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator
public class Originator {
    private String state;

    public void setState(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
        System.out.println("Originator: State restored from Memento: " + state);
    }
}

// Caretaker
public class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State #1");
        originator.setState("State #2");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        caretaker.add(originator.saveStateToMemento());

        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("First saved State: " + originator.getState());

        originator.getStateFromMemento(caretaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
```

### Advantages

1. **Encapsulation**: The internal state of the Originator is not exposed to other objects, keeping it encapsulated.
2. **Undo Functionality**: The Memento pattern is useful for implementing undo and redo features.
3. **History Maintenance**: You can maintain a history of object states for restoration at any point.

### Disadvantages

1. **Memory Usage**: Storing multiple states might consume significant memory, especially if the state is large or changes frequently.
2. **Complexity**: Managing and keeping track of multiple mementos can become complex, especially if there are many objects or frequent state changes.

### When to Use the Memento Pattern

- When you need to provide undo functionality for your application.
- When the internal state of an object needs to be saved and restored without exposing its internals to other classes.
- When you want to maintain snapshots of an object’s state history.

### When Not to Use the Memento Pattern

- When the state information is large, as storing multiple mementos can become inefficient in terms of memory.
- When undo functionality is not required, as adding the Memento pattern introduces unnecessary complexity.

