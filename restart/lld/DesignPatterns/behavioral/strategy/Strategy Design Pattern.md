## Strategy Design Pattern

**Definition:** The Strategy Design Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. The strategy pattern lets the algorithm vary independently from the clients that use it.

**Purpose:**
- To enable selecting an algorithm's behavior at runtime by defining a set of algorithms and making them interchangeable.
- To separate the algorithm implementation from the context that uses it, promoting loose coupling and flexibility.

**Components:**
1. **Strategy (Interface):** Defines an interface common to all supported algorithms. Context uses this interface to call the algorithm defined by a `ConcreteStrategy`.
2. **ConcreteStrategy:** Implements the algorithm using the `Strategy` interface.
3. **Context:** Maintains a reference to a `Strategy` object and can switch between different strategies.

**Advantages:**
1. **Open/Closed Principle:** You can introduce new strategies without changing the context or client code.
2. **Avoids Conditionals:** Replaces complex conditionals (if-else or switch statements) with a cleaner strategy-based implementation.
3. **Interchangeability:** Strategies can be switched at runtime, providing flexibility.
4. **Encapsulation of Algorithms:** Algorithms are encapsulated in their own classes, which simplifies testing and maintenance.

**Disadvantages:**
1. **Increased Number of Classes:** Each algorithm requires its own class, which can lead to more classes and code complexity.
2. **Client Awareness:** The client needs to be aware of different strategies to switch between them, which might add some responsibility to the client.

**When to Use the Strategy Pattern:**
- When you have different algorithms for a specific task, and you want the ability to change them dynamically at runtime.
- When you want to eliminate conditional statements that select different algorithms based on specific conditions.
- When multiple classes differ only in their behavior, and you can extract the differing behavior into separate strategy classes.

**When Not to Use the Strategy Pattern:**
- When there are too few variations of the algorithm, introducing strategies may add unnecessary complexity.
- When the behavior is unlikely to change and doesn't need to be varied at runtime.

**Example:**

```java
// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy: CreditCardPayment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

// Concrete Strategy: PayPalPayment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        cart.checkout(500);

        // Pay using PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(300);
    }
}
```
**Explanation:**

- **Strategy Interface (PaymentStrategy):** Defines the method `pay` that different payment strategies must implement.
- **Concrete Strategies (CreditCardPayment, PayPalPayment):** Implement the `PaymentStrategy` interface and provide specific implementations of the `pay` method.
- **Context (ShoppingCart):** Maintains a reference to a `PaymentStrategy` and uses it to process payments. The strategy can be changed dynamically at runtime.
- **Client:** The client (in this case, the `Main` class) sets the payment strategy and calls the `checkout` method to process the payment.

This design allows for flexibility in adding or modifying payment methods without changing the `ShoppingCart` class.