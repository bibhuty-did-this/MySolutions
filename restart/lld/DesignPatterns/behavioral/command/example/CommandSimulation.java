package restart.lld.DesignPatterns.behavioral.command.example;

public class CommandSimulation {
    public static void main(String[] args) {
        var light=new Light();
        var fan=new Fan();
        var coffeeMachine=new CoffeeBrewMachine();

        var lightOnCommand=new LightOnCommand(light);
        var lightOffCommand=new LightOffCommand(light);
        var fanOnCommand=new FanOnCommand(fan);
        var fanOffCommand=new FanOffCommand(fan);
        var coffeeMachineBrewCommand=new CoffeeMachineBrewCommand(coffeeMachine);
        var smartHomeSwitch=new SmartHomeSwitch(lightOnCommand, lightOffCommand, fanOnCommand, fanOffCommand, coffeeMachineBrewCommand);
        smartHomeSwitch.pressLightOnButton();
        smartHomeSwitch.pressLightOnButton();
        smartHomeSwitch.pressLightOnButton();
        smartHomeSwitch.pressFanOnButton();
        smartHomeSwitch.pressFanOffButton();
        smartHomeSwitch.pressCoffeeBrewButton();
        smartHomeSwitch.undo();
        smartHomeSwitch.redo();
        smartHomeSwitch.undo();
        smartHomeSwitch.undo();
    }
}

