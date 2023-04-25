package dat.backend.model.entities;

import dat.backend.model.exceptions.SmokeStopCalculatorException;
// This class is neccasary for us to work in OOP.
// This class is used to calculate the savings of a smoker who wants to quit smoking, or at least cut down the usage of cigarettes.
// The class takes in two parameters, the number of cigarettes smoked per day, and the price per cigarette.
// The class then calculates the savings per day, month and year, and also calculates the savings if the user cuts down the usage of cigarettes by a certain percentage.
// The class also has a method that calculates the number of cigarettes the user will smoke after cutting down the usage by a certain percentage.


public class SmokeStopCalculator {

    private int cigarettesPerDay;
    private double pricePerCigarette;
    private double totalSavedADay;
    private double totalSavedAMonth;
    private double totalSavedAYear;


    // This constructor takes in two parameters, the number of cigarettes smoked per day, and the price per cigarette.
    // The constructor then checks if the parameters are greater than 0, if not, it throws an exception.
    // If the parameters are greater than 0, the constructor sets the parameters to the class variables.
    //By throwing an exception before the class variables are set, we ensure that the class variables are not set to 0.
    public SmokeStopCalculator(int cigarettesPerDay, double pricePerCigarette) throws SmokeStopCalculatorException {
        if (cigarettesPerDay <= 0 || pricePerCigarette <= 0) {
            throw new SmokeStopCalculatorException("Please enter a number greater than 0");
        }
        this.cigarettesPerDay = cigarettesPerDay;
        this.pricePerCigarette = pricePerCigarette;

    }

// This method is used to calculate the cost of cigarettes consumed by the user for a day.
    // It takes the number of cigarettes smoked per day, and multiplies it with the price per cigarette.
    // These numbers are provided from the user when they type in the information on the website.
    // The method then set the varibale totalSavedADay to the result of the calculation.
    public double savingPerDay() {
        totalSavedADay = cigarettesPerDay * pricePerCigarette;
        return totalSavedADay;

    }

// This method is used to calculate the cost of cigarettes consumed by the user for a month.
    // The way it does this is by taking the total cost of cigarettes consumed per day, and multiplying it with 30.
    // The method then set the varibale totalSavedAMonth to the result of the calculation.
    public double savingPerMonth() {
        totalSavedAMonth = totalSavedADay * 30;
        return totalSavedAMonth;
    }

    // This method is used to calculate the cost of cigarettes consumed by the user for a year.
    // The way it does this is by taking the total cost of cigarettes consumed per month, and multiplying it with 12.
    // The method then set the varibale totalSavedAYear to the result of the calculation.
    public double savingPerYear() {
        totalSavedAYear = totalSavedAMonth * 12;
        return totalSavedAYear;
    }

    // This method is used to calculate the savings of a user who cuts down the usage of cigarettes by a certain percentage.
    // The method takes in the percentage as a parameter, and then calculates the savings by multiplying the totalSavedAYear with the percentage.
    // The method then returns the result of the calculation.
    // This method is to calculate the savings of a user who cuts down the usage of cigarettes by a certain percentage for a year.
    public double calculateSavingsPercentageAYear(int percentage) {
        return (totalSavedAYear * (percentage / 100.0));
    }

    // This method is used to calculate the number of cigarettes the user will smoke after cutting down the usage by a certain percentage.
    // The method takes in the percentage as a parameter, and then calculates the number of cigarettes the user will smoke by multiplying the cigarettesPerDay with the percentage.
    // The method then returns the result of the calculation.
    public double cigarettesAfterCuttingPercentage(int percentage) {
        double remainingPercentage = 1 - (percentage / 100.0);
        return (cigarettesPerDay * remainingPercentage);
    }


}
