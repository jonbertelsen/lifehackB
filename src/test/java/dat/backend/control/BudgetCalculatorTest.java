package dat.backend.control;

import dat.backend.model.entities.BudgetListItem;
import dat.backend.model.services.BudgetCalculationHelper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BudgetCalculatorTest {
    @Test
    void convertBudgetToCSV(){
        String exceptedCSV =
                "Name,Amount\n" +
                "Income:,\n" +
                "Single,100.5\n" +
                "Expense:,\n" +
                "Rent,100.5\n" +
                "Balance:,0.0";

        BudgetListItem incomeItem = new BudgetListItem("Single", 100.50, "income");
        BudgetListItem expenseItem = new BudgetListItem("Rent", 100.50, "expense");
        double balance = incomeItem.getAmount() - expenseItem.getAmount();

        List<BudgetListItem> incomeList = new ArrayList<>();
        List<BudgetListItem> expenseList = new ArrayList<>();
        incomeList.add(incomeItem);
        expenseList.add(expenseItem);

        String actualCSV = BudgetCalculationHelper.convertBudgetToCSV(incomeList, expenseList, balance);
        assertEquals(exceptedCSV, actualCSV);

    }
}