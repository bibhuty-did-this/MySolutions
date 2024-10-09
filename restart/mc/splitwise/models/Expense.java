package restart.mc.splitwise.models;

public class Expense {
    private final BalanceMap userBalances;
    private final String title;
    private final String description;
    private final String imageUrl;

    public Expense(BalanceMap userBalances, String title, String description, String imageUrl) {
        this.userBalances = userBalances;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public BalanceMap getUserBalances() {
        return userBalances;
    }
}
