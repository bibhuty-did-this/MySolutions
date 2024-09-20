## Proxy Design Pattern

### Definition

The Proxy Design Pattern provides a surrogate or placeholder object to control access to another object. It allows you to act as an intermediary between a client and a real object.

### Types of Proxies

1. **Virtual Proxy**: Controls access to a resource that is expensive to create. It delays the creation of the resource until it's actually needed.
2. **Remote Proxy**: Represents an object that is in a different address space, often used in distributed systems to represent objects on remote servers.
3. **Protection Proxy**: Controls access to an object based on permissions or other criteria. It can enforce access control rules.
4. **Cache Proxy**: Caches results from expensive operations to improve performance by reusing previously fetched results.

### Advantages

1. **Control Access**: Provides a way to control access to the real object and manage its lifecycle.
2. **Lazy Initialization**: Delays the creation or initialization of expensive objects until they are actually needed (Virtual Proxy).
3. **Remote Access**: Facilitates communication between objects on different machines or address spaces (Remote Proxy).
4. **Access Control**: Enforces access control or permissions (Protection Proxy).

### Disadvantages

1. **Increased Complexity**: Adds another layer of abstraction, which can make the system more complex.
2. **Performance Overhead**: Introduces additional overhead due to the indirection, which may impact performance.

### When to Use the Proxy Pattern

- When you need to control access to an object and manage its creation or lifecycle.
- When you want to add additional functionality, such as caching or access control, without changing the real object.
- When you are working with distributed systems and need to represent objects on remote servers.

### When Not to Use the Proxy Pattern

- When the added complexity of the proxy is not justified by the benefits it provides.
- When the overhead of indirection impacts the performance critically, and a direct reference to the real object is more efficient.
```java
// Subject interface
interface Image {
    void display();
}

// RealSubject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImage();
    }

    private void loadImage() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");
        image.display();  // Image is loaded and displayed
        image.display();  // Image is only displayed (loaded once)
    }
}
```

### Comparison

| Feature               | Proxy Pattern                          | Prototype Pattern                       |
|-----------------------|----------------------------------------|----------------------------------------|
| **Purpose**           | Controls access to an object or adds functionality | Creates new objects by cloning a prototype |
| **Object Creation**   | Uses an intermediary object to control or manage access | Creates new instances by cloning an existing object |
| **Use Cases**         | Access control, caching, remote communication | Object creation efficiency, avoiding complex construction |
| **Object Copying**    | Not typically involved in copying objects | Involves copying or cloning objects   |
| **Complexity**        | Adds a layer of indirection and control | Simplifies object creation by cloning |