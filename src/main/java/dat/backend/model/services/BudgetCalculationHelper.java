package dat.backend.model.services;

import dat.backend.model.entities.BudgetListItem;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;


public class BudgetCalculationHelper {
    public static String convertBudgetToCSV(List<BudgetListItem> incomes, List<BudgetListItem> expenses, double balance){
        /* Format:
         * Name,Amount
         * Income:,
         * <name>,<amount>
         * Expense:,
         * <name>,<amount>
         * Balance:,<balance> */

        String csvReturnString =
                        "Name,Amount\n" +
                        "Income:,\n";
        for (BudgetListItem item:incomes) {
            csvReturnString += item.getName() + "," + item.getAmount() + "\n";
        }
        csvReturnString += "Expense:,\n";
        for (BudgetListItem item:expenses) {
            csvReturnString += item.getName() + "," + item.getAmount() + "\n";
        }
        csvReturnString += "Balance:," + balance;
        return csvReturnString;
    }
    public static InputStream stringToInputStream(String text){
        return new ByteArrayInputStream(text.getBytes());
    }
}
