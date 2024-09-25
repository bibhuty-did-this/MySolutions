package restart.lld.DesignPatterns.behavioral.command.example;

import java.util.Stack;

class SmartHomeSwitch {
    private Command lightOnCommand;
    private Command lightOffCommand;
    private Command fanOnCommand;
    private Command fanOffCommand;
    private Command coffeeBrewCommand;

    private Stack<Command> undo;
    private Stack<Command> redo;

    public SmartHomeSwitch(Command lightOnCommand, Command lightOffCommand, Command fanOnCommand, Command fanOffCommand, Command coffeeBrewCommand) {
        this.lightOnCommand = lightOnCommand;
        this.lightOffCommand = lightOffCommand;
        this.fanOnCommand = fanOnCommand;
        this.fanOffCommand = fanOffCommand;
        this.coffeeBrewCommand = coffeeBrewCommand;
        this.undo = new Stack<>();
        this.redo = new Stack<>();
    }

    public void pressLightOnButton() {
        lightOnCommand.execute();
        undo.push(lightOnCommand);
        redo.clear();
    }

    public void pressLightOffButton() {
        lightOffCommand.execute();
        undo.push(lightOffCommand);
        redo.clear();
    }

    public void pressFanOnButton() {
        fanOnCommand.execute();
        undo.push(fanOnCommand);
        redo.clear();
    }

    public void pressFanOffButton() {
        fanOffCommand.execute();
        undo.push(fanOffCommand);
        redo.clear();
    }

    public void pressCoffeeBrewButton() {
        coffeeBrewCommand.execute();
        undo.push(coffeeBrewCommand);
        redo.clear();
    }

    public void undo() {
        if (!undo.isEmpty()) {
            var lastCommand = undo.pop();
            lastCommand.undo();
            redo.push(lastCommand);
        } else {
            System.out.println("No command to undo");
        }
    }

    public void redo() {
        if (!redo.isEmpty()) {
            var lastCommand = redo.pop();
            lastCommand.execute();
            undo.push(lastCommand);
        } else {
            System.out.println("No command to redo");
        }
    }


}
