package dat.backend.model.entities;

public class BudgetListItem {

        private String name;
        private double amount;
        private String type;

    public BudgetListItem(String name, double amount, String type) {
        this.name = name;
        this.amount = amount;
        this.type = type;
    }


    public String getName() {
        return name;
    }
    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

}
