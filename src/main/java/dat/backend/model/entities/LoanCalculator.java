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
        double interestPowerOfLength = Math.pow((1+loanAPRC),loanLength);
        return interestPowerOfLength;
    }

    public static double findMonthlyPayment(double loanSize, double loanLength, double loanAPRC) {
        double monthlyPayment;
         double interest = recalculateInterest(loanAPRC);

         //Calculate monthly payments based off user variables
        double i = findInterestPowerOfLength(loanLength, interest);
        monthlyPayment = ((loanSize*interest)*i)/(i-1);

        return monthlyPayment;
    }

    public static double totalCostOfLoan(double loanSize, double loanLength, double loanAPRC) {
        //calculating how much you have to pay back for the whole loan

        double monthlyPayment = findMonthlyPayment(loanSize, loanLength, loanAPRC);

        return monthlyPayment * loanLength;
    }


    public static double totalCostWithLowerAPRC(double loanSize, double loanLength, double loanAPRC) {
        double newAPRC = loanAPRC-(loanAPRC/2);

        double monthlyPayment = findMonthlyPayment(loanSize, loanLength, newAPRC);


        return monthlyPayment*loanLength;
    }

    public static double totalCostWithLowerLength(double loanSize, double loanLength, double loanAPRC) {
        double newLoanLength = loanLength - (loanLength/3);

        double monthlyPayment = findMonthlyPayment(loanSize, newLoanLength, loanAPRC);

        return monthlyPayment * newLoanLength;
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
