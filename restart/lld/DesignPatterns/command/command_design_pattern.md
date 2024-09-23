
# Command Design Pattern

The **Command Design Pattern** is a behavioral design pattern used to encapsulate a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations. It is particularly useful when you need to decouple the object that invokes the operation from the one that actually performs the operation.

## Key Components:
1. **Command**: Declares an interface for executing an operation.
2. **ConcreteCommand**: Implements the Command interface, binding the receiver and an action together.
3. **Receiver**: The object that performs the actual work when the command is executed.
4. **Invoker**: Asks the command to execute the request.
5. **Client**: Creates a ConcreteCommand and sets its receiver.

## UML Diagram:
- `Invoker` depends on `Command` to execute requests.
- `Command` knows the `Receiver` and executes an action.
- `ConcreteCommand` binds a `Receiver` to an action.

## Example in Java:
```java
// Command Interface
public interface Command {
    void execute();
}

// ConcreteCommand
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

// Receiver
public class Light {
    public void on() {
        System.out.println("The light is on.");
    }
    public void off() {
        System.out.println("The light is off.");
    }
}

// Invoker
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: The light is on.
    }
}
```

## Use Cases:
- **Undo/Redo**: Commands can be stored in a history list and undone/redone easily.
- **Macro Commands**: Multiple commands can be combined and executed together.
- **Queueing Requests**: Commands can be queued or logged, facilitating delayed execution.

This pattern is especially useful in systems that need flexibility and scalability for executing operations based on client input.
