package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class BudgetCalculator {
    private List<Item> incomeItems;
    private List<Item> expenseItems;
    private double totalIncome;
    private double totalExpenses;

    public BudgetCalculator() {
        incomeItems = new ArrayList<Item>();
        expenseItems = new ArrayList<Item>();
        totalIncome = 0.0;
        totalExpenses = 0.0;
    }

    public void addIncomeItem(Item item) {
        incomeItems.add(item);
        totalIncome += item.getAmount();
    }

    public void addExpenseItem(Item item) {
        expenseItems.add(item);
        totalExpenses += item.getAmount();
    }
        public List<Item> getIncomeItems() {
        return incomeItems;
    }

    public List<Item> getExpenseItems() {
        return expenseItems;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getBalance() {
        return totalIncome - totalExpenses;
    }
}
