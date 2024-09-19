# Liskov Substitution Principle (LSP)

The **Liskov Substitution Principle (LSP)** is one of the five SOLID principles of object-oriented design. It states:

> **"Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program."**

In other words, if class `B` is a subclass of class `A`, then objects of type `A` should be replaceable with objects of type `B` without altering the behavior or introducing errors into the system.

## Key Concepts:
- **Behavioral consistency**: Subclasses should behave in a way that does not violate the expectations set by the superclass. If a method of the superclass is called on the subclass, the result should be as expected without needing to know the internal details of the subclass.
- **Contracts**: Subclasses should honor the "contract" of the base class, meaning they shouldn't override the behavior in a way that violates what users of the superclass expect.

## Violating LSP

You violate LSP when:
- Subclasses change the behavior of inherited methods in a way that breaks the functionality expected by the base class.
- You need to perform checks for specific types of subclasses before invoking a method, which introduces type dependency.

### Example (Violation):

```java
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
```
In this case, Penguin is a subclass of Bird, but Penguin does not meet the expectations set by the Bird class. Any code expecting a Bird to fly would break when given a Penguin, violating LSP.
### Example (Correct Example):
```java
class Bird {
    public void move() {
        System.out.println("Bird is moving");
    }
}

class Sparrow extends Bird {
    @Override
    public void move() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void move() {
        System.out.println("Penguin is swimming");
    }
}
```
Here, Penguin doesn’t violate the LSP because we changed the method to move() instead of fly(). Now, both Sparrow and Penguin have different behaviors for movement, but neither breaks the expected functionality. The principle is honored because all Birds can “move” in some way.

### Summary:
LSP ensures that derived classes extend the behavior of base classes in a way that does not break client code. This principle helps maintain a clean, scalable, and maintainable codebase.