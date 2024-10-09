package restart.mc.splitwise.models;

public class Amount {
    private final String currency;
    private final double amount;

    public Amount(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Amount add(Amount amount) {
        return new Amount(amount.getCurrency(),this.amount+amount.amount);
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
