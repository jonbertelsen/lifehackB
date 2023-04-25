package dat.backend.model.entities;

import dat.backend.model.exceptions.SmokeStopCalculatorException;

public class SmokeStopCalculator {

    private int cigarettesPerDay;
    private double pricePerCigarette;
    private double totalSavedADay;
    private double totalSavedAMonth;
    private double totalSavedAYear;
    private int cigerettesPerpack = 20;

    public SmokeStopCalculator(int cigarettesPerDay, double pricePerCigarette) throws SmokeStopCalculatorException {
        if (cigarettesPerDay <= 0 || pricePerCigarette <= 0) {
            throw new SmokeStopCalculatorException("Please enter a number greater than 0");
        }
        this.cigarettesPerDay = cigarettesPerDay;
        this.pricePerCigarette = pricePerCigarette;

    }

    public double pricePerDay() {
        totalSavedADay = cigarettesPerDay * pricePerCigarette;
        return totalSavedADay;

    }

    public double pricePerMonth() {
        totalSavedAMonth = totalSavedADay * 30;
        return totalSavedAMonth;
    }

    public double pricePerYear() {
        totalSavedAYear = totalSavedAMonth * 12;
        return totalSavedAYear;
    }

    public double calculateSavingsPercentage(int percentage) {
        double savingsPercentage = (totalSavedAYear * (percentage / 100.0));
        return savingsPercentage;
    }

    public double cigarettesAfterCuttingPercentage(int percentage) {
        double remainingPercentage = 1 - (percentage / 100.0);
        return (cigarettesPerDay * remainingPercentage);
    }


}
