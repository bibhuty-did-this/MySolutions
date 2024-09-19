package restart.lld.DesignPatterns.chainOfResponsiblity;

// Concrete handler 3
class ConcreteHandler3 extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("Request3")) {
            System.out.println("Handler 3 is handling the request");
        } else {
            System.out.println("No handler could process the request");
        }
    }
}
