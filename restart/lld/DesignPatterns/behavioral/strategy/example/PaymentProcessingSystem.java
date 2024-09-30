package restart.lld.DesignPatterns.behavioral.strategy.example;

import java.util.function.BiFunction;

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Order order=new Order("1", 1, 10, 2);
        PaymentProcessor paymentProcessor = new PaymentProcessor(new CreditCardPayment());
        paymentProcessor.processPayment(order);

        paymentProcessor.setPaymentStrategy(new PayPalPayment());
        paymentProcessor.processPayment(order);

        paymentProcessor.setPaymentStrategy(new CryptoPayment());
        paymentProcessor.processPayment(order);
    }
}
class Order{
    private String orderId;
    private int count;
    private int price;
    private int discount;

    public Order(String orderId, int count, int price, int discount) {
        this.orderId = orderId;
        this.count = count;
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
interface Payment{
    void pay(Order order);
    BiFunction<String,String,String> debug =(a, b)-> a + b;
}

class CreditCardPayment implements Payment{

    @Override
    public void pay(Order order) {
        String details = debug.apply(this.getClass().getSimpleName(), order.toString());
        System.out.println(details);
    }
}

class CryptoPayment implements Payment{

    @Override
    public void pay(Order order) {
        String details = debug.apply(this.getClass().getSimpleName(), order.toString());
        System.out.println(details);
    }
}

class PayPalPayment implements Payment{

    @Override
    public void pay(Order order) {
        String details = debug.apply(this.getClass().getSimpleName(), order.toString());
        System.out.println(details);
    }
}

class PaymentProcessor{
    Payment paymentStrategy;

    public PaymentProcessor(Payment payment) {
        this.paymentStrategy = payment;
    }

    public void setPaymentStrategy(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(Order order){
        paymentStrategy.pay(order);
    }
}
