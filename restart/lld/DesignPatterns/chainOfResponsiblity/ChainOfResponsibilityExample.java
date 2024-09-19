package restart.lld.DesignPatterns.chainOfResponsiblity;

// Client class
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        // Create handlers
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        // Set the chain of responsibility
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        // Test requests
        handler1.handleRequest("Request1");
        handler1.handleRequest("Request2");
        handler1.handleRequest("Request3");
        handler1.handleRequest("Request4");
    }
}