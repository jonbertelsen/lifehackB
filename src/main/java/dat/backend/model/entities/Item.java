package dat.backend.model.entities;

public class Item {

        private String incomeExpense;
        private String name;
        private double incomeAmount;
        private double expenseAmount;

    public Item(String incomeExpense, String name, double incomeAmount, double expenseAmount) {
        this.incomeExpense = incomeExpense;
        this.name = name;
        this.incomeAmount = incomeAmount;
        this.expenseAmount = expenseAmount;
    }

    public String getIncomeExpense() {
        return incomeExpense;
    }

    public void setIncomeExpense(String incomeExpense) {
        this.incomeExpense = incomeExpense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public double getAmount() {
        return incomeAmount - expenseAmount;
    }

}
