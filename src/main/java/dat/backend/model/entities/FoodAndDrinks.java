package dat.backend.model.entities;

import java.util.List;

public class FoodAndDrinks {

    private String food;

    private int kcal;

    final static List<FoodAndDrinks> foodObjects = (new FoodAndDrinks("Pizza", 600));

    public FoodAndDrinks(String food, int kcal) {
        this.food = food;
        this.kcal = kcal;
    }
}
