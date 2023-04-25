package dat.backend.model.entities;

public class Item {

        private String name;
        private double amount;

    public Item(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }


    public String getName() {
        return name;
    }
    public double getAmount() {
        return amount;
    }

}
