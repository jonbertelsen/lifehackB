package dat.backend.model.entities;

public class Item {

        private String name;
        private double amount;
        private String type;

    public Item(String name, double amount, String type) {
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
