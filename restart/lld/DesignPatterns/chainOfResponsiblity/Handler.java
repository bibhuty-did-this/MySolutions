package restart.lld.DesignPatterns.chainOfResponsiblity;

// Abstract handler class
abstract class Handler {
    protected Handler nextHandler;

    // Set the next handler in the chain
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Abstract method to handle request
    public abstract void handleRequest(String request);
}
