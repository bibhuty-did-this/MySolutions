## State Design Pattern

**Definition:** The State Design Pattern allows an object to change its behavior when its internal state changes. It enables an object to alter its behavior dynamically at runtime based on its current state, without changing its class.

**Purpose:**
- To allow an object to change its behavior when its state changes.
- To encapsulate state-specific behavior within different state classes, making the object more flexible and easier to maintain.

**Components:**
1. **Context:** The object whose behavior varies based on its state. It maintains a reference to an instance of a `State` subclass.
2. **State:** An interface or abstract class defining the methods that all concrete state classes must implement.
3. **Concrete State Classes:** Implementations of the `State` interface that define the specific behavior for each state.

**Advantages:**
1. **Simplifies Complexity:** Encapsulates state-specific behavior, making the code cleaner and easier to maintain.
2. **Extensibility:** New states can be easily added by defining new concrete state classes without modifying the context.
3. **Avoids Conditionals:** Removes the need for complex `if-else` or `switch` statements, as each state class handles its own logic.

**Disadvantages:**
1. **Increased Number of Classes:** The pattern requires the creation of multiple concrete state classes, which can lead to an increase in class count.
2. **Context-State Coupling:** The context must be aware of the different states, which can increase coupling between the context and state classes.

**When to Use the State Pattern:**
- When an object’s behavior depends on its state, and it needs to change its behavior dynamically at runtime.
- When you want to avoid large `if-else` or `switch-case` statements that handle state-specific behavior.
- When you have an object that has many possible states and different behavior associated with each state.

**When Not to Use the State Pattern:**
- When an object has few states, and state transitions are simple, the added complexity of the pattern may not be justified.
- When the behavior of an object does not change based on its state.

**Example:**

```java
// State interface
interface State {
    void handleRequest();
}

// ConcreteStateA
class ConcreteStateA implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in State A");
    }
}

// ConcreteStateB
class ConcreteStateB implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in State B");
    }
}

// Context
class Context {
    private State currentState;

    public Context() {
        this.currentState = new ConcreteStateA();  // Default state
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void request() {
        this.currentState.handleRequest();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        // Initially in State A
        context.request();

        // Change state to State B
        context.setState(new ConcreteStateB());
        context.request();
    }
}
```
**Explanation:**

- **Context:** The `Context` class holds a reference to a `State` object and delegates state-specific behavior to this object.
- **State Interface:** The `State` interface defines the method (`handleRequest`) that concrete states must implement.
- **ConcreteStateA and ConcreteStateB:** These are concrete implementations of the `State` interface, each defining behavior specific to that state.
- **Client:** The client code creates a `Context` object and changes its state dynamically by invoking the `setState` method.