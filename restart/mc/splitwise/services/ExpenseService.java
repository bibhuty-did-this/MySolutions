package restart.mc.splitwise.services;

import restart.mc.splitwise.models.*;

import java.util.*;

public class ExpenseService {

    private final Map<String, List<Expense>> groupExpenses;

    public ExpenseService(Map<String, List<Expense>> groupExpenses) {
        this.groupExpenses = groupExpenses;
    }

    public List<Expense> getGroupExpenses(String groupId) {
        return groupExpenses.get(groupId);
    }

    public PaymentGraph getPaymentGraph(BalanceMap groupBalances) {
        final var graph = new HashMap<String, BalanceMap>();
        PriorityQueue<Map.Entry<String , Amount>> positiveAmounts =
                new PriorityQueue<>(Comparator.comparingDouble(balance -> -balance.getValue().getAmount()));
        PriorityQueue<Map.Entry<String , Amount>> negativeAmounts =
                new PriorityQueue<>(Comparator.comparingDouble(balance -> balance.getValue().getAmount()));
        for(var balance: groupBalances.getBalances().entrySet()){
            if(balance.getValue().getAmount()>0){
                positiveAmounts.add(balance);
            }else{
                negativeAmounts.add(balance);
            }
        }
        while(!positiveAmounts.isEmpty() && !negativeAmounts.isEmpty()){
            final var largestPositiveValue = positiveAmounts.poll();
            final var largestNegativeValue = negativeAmounts.poll();
            final var positiveAmount = largestPositiveValue.getValue().getAmount();
            final var negativeAmount = -largestNegativeValue.getValue().getAmount();
            graph.putIfAbsent(largestPositiveValue.getKey(), new BalanceMap());
            graph.get(largestPositiveValue.getKey())
                    .getBalances()
                    .put(largestNegativeValue.getKey(), new Amount("USD", Math.min(positiveAmount, negativeAmount)));
            double remaining = positiveAmount-negativeAmount;
            var remainingAmount = new Amount("USD", remaining);
            if(remaining>0){
                positiveAmounts.add(new AbstractMap.SimpleEntry<>(largestPositiveValue.getKey(), remainingAmount));
            }else{
                negativeAmounts.add(new AbstractMap.SimpleEntry<>(largestPositiveValue.getKey(), remainingAmount));
            }
        }
        return new PaymentGraph(graph);
    }
}
