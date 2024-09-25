package restart.lld.DesignPatterns.behavioral.command.example;

class CoffeeMachineBrewCommand implements Command {
    private CoffeeBrewMachine coffeeBrewMachine;

    public CoffeeMachineBrewCommand(CoffeeBrewMachine coffeeBrewMachine) {
        this.coffeeBrewMachine = coffeeBrewMachine;
    }

    @Override
    public void execute() {
        coffeeBrewMachine.startBrewing();
    }

    @Override
    public void undo() {
        System.out.println("Coffee brewing can't be undone");
    }
}
