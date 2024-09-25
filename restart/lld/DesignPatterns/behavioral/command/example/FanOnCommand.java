package restart.lld.DesignPatterns.behavioral.command.example;

class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.switchOn();
    }

    @Override
    public void undo() {
        fan.switchOff();
    }
}
