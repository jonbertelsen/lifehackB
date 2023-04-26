package dat.backend.model.entities;

/**
 * This is the class for our loan calculator that handles
 * the heavy lifting in terms of equations and general calculations.
 */

public class LoanCalculator {

    private double loanSize;
    private double loanLength;
    private double loanAPRC;

    /**
     * This method recalculates a user input to months if they have
     * ticked the box called "years" on the website.
     * @param loanLength this is the duration of the loan taken by the user
     * @return returns how many months their year input is equal to
     */

    public static double recalculateToMonths(double loanLength) {
        return loanLength*12;
    }

    /**
     * This mehtod calculates monthly interest instead of yearly interest
     * @param loanAPRC this is the APRC (interest) og the loan
     * @return monthly interest
     */

    private static double recalculateInterest(double loanAPRC){
        double interest;
        return interest = (loanAPRC/100)/12;
    }

    /**
     * This method is only to calculate a small part needed to find monthly payments
     * puts (1+APRC) in the power of loanlength / (1+APRC)^loanLength
     * @param loanLength this is the duration of the loan taken by the user
     * @param loanAPRC this is the APRC (interest) og the loan
     * @return the value of (1+APRC)^loanLength
     */

    private static double findInterestPowerOfLength(double loanLength, double loanAPRC) {
        //calculates (1+i)^n :)
        double interestPowerOfLength = Math.pow((1+loanAPRC),loanLength);
        return interestPowerOfLength;
    }

    /**
     * This method calculates the monthly payment.
     * @param loanSize this is the size of the actual loan taken by the user
     * @param loanLength this is the duration of the loan taken by the user
     * @param loanAPRC this is the APRC (interest) og the loan
     * @return it will return the monthly payment.
     */
    public static double findMonthlyPayment(double loanSize, double loanLength, double loanAPRC) {
        double monthlyPayment;
         double interest = recalculateInterest(loanAPRC);

         //Calculate monthly payments based off user variables
        double i = findInterestPowerOfLength(loanLength, interest);
        monthlyPayment = ((loanSize*interest)*i)/(i-1);

        return monthlyPayment;
    }

    /**
     * This method calculates the total cost of the loan. It will be the actual loan size plus the
     * interest.
     * @param loanSize this is the size of the actual loan taken by the user
     * @param loanLength this is the duration of the loan taken by the user
     * @param loanAPRC this is the APRC (interest) og the loan
     * @return it will return the total cost of the whole loan.
     */
    public static double totalCostOfLoan(double loanSize, double loanLength, double loanAPRC) {
        //calculating how much you have to pay back for the whole loan

        double monthlyPayment = findMonthlyPayment(loanSize, loanLength, loanAPRC);

        return monthlyPayment * loanLength;
    }

    /**
     * this method calculates what the loan would look like if the interest was lower (-50%)
     * @param loanSize this is the size of the actual loan taken by the user
     * @param loanLength this is the duration of the loan taken by the user
     * @param loanAPRC this is the APRC (interest) og the loan
     * @return it will return the total cost of the loan with the interest cut in half
     */

    public static double totalCostWithLowerAPRC(double loanSize, double loanLength, double loanAPRC) {
        double newAPRC = loanAPRC-(loanAPRC/2);

        double monthlyPayment = findMonthlyPayment(loanSize, loanLength, newAPRC);


        return monthlyPayment*loanLength;
    }

    /**
     * This method will calculate the total cost of the loan if the loan length were to be
     * cut by a third
     * @param loanSize this is the size of the actual loan taken by the user
     * @param loanLength this is the duration of the loan taken by the user
     * @param loanAPRC this is the APRC (interest) og the loan
     * @return it will return the total cost of the loan with the length cut by a third
     */

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
