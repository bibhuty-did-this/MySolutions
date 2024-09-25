package restart.lld.DesignPatterns.behavioral.command.example;

class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.switchOff();
    }

    @Override
    public void undo() {
        fan.switchOn();
    }
}
