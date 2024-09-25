## Smart Home Automation with Command Pattern and Undo/Redo Functionality

### Problem Statement

You are tasked with developing a **Smart Home Automation** system where users can control various household devices such as lights, fans, and coffee machines. The system should follow the **Command Design Pattern** to issue commands to the devices, and it should support **Undo** and **Redo** operations for user convenience.

### Requirements:
1. **Command Pattern**:
    - Implement the **Command Design Pattern** to encapsulate requests to control devices (e.g., turning a light on or off).
    - Each device should have at least two commands: one to turn the device **on** and one to turn it **off**.

2. **Undo/Redo Functionality**:
    - Users should be able to **undo** their last action (e.g., if the light was turned on, undo should turn it off).
    - Users should be able to **redo** an action they just undid (e.g., if the light was turned off via undo, redo should turn it back on).

### Steps:

1. **Define a `Command` Interface**:
    - The `Command` interface should have two methods: `execute()` and `undo()`.
    - `execute()` performs the command, and `undo()` reverses the action.

2. **Create Concrete Commands**:
    - Implement concrete command classes for each action, such as `LightOnCommand`, `LightOffCommand`, `FanOnCommand`, etc.
    - Each class should implement the `execute()` and `undo()` methods appropriately.

3. **Implement a Device Class**:
    - Create a class for each device (e.g., `Light`, `Fan`, `CoffeeMachine`), and each device should have methods to turn itself on or off.

4. **SmartHomeController (Invoker)**:
    - The `SmartHomeController` class should store the history of executed commands to allow undo and redo operations.
    - It should have methods to execute a command, undo the last command, and redo a previously undone command.
    - Use two stacks: one for the executed commands (for undo operations) and one for undone commands (for redo operations).

5. **Main Functionality**:
    - Simulate a user interacting with the smart home system by turning devices on and off, and show how undo and redo work.

### Example Use Case:

1. Turn on the light -> **Light is turned on**.
2. Turn on the fan -> **Fan is turned on**.
3. Undo last action -> **Fan is turned off**.
4. Undo last action -> **Light is turned off**.
5. Redo last action -> **Light is turned on**.
6. Redo last action -> **Fan is turned on**.

### Constraints:

- If no command has been executed yet, an attempt to undo should not cause an error.
- If no command has been undone, an attempt to redo should not cause an error.
- Once a new command is executed after an undo operation, the redo stack should be cleared.

### Classes to Implement:

1. **Command Interface**:
    - Contains `execute()` and `undo()` methods.

2. **Device Classes**:
    - Examples: `Light`, `Fan`, `CoffeeMachine`, each with methods for turning the device on and off.

3. **Concrete Command Classes**:
    - Implement commands such as `LightOnCommand`, `LightOffCommand`, `FanOnCommand`, etc., each implementing the `Command` interface.

4. **SmartHomeController**:
    - Responsible for executing commands, storing the history of commands, and implementing undo and redo functionality.

### Optional:
- Implement logging to track every command execution along with timestamps.
- Add additional devices or functionalities, such as dimming the light or adjusting the fan speed.

### Bonus:
- Add the ability to batch commands together, allowing for macro commands (e.g., "Turn off all devices").