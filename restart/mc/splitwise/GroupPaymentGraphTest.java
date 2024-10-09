package restart.mc.splitwise;

import restart.mc.splitwise.models.Amount;
import restart.mc.splitwise.models.BalanceMap;
import restart.mc.splitwise.models.Expense;
import restart.mc.splitwise.models.Group;
import restart.mc.splitwise.services.ExpenseService;
import restart.mc.splitwise.services.GroupService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPaymentGraphTest {
    public void defaultTest() throws IllegalAccessException {
        final var userList = new ArrayList<String>() {{
            add("A");
            add("B");
            add("C");
        }};
        final var groups = new HashMap<String, Group>() {{
            put("123", new Group("Europe", "Europe Trip", "google.com", userList));
        }};
        final var firstExpense = new BalanceMap();
        firstExpense.getBalances().put("A", new Amount("USD", 10));
        firstExpense.getBalances().put("B", new Amount("USD", 20));
        firstExpense.getBalances().put("C", new Amount("USD", -30));
        final var secondExpense = new BalanceMap();
        secondExpense.getBalances().put("A", new Amount("USD", -50));
        secondExpense.getBalances().put("B", new Amount("USD", 10));
        secondExpense.getBalances().put("C", new Amount("USD", 40));
        final var thirdExpense = new BalanceMap();
        thirdExpense.getBalances().put("A", new Amount("USD", 90));
        thirdExpense.getBalances().put("C", new Amount("USD", -90));
        final var expenses = new ArrayList<Expense>() {{
            add(new Expense(firstExpense, "outing1", "outing 1", "google.com"));
            add(new Expense(secondExpense, "outing2", "outing 2", "google.com"));
            add(new Expense(thirdExpense, "outing3", "outing 3", "google.com"));
            add(new Expense(new BalanceMap(), "outing4", "outing 4", "google.com"));
        }};
        Map<String, List<Expense>> groupExpenses=new HashMap<>(){{
            put("123", expenses);
        }};
        GroupService groupService=new GroupService(new ExpenseService(groupExpenses), groups);
        System.out.println(groupService.getBalances("123","A"));
        System.out.println(groupService.getGroupPaymentGraph("123","A"));
    }

    public static void main(String[] args) throws IllegalAccessException {
        var test=new GroupPaymentGraphTest();
        test.defaultTest();
    }
}
