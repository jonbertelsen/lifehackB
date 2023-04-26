package dat.backend.model.entities;

import java.util.ArrayList;

public class Soda {
    private final double litersPerDay;
    private final double pricePerLiter;
    private final ArrayList<double[]> percentages;
    private final double caloriesPerLiter = 38;

    public Soda(double litersPerDay, double pricePerLiter) {
        this.litersPerDay = litersPerDay;
        this.pricePerLiter = pricePerLiter;
        this.percentages = calculatePercentages();
    }

    public double getLitersPerDay() {
        return litersPerDay;
    }

    public double getLitersPerMonth() {
        return litersPerDay * 30;
    }

    public double getLitersPerYear() {
        return getLitersPerMonth() * 12;
    }

    public double getPricePerDay() {
        return litersPerDay * pricePerLiter;
    }

    public double getPricePerMonth() {
        return getLitersPerMonth() * pricePerLiter;
    }

    public double getPricePerYear() {
        return getLitersPerYear() * pricePerLiter;
    }

    public double getCaloriesPerDay() {
        return caloriesPerLiter * litersPerDay;
    }

    public double getCaloriesPerMonth() {
        return getCaloriesPerDay() * 30;
    }

    public double getCaloriesPerYear() {
        return getCaloriesPerMonth() * 12;
    }

    public ArrayList<double[]> getPercentages() {
        return percentages;
    }

    /**
     * This method calculates all percentages
     * @return Returns an ArrayList<double[]>
     * @author heinLarsen
     */
    private ArrayList<double[]> calculatePercentages() {
        double litersPerMonth = litersPerDay * 30;
        double litersPerYear = litersPerMonth * 12;
        double costPerMonth = litersPerMonth * pricePerLiter;
        double costPerYear = litersPerYear * pricePerLiter;

        ArrayList<double[]> result = new ArrayList<>();
        // Calculate savings and consumption for different percentages
        int[] percentages = { 10, 20, 50, 100 };
        for (int percentage : percentages) {
            // Calculate savings
            double savingsPerDay = litersPerDay * pricePerLiter * percentage / 100;
            double savingsPerMonth = costPerMonth * percentage / 100;
            double savingsPerYear = costPerYear * percentage / 100;

            // Calculate consumption
            double consumptionPerDay = litersPerDay * (100 - percentage) / 100;

            // Calculate how much can be consumed
            double newConsumptionPerDay = litersPerDay * percentage / 100;

            // Calculate calories
            double caloriesPerDay = caloriesPerLiter * litersPerDay * percentage / 100;


            double[] percentageResult = {
                    percentage,
                    consumptionPerDay,
                    newConsumptionPerDay,
                    savingsPerDay,
                    savingsPerMonth,
                    savingsPerYear,
                    caloriesPerDay
            };
            result.add(percentageResult);
        }

        return result;

    }
}
