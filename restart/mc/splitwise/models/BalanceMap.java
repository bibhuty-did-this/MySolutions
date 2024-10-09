package restart.mc.splitwise.models;

import java.util.HashMap;
import java.util.Map;

public class BalanceMap {
    private final Map<String,Amount> balances;

    public BalanceMap(Map<String, Amount> balances) {
        this.balances = balances;
    }

    public BalanceMap(){
        this.balances = new HashMap<>();
    }

    public Map<String, Amount> getBalances() {
        return balances;
    }

    @Override
    public String toString() {
        return "BalanceMap{" +
                "balances=" + balances +
                '}';
    }
}
