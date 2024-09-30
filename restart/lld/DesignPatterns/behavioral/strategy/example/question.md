# Strategy Design Pattern: Practice Question

## Problem Statement

You are tasked with designing a **Payment Processing System** for an e-commerce platform. The platform supports multiple payment methods: **Credit Card**, **PayPal**, and **Cryptocurrency**. Each payment method has its own specific implementation, such as validation and processing steps.

The system should allow customers to select their preferred payment method at checkout, and the appropriate payment strategy should be executed based on their selection.

### Requirements:
1. There should be a way to easily add new payment methods in the future without modifying existing code.
2. The payment method chosen by the customer should determine which algorithm gets executed.
3. Each payment strategy should encapsulate its specific logic, such as handling the API for credit card validation, checking a PayPal account, or verifying cryptocurrency.

### Task:
- Implement a **PaymentProcessor** class that will use different payment strategies at runtime, based on the customer's choice.
- Each payment method should be encapsulated in its own class, implementing a common interface.
- Demonstrate how a client can choose a payment method and process the payment by switching between different strategies.

### Guidelines:
- Use the **Strategy Design Pattern** to solve the problem.
- Ensure that the system is open for extension (new payment methods) but closed for modification (existing functionality should not be altered when adding new methods).
- Focus on separating the concerns of choosing the algorithm (strategy) and the execution of that algorithm.

### Considerations:
- Think about edge cases, such as what happens when a payment fails for one strategy and how the system handles retries or fallbacks.
- Ensure that each payment strategy can have its own unique flow but adheres to a common interface for integration with the main system.

---

## Example:

```java
PaymentProcessor paymentProcessor = new PaymentProcessor(new CreditCardPayment());
paymentProcessor.processPayment(order);

paymentProcessor.setPaymentStrategy(new PayPalPayment());
paymentProcessor.processPayment(order);

paymentProcessor.setPaymentStrategy(new CryptoPayment());
paymentProcessor.processPayment(order);
```
### Solution Outline:
1. Define a PaymentStrategy interface with a method like processPayment(Order order).
2. Implement classes like CreditCardPayment, PayPalPayment, and CryptoPayment that implement PaymentStrategy and encapsulate the specific logic for each method.
3. Use a PaymentProcessor class that holds a reference to a PaymentStrategy and can switch between strategies at runtime.
4. Demonstrate how the system behaves with different payment methods by changing the strategy dynamically.


This question encourages the use of the **Strategy Design Pattern** to encapsulate different behaviors and switch them out dynamically at runtime, which is key to mastering the pattern.