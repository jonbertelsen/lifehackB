package dat.backend.model.entities;

import dat.backend.model.exceptions.SmokeStopCalculatorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmokeStopCalculatorTest {

    private SmokeStopCalculator calculator;

    @BeforeEach
    void setUp() throws SmokeStopCalculatorException {
        calculator = new SmokeStopCalculator(20, 0.5);
    }

    @Test
    void testPricePerDay() {
        assertEquals(10, calculator.savingPerDay(), 0.001);
    }

    @Test
    void testPricePerMonth() {
        calculator.savingPerDay();
        assertEquals(300, calculator.savingPerMonth(), 0.001);
    }

    @Test
    void testPricePerYear() {
        calculator.savingPerDay();
        calculator.savingPerMonth();
        assertEquals(3600, calculator.savingPerYear(), 0.001);
    }

    @Test
    void testCalculateSavingsPercentage() {
        calculator.savingPerDay();
        calculator.savingPerMonth();
        calculator.savingPerYear();

        assertEquals(360, calculator.calculateSavingsPercentageAYear(10), 0.001);
        assertEquals(720, calculator.calculateSavingsPercentageAYear(20), 0.001);
        assertEquals(1800, calculator.calculateSavingsPercentageAYear(50), 0.001);
        assertEquals(3600, calculator.calculateSavingsPercentageAYear(100), 0.001);
    }

    @Test
    void testCigarettesAfterCuttingPercentage() {
        assertEquals(18, calculator.cigarettesAfterCuttingPercentage(10), 0.001);
        assertEquals(16, calculator.cigarettesAfterCuttingPercentage(20), 0.001);
        assertEquals(10, calculator.cigarettesAfterCuttingPercentage(50), 0.001);
        assertEquals(0, calculator.cigarettesAfterCuttingPercentage(100), 0.001);
    }

    // Test that the constructor throws an exception when the parameters are 0 or less.
    // This is to ensure that if the user enters 0 or less, the class variables are not set to 0.
    // And the system succefssfully throws an exception.
    @Test
    void testSmokeStopCalculatorException() {
        assertThrows(SmokeStopCalculatorException.class, () -> new SmokeStopCalculator(0, 0.5));
        assertThrows(SmokeStopCalculatorException.class, () -> new SmokeStopCalculator(20, 0));
        assertThrows(SmokeStopCalculatorException.class, () -> new SmokeStopCalculator(-20, 0.5));
        assertThrows(SmokeStopCalculatorException.class, () -> new SmokeStopCalculator(20, -0.5));
    }
}
