package dat.backend.model.entities;

public class LoanCalculator {

    private double loanSize;
    private double loanLength;
    private double loanAPRC;

    public static double recalculateToMonths(double loanLength) {
        return loanLength*12;
    }

    private static double recalculateInterest(double loanAPRC){
        double interest;
        return interest = (loanAPRC/100)/12;
    }

    private static double findInterestPowerOfLength(double loanLength, double loanAPRC) {
        //calculates (1+i)^n :)
        double interest = recalculateInterest(loanAPRC);
        double interestPowerOfLength = Math.pow((1+interest),loanLength);
        return interestPowerOfLength;
    }

    public static double findMonthlyPayment(double loanSize, double loanLength, double loanAPRC) {
        double monthlyPayment;

        //Calculate monthly payments based off user variables
        double i = findInterestPowerOfLength(loanLength, loanAPRC);

        double interest = recalculateInterest(loanAPRC);
        monthlyPayment = ((loanSize*interest)*i)/(i-1);

        return monthlyPayment;
    }

    public static double totalCostOfLoan(double loanSize, double loanLength, double loanAPRC) {
        //calculating how much you have to pay back for the whole loan
        double loanPayBack;

        double monthlyPayment = findMonthlyPayment(loanSize, loanLength, loanAPRC);
        double i = findInterestPowerOfLength(loanLength, loanAPRC);

        return loanPayBack = (monthlyPayment/loanAPRC)*(1-(1/i));
    }


    public static double totalCostWithLowerAPRC(double loanSize, double loanLength, double loanAPRC) {
        double loanPayBack;
        double newAPRC = loanAPRC-(loanAPRC/3);

        double monthlyPayment = findMonthlyPayment(loanSize, loanLength, newAPRC);
        double i = findInterestPowerOfLength(loanLength, newAPRC);

        return loanPayBack = (monthlyPayment/newAPRC)*(1-(1/i));
    }

    public static double totalCostWithLowerLength(double loanSize, double loanLength, double loanAPRC) {
        double loanPayBack;
        double newLoanLength = loanLength - (loanLength/3);

        double monthlyPayment = findMonthlyPayment(loanSize, newLoanLength, loanAPRC);
        double i = findInterestPowerOfLength(newLoanLength, loanAPRC);

        return loanPayBack = (monthlyPayment/loanAPRC)*(1-(1/i));
    }

    public double getLoanSize() {
        return loanSize;
    }

    public double getLoanLength() {
        return loanLength;
    }

    public double getLoanAPRC() {
        return loanAPRC;
    }
}
