package restart.lld.DesignPatterns.behavioral.command.example;

class Light {

    public boolean isOn = false;

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Light is switched on");
        } else {
            System.out.println("Light is already on");
        }
    }

    public void turnOff() {
        if (!isOn) {
            System.out.println("Light is already off");
        } else {
            isOn = false;
            System.out.println("Light is turned off");
        }
    }
}
