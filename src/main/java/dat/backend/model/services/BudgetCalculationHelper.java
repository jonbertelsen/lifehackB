package dat.backend.model.services;

import dat.backend.model.entities.BudgetListItem;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

// This class contains some methods to help with stuff related to the BudgetCalculator
public class BudgetCalculationHelper {

    // This method takes in two budget lists and a balance and makes it into the csv format
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
    // This turns any string into an InputStream. It does this by getting the bytes of the string and uses a child class of InputStream, that turns a byte array into a InputStream.
    public static InputStream stringToInputStream(String text){
        return new ByteArrayInputStream(text.getBytes());
    }

    // This converts any string to a double... unless there is two dots in the string.
    public static double parseDouble(String doubleString) throws ParseException {

        if(doubleString.indexOf('.') != doubleString.lastIndexOf('.')) {
            throw new ParseException("The String contains more than 1 dots.", doubleString.indexOf('.', doubleString.indexOf('.') + 1));
        }
        try {
            if(doubleString.indexOf('.') > -1 && doubleString.indexOf(',') < doubleString.indexOf('.')){
                return Double.parseDouble(doubleString.replaceFirst(",",""));
            }
            if(doubleString.contains(".") && !doubleString.contains(",")){
                return Double.parseDouble(doubleString);
            }
        }catch (NumberFormatException e){
            throw new ParseException(e.getMessage(), doubleString.lastIndexOf('.'));
        }
        return DecimalFormat.getNumberInstance().parse(doubleString).doubleValue();
    }
}
