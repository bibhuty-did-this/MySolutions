## Flyweight Design Pattern

**Definition:** The Flyweight Design Pattern is used to minimize memory usage by sharing as many data as possible with similar objects. It is particularly useful when dealing with a large number of objects with similar state or behavior.

**Purpose:**
- To reduce the number of objects created and to efficiently share objects.
- To minimize memory usage and improve performance when dealing with a large number of objects.

**Components:**
1. **Flyweight:** Interface or abstract class that defines the methods for the flyweight objects.
2. **ConcreteFlyweight:** Implements the Flyweight interface and maintains the intrinsic state (shared state).
3. **FlyweightFactory:** Manages the creation and storage of flyweight objects. It ensures that flyweight objects are shared properly.
4. **Client:** Uses the flyweight objects and maintains the extrinsic state (non-shared state) of the objects.

**Advantages:**
1. **Reduced Memory Usage:** By sharing flyweight objects, you can significantly reduce memory usage.
2. **Improved Performance:** Minimizes the overhead of creating and managing a large number of similar objects.
3. **Flexibility:** Flyweights can be shared and managed efficiently, allowing for more flexible and scalable designs.

**Disadvantages:**
1. **Complexity:** The pattern introduces additional complexity due to the need to manage shared and non-shared states.
2. **Increased Indirection:** The flyweight pattern can add indirection, making the code harder to understand and maintain.

**When to Use the Flyweight Pattern:**
- When you need to manage a large number of similar objects and want to optimize memory usage.
- When many objects have similar state and behavior and can be shared.
- When you need to improve performance by reducing the overhead of object creation.

**When Not to Use the Flyweight Pattern:**
- When objects have unique states or behaviors that cannot be shared effectively.
- When the added complexity of managing shared and non-shared states outweighs the benefits.

**Example:**

```java
import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface TreeType {
    void draw(int x, int y);
}

// ConcreteFlyweight
class ConcreteTreeType implements TreeType {
    private String name;

    public ConcreteTreeType(String name) {
        this.name = name;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing tree of type " + name + " at (" + x + ", " + y + ")");
    }
}

// FlyweightFactory
class TreeFactory {
    private Map<String, TreeType> treeMap = new HashMap<>();

    public TreeType getTreeType(String name) {
        if (!treeMap.containsKey(name)) {
            treeMap.put(name, new ConcreteTreeType(name));
        }
        return treeMap.get(name);
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        TreeFactory factory = new TreeFactory();
        
        TreeType oak = factory.getTreeType("Oak");
        TreeType pine = factory.getTreeType("Pine");
        
        oak.draw(10, 20);
        pine.draw(30, 40);
        oak.draw(50, 60);
    }
}
```
**Explanation:**

- **Flyweight:** `TreeType` interface defines the methods for the flyweight objects.
- **ConcreteFlyweight:** `ConcreteTreeType` implements `TreeType` and maintains the intrinsic state (the type of tree).
- **FlyweightFactory:** `TreeFactory` manages the creation and sharing of `TreeType` objects.
- **Client:** Uses `TreeFactory` to get and use shared `TreeType` objects.