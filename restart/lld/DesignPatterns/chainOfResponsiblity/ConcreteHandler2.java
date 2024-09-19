package restart.lld.DesignPatterns.chainOfResponsiblity;

// Concrete handler 2
class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Request2")) {
            System.out.println("Handler 2 is handling the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
