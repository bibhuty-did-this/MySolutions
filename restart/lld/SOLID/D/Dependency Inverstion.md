# Dependency Inversion Principle (DIP)

> The way you implement Open-Closed Principle is Dependency Inversion

The **Dependency Inversion Principle (DIP)** is one of the five SOLID principles of object-oriented design. It states:

> **"High-level modules should not depend on low-level modules. Both should depend on abstractions."**
>
> **"Abstractions should not depend on details. Details should depend on abstractions."**

The goal of DIP is to reduce the coupling between high-level and low-level components by making both depend on abstractions (interfaces or abstract classes), not on concrete implementations.

## Key Concepts:
- **High-level modules**: These contain business logic and should not be dependent on low-level modules that handle implementation details (like database operations).
- **Low-level modules**: These are more detailed, specific classes that handle technical implementation.
- **Abstractions**: Interfaces or abstract classes that define a contract which both high-level and low-level modules depend upon.
- **Loose Coupling**: The system becomes more flexible and easier to maintain because the high-level modules are not tightly coupled with the low-level implementations.

## Example Without DIP:

### Problem:
In this example, `FrontEndDeveloper` and `BackEndDeveloper` are low-level modules, and `Project` is a high-level module directly depending on these low-level modules.

```java
class FrontEndDeveloper {
    public void writeJavaScript() {
        System.out.println("Writing JavaScript");
    }
}

class BackEndDeveloper {
    public void writeJava() {
        System.out.println("Writing Java");
    }
}

class Project {
    private FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper();
    private BackEndDeveloper backEndDeveloper = new BackEndDeveloper();

    public void implement() {
        frontEndDeveloper.writeJavaScript();
        backEndDeveloper.writeJava();
    }
}
```
In this setup, the `Project` class is tightly coupled to the specific implementations of `FrontEndDeveloper` and `BackEndDeveloper`. If we want to add or modify developer roles (e.g., a mobile developer), we need to change the Project class, violating DIP.

### Example Using DIP:

#### Solution:

We introduce an abstraction (Developer) that both high-level and low-level modules depend on:

```java
// Abstraction
interface Developer {
    void develop();
}

// Low-level module 1
class FrontEndDeveloper implements Developer {
    @Override
    public void develop() {
        writeJavaScript();
    }

    private void writeJavaScript() {
        System.out.println("Writing JavaScript");
    }
}

// Low-level module 2
class BackEndDeveloper implements Developer {
    @Override
    public void develop() {
        writeJava();
    }

    private void writeJava() {
        System.out.println("Writing Java");
    }
}

// High-level module
class Project {
    private List<Developer> developers;

    public Project(List<Developer> developers) {
        this.developers = developers;
    }

    public void implement() {
        developers.forEach(Developer::develop);
    }
}
```
Now, the `Project` class is dependent on the abstraction `Developer`, not on the specific implementations of developers. This makes the design more flexible. Adding a new type of developer (e.g., `MobileDeveloper`) would not require changes to the `Project` class.

## Advantages:

1. **Loose Coupling**: High-level and low-level modules are loosely coupled, improving the flexibility and maintainability of the code.
2. **Scalability**: The system can grow by adding new modules (e.g., developers) without affecting the high-level modules.
3. **Easier to Test**: Dependency on abstractions allows for easier unit testing by mocking the interfaces.

## Disadvantages:

1. **Increased Complexity**: Applying DIP can introduce additional complexity by requiring more interfaces or abstractions.
2. **Over-Abstraction**: Overuse of this principle can lead to too many layers of abstraction, making the code more difficult to understand.

## When to Use DIP:

- When the high-level modules (business logic) depend on the low-level modules (implementation details).
- When you anticipate frequent changes in low-level implementations, requiring high-level modules to remain stable.

## When Not to Use DIP:

- In small projects where adding abstractions adds unnecessary complexity.
- When low-level implementation changes are unlikely, and the system design is stable and not expected to grow.
