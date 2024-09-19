# Inheritance

Inheritance represents an **"is-a"** relationship. It allows a class to inherit properties and behaviors from another class, typically for sharing common functionality.

## Key Points:
1. **Reusability**: Inheritance promotes code reuse by allowing a subclass to inherit methods and fields from its superclass.
2. **Hierarchy**: It creates a hierarchy of classes, where derived classes specialize or extend the behavior of a base class.
3. **Tight coupling**: Subclasses are tightly coupled to their base class, meaning any change in the base class may affect the subclass.
4. **Polymorphism**: Inheritance enables polymorphism, allowing objects of derived classes to be treated as objects of the base class.

## Example in Java:

```java
// Parent class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes sound");
    }
}

// Child class inherits from Animal
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();  // Outputs: Dog barks
    }
}
```
### **When to Use:**
- When there is a clear is-a relationship between classes (e.g., Dog is an Animal).
- When you want to extend or modify the behavior of a class without rewriting the existing logic.