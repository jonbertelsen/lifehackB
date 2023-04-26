package dat.backend.control;

import dat.backend.model.entities.BudgetListItem;
import dat.backend.model.services.BudgetCalculationHelper;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetCalculatorTest {
    @Test
    void convertBudgetToCSV(){
        String expectedCSV =
                "Name,Amount\n" +
                "Income:,\n" +
                "single,100.5\n" +
                "Expense:,\n" +
                "rent,100.5\n" +
                "Balance:,0.0";

        BudgetListItem incomeItem = new BudgetListItem("single", 100.50, "income");
        BudgetListItem expenseItem = new BudgetListItem("rent", 100.50, "expense");
        double balance = incomeItem.getAmount() - expenseItem.getAmount();

        List<BudgetListItem> incomeList = new ArrayList<>();
        List<BudgetListItem> expenseList = new ArrayList<>();
        incomeList.add(incomeItem);
        expenseList.add(expenseItem);

        String actualCSV = BudgetCalculationHelper.convertBudgetToCSV(incomeList, expenseList, balance);
        assertEquals(expectedCSV, actualCSV);

    }
    @Test
    void parseDoubleTest0(){
        String doubleStringToTest = "1.122,311";
        double expectedNumber = 1122.311;
        double actualNumber= 0;
        try {
            actualNumber = BudgetCalculationHelper.parseDouble(doubleStringToTest);
        } catch (ParseException e) {
            fail("String couldn't be converted to a double. String: " + doubleStringToTest + " | " + e.getMessage());
        }
        assertEquals(expectedNumber, actualNumber);
    }
    @Test
    void parseDoubleTest1(){
        String doubleStringToTest = "1122,311";
        double expectedNumber = 1122.311;
        double actualNumber= 0;
        try {
            actualNumber = BudgetCalculationHelper.parseDouble(doubleStringToTest);
        } catch (ParseException e) {
            fail("String couldn't be converted to a double. String: " + doubleStringToTest + " | " + e.getMessage());
        }
        assertEquals(expectedNumber, actualNumber);
    }
    @Test
    void parseDoubleTest2(){
        String doubleStringToTest = "1.122311";
        double expectedNumber = 1.122311;
        double actualNumber= 0;
        try {
            actualNumber = BudgetCalculationHelper.parseDouble(doubleStringToTest);
        } catch (ParseException e) {
            fail("String couldn't be converted to a double. String: " + doubleStringToTest + " | " + e.getMessage());
        }
        assertEquals(expectedNumber, actualNumber);
    }
    @Test
    void parseDoubleTest3(){
        String doubleStringToTest = "1122311";
        double expectedNumber = 1122311;
        double actualNumber= 0;
        try {
            actualNumber = BudgetCalculationHelper.parseDouble(doubleStringToTest);
        } catch (ParseException e) {
            fail("String couldn't be converted to a double. String: " + doubleStringToTest + " | " + e.getMessage());
        }
        assertEquals(expectedNumber, actualNumber);
    }
    @Test
    void parseDoubleTest4(){
        String doubleStringToTest = "1,122.311";
        double expectedNumber = 1122.311;
        double actualNumber= 0;
        try {
            actualNumber = BudgetCalculationHelper.parseDouble(doubleStringToTest);
        } catch (ParseException e) {
            fail("String couldn't be converted to a double. String: " + doubleStringToTest + " | " + e.getMessage());
        }
        assertEquals(expectedNumber, actualNumber);
    }
    @Test
    void parseDoubleTestException(){
        String doubleStringToTest = "1.122.311";
        assertThrows(ParseException.class,
                () -> BudgetCalculationHelper.parseDouble(doubleStringToTest)
        );
    }
}