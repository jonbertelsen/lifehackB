package dat.backend.model.entities;

public class BudgetListItem {

        private final String name;
        private final double amount;
        private final String type;

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
