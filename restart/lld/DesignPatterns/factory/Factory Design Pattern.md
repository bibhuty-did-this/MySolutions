## Factory Design Pattern

**Definition:** The Factory Design Pattern provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. It encapsulates the object creation process, allowing the creation of objects without exposing the instantiation logic to the client.

**Purpose:**
- To define an interface for creating objects, but let subclasses or concrete classes decide which class to instantiate.
- To promote loose coupling by eliminating the need for clients to know the exact class being instantiated.

**Components:**
1. **Product (Interface/Abstract Class):** Defines the interface for objects that the factory method creates.
2. **Concrete Products:** Classes that implement the `Product` interface.
3. **Creator (Factory Class):** Declares the factory method, which returns an object of type `Product`. It may also contain some default implementation.
4. **Concrete Creators:** Subclasses of `Creator` that override the factory method to return instances of `Concrete Products`.

**Advantages:**
1. **Encapsulation of Object Creation:** The factory method encapsulates the creation of objects, removing the responsibility from the client.
2. **Loose Coupling:** The client is decoupled from the specific classes it needs to instantiate, promoting flexibility.
3. **Scalability:** New products can be added by introducing new concrete product classes without changing the client code.

**Disadvantages:**
1. **Increased Complexity:** The pattern introduces additional classes and methods, which can increase the overall complexity of the code.
2. **May Introduce Subclassing:** In some cases, you may need to subclass the creator class to create new types of objects, leading to a proliferation of classes.

**When to Use the Factory Pattern:**
- When the exact type of objects the system must create is determined at runtime.
- When you want to delegate the responsibility of creating objects to a specific class.
- When you need to centralize or control the object creation process to make it more flexible and scalable.

**When Not to Use the Factory Pattern:**
- When the creation process is simple and does not require any specialized logic or different types of objects.
- When there is no significant need for flexibility or future changes in the object creation process.

**Example:**

```java
// Product interface
interface Shape {
    void draw();
}

// Concrete Product: Circle
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concrete Product: Rectangle
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Factory class
class ShapeFactory {
    // Factory method
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Create a Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // Create a Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}
```

**Explanation:**

- **Product (Shape Interface):** Defines the method `draw` that concrete products must implement.
- **Concrete Products (Circle, Rectangle):** Implement the `Shape` interface and provide specific implementations of the `draw` method.
- **Factory (ShapeFactory):** Provides a method `getShape` that returns instances of the `Shape` interface based on input.
- **Client:** The client code uses the `ShapeFactory` to create objects without needing to know the exact class being instantiated.
## Difference between Factory and Builder Design Patterns

| Feature                      | Factory Pattern                                          | Builder Pattern                                           |
|------------------------------|----------------------------------------------------------|-----------------------------------------------------------|
| **Purpose**                   | Simplifies object creation by encapsulating the process of creating objects based on some criteria | Simplifies the construction of complex objects by allowing step-by-step construction with different configurations |
| **Object Complexity**         | Best suited for creating simple or moderately complex objects | Best suited for creating complex objects that require multiple construction steps or configurations |
| **Focus**                     | Focuses on determining which class to instantiate based on input or conditions | Focuses on how to construct a complex object with many optional parameters |
| **Return Type**               | Factory methods return different types of objects (could be subclasses or implementations of an interface) | Builder returns a single complex object, often with various configurations |
| **Flexibility in Creation**   | Limited flexibility as it typically returns predefined types of objects | Highly flexible, allowing for gradual construction of an object with multiple customizable options |
| **Handling Multiple Variants**| Creates variants of objects through subclasses | Creates variations of a single object through different configurations without using subclasses |
| **Construction Process**      | The entire object is created in one step through the factory method | Object is created in multiple steps with the builder, providing more control over the construction process |
| **When to Use**               | When the object creation is simple but involves decision-making based on input | When an object has a large number of fields or parameters and needs to be created step by step |
| **Example Use Cases**         | Shape Factory, Connection Factory, Logger Factory | Building a house, constructing a car, setting up a complex user configuration |

### Summary:

- **Factory Pattern** is ideal when you need to create objects based on input or logic that determines the type of object, but the construction process itself is relatively simple.
- **Builder Pattern** is ideal for constructing complex objects where many configuration options are required, and the creation process benefits from being broken down into discrete steps.