# Composition

Composition represents a **"has-a"** relationship. It means that a class contains an instance of another class and delegates tasks to it, rather than inheriting from it.

## Key Points:
1. **Flexibility**: Composition is more flexible than inheritance because the composed object can be replaced at runtime.
2. **Loose coupling**: It allows for loose coupling, as changes in one class typically don't affect the other.
3. **Reusability**: You can reuse classes by composing them together rather than relying on a rigid inheritance hierarchy.
4. **Delegation**: Composition relies on delegation, where one object delegates certain responsibilities to another.

## Example in Java:

```java
// Class for Engine
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

// Class for Car
class Car {
    private Engine engine;  // Car "has-a" Engine

    public Car() {
        this.engine = new Engine();  // Car is composed of an Engine
    }

    public void startCar() {
        engine.start();  // Delegating the start operation to the engine
        System.out.println("Car started");
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();  // Outputs: Engine started, Car started
    }
}
```

### **When to Use:**
- When there is a has-a relationship (e.g., Car has an Engine).
- When you need more flexibility and want to avoid tight coupling between classes.
- When the behavior you are modeling can change or needs to be easily extended.

## Key Differences

| **Feature**              | **Inheritance**                             | **Composition**                            |
|--------------------------|---------------------------------------------|--------------------------------------------|
| **Relationship**          | "is-a" (Dog is an Animal)                   | "has-a" (Car has an Engine)                |
| **Coupling**              | Tight coupling                             | Loose coupling                            |
| **Reusability**           | Shares code through hierarchy               | Shares code through delegation            |
| **Flexibility**           | Less flexible due to hierarchy constraints  | More flexible; components can be swapped   |
| **Changes Impact**        | Changes in the base class affect subclasses | Changes in one class don’t affect the other|
| **Use Case**              | Use when classes share common behavior      | Use when objects work together to provide functionality |
| **Polymorphism**          | Enables polymorphism                       | Can be achieved through interfaces         |

## General Rule of Thumb:
- **Favor composition over inheritance** when possible, as it leads to more modular, maintainable, and flexible code.
- Use **inheritance** when there is a clear and logical "is-a" relationship, and when subclassing genuinely extends the base class without unnecessary complexity.