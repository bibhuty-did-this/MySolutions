
package restart.mc.splitwise.services;

import restart.mc.splitwise.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService {
    private final ExpenseService expenseService;
    private final Map<String, Group> groups;

    public GroupService(ExpenseService expenseService, Map<String, Group> groups) {
        this.expenseService = expenseService;
        this.groups = groups;
    }

    public PaymentGraph getGroupPaymentGraph(final String groupId, final String userId) throws IllegalAccessException {
        final var expense = getBalances(groupId, userId);
        return expenseService.getPaymentGraph(expense);
    }

    private BalanceMap sumExpense(List<Expense> groupExpenses) {
        Map<String , Amount> resultBalances = new HashMap<>();
        for (var expense : groupExpenses) {
            for (var balance : expense.getUserBalances().getBalances().entrySet()) {
                final var user = balance.getKey();
                final var amount = balance.getValue();
                resultBalances.put(user, resultBalances.getOrDefault(user, new Amount("USD", 0)).add(amount));
            }
        }
        return new BalanceMap(resultBalances);
    }

    public BalanceMap getBalances(final String groupId, final String userId) throws IllegalAccessException {
        if (!groups.get(groupId).getUserList().contains(userId)) {
            throw new IllegalAccessException();
        }
        var groupExpenses = expenseService.getGroupExpenses(groupId);
        return sumExpense(groupExpenses);
    }
}
