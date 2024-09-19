package restart.lld.BasicOOPConcepts.composition;

// Class for Car
class Car {
    private Engine engine;  // Car "has-a" Engine

    public Car() {
        this.engine = new Engine();  // Car is composed of an Engine
    }

    public void startCar() {
        engine.start();  // Delegating the start operation to the engine
        System.out.println("Car started");
    }
}
