package dat.backend.model.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoanCalculatorTest {

    @Test
    void findMonthlyPayment() {
        double loanSize = 10000;
        double loanLength = 12;
        double loanAPRC = 4;



    }

    @Test
    void totalCostOfLoan() {
    }

    @Test
    void totalCostWithLowerAPRC() {
        double loanSize = 10000;
        double loanLength = 12;
        double loanAPRC = 4;

        double monthlyPayment = LoanCalculator.totalCostWithLowerAPRC(loanSize, loanLength, loanAPRC);

        assertEquals(10108.66, monthlyPayment, 0.5);
    }

    @Test
    void totalCostWithLowerLength() {
        double loanSize = 10000;
        double loanLength = 12;
        double loanAPRC = 4;

        double loanlengthShort = 8;

        assertEquals(LoanCalculator.totalCostOfLoan(loanSize,loanlengthShort,loanAPRC),
                LoanCalculator.totalCostWithLowerLength(loanSize,loanLength,loanAPRC));

    }
}