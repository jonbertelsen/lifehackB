package dat.backend.model.entities;

public class FoodAndDrinks {
    private String food;
    private int kcal;

    public FoodAndDrinks(String food, int kcal) {
        this.food = food;
        this.kcal = kcal;
    }

    public String getFood() {
        return food;
    }

    public int getKcal() {
        return kcal;
    }
}
