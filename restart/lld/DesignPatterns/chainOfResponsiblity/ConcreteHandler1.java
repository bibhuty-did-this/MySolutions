package restart.lld.DesignPatterns.chainOfResponsiblity;

// Concrete handler 1
class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Request1")) {
            System.out.println("Handler 1 is handling the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
