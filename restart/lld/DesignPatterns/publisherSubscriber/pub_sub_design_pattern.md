
# Publisher Subscriber Design Pattern in Java

The **Publisher-Subscriber** (or **Pub-Sub**) design pattern is a messaging pattern where senders (publishers) do not communicate directly with receivers (subscribers), but instead, messages are sent to an intermediary (commonly called a broker or event bus), which then relays them to subscribers who are interested in the event or message.

## Components of the Publisher-Subscriber Pattern:

1. **Publisher**: 
   - The source or producer of messages or events.
   - Does not know who the subscribers are.
   - Simply sends messages to the broker/event bus.

2. **Subscriber**:
   - The consumer of messages.
   - Expresses interest in certain types of messages (topics or events) by subscribing to them.
   - Receives messages from the broker/event bus when they are published.

3. **Broker/Event Bus**:
   - The mediator that routes messages from publishers to subscribers.
   - Maintains the list of subscribers and their interests (topics or events).
   - Can handle multiple publishers and multiple subscribers.

## How it Works:

1. A **Publisher** sends a message or event to a **Broker**.
2. The **Broker** matches the message with all interested **Subscribers** (those that subscribed to the event).
3. The **Subscribers** receive the message from the **Broker**.

## Key Concepts:

- **Loose Coupling**: Publishers and subscribers do not know each other. They only know about the **Broker**.
- **Asynchronous Communication**: Messages can be delivered without waiting for a response, meaning publishers and subscribers can work independently.
- **Topics/Events**: Subscribers often subscribe to specific types of messages (e.g., topics or events).

## Example Scenarios:

1. **Notification Systems**: A system where a publisher sends notifications, and users can subscribe to receive specific kinds of alerts (e.g., news, weather, sports).
2. **Logging Systems**: A log publisher generates logs, and different services subscribe to various log types for monitoring or analysis.
3. **Microservices Architecture**: Different microservices publish events, and others can subscribe to react to those events without tightly coupling services.

## Java Example (Using an Event Bus):

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Define the Event Bus
class EventBus {
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();
    
    public void subscribe(String eventType, Subscriber subscriber) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(subscriber);
    }
    
    public void publish(String eventType, String message) {
        List<Subscriber> eventSubscribers = subscribers.get(eventType);
        if (eventSubscribers != null) {
            for (Subscriber subscriber : eventSubscribers) {
                subscriber.update(eventType, message);
            }
        }
    }
}

// Subscriber Interface
interface Subscriber {
    void update(String eventType, String message);
}

// Concrete Subscriber Implementation
class EmailSubscriber implements Subscriber {
    @Override
    public void update(String eventType, String message) {
        System.out.println("Email Subscriber received event: " + eventType + " with message: " + message);
    }
}

class SMSSubscriber implements Subscriber {
    @Override
    public void update(String eventType, String message) {
        System.out.println("SMS Subscriber received event: " + eventType + " with message: " + message);
    }
}

// Main application
public class PubSubDemo {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        
        Subscriber emailSubscriber = new EmailSubscriber();
        Subscriber smsSubscriber = new SMSSubscriber();
        
        eventBus.subscribe("orderCreated", emailSubscriber);
        eventBus.subscribe("orderCreated", smsSubscriber);
        
        eventBus.publish("orderCreated", "Order #123 has been created!");
    }
}
```

## When to Use:
- When you want a **loosely coupled system** where components don’t need to know about each other directly.
- In systems that require **scalability**, as publishers and subscribers can be added/removed independently.
- When handling **asynchronous event-driven** communication.
