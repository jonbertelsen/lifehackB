package dat.backend.control;

import dat.backend.model.entities.BudgetListItem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dat.backend.model.services.BudgetCalculationHelper;


@WebServlet(name = "BudgetCalculateServlet", value = "/budgetcalculate")
public class BudgetCalculateServlet extends HttpServlet {

    private List<BudgetListItem> selectedIncomes;
    private List<BudgetListItem> selectedExpenses;
    private double balance;

    @Override
    public void init() {
        selectedIncomes = new ArrayList<>();
        selectedExpenses = new ArrayList<>();
        balance = 0;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        // Checks if the 'Clear' button was pressed.
        if(action.equals("clear")){
            selectedIncomes = new ArrayList<>();
            selectedExpenses = new ArrayList<>();
            balance = 0;
            request.setAttribute("budgetCalcSelectedExpenses", selectedExpenses);
            request.setAttribute("budgetCalcSelectedIncomes", selectedIncomes);
            request.setAttribute("budgetCalcBalance", balance);
            request.getRequestDispatcher("budget.jsp").forward(request, response);
            return;
        }
        // Checks if the 'Download CSV' button was pressed.
        if(action.equals("download")){
            sendDownloadCSVFileFromText(response);
            response.sendRedirect("budgetcalculate");
            return;
        }
        String amountStr = request.getParameter("amount");
        if (amountStr.contains("-")) {
            // This checks if a dash exists in the string before it is convert, and throws an exception if it is found.
            Exception e = new IllegalArgumentException("Input can not be negative");
           request.setAttribute("errormessage",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }

        double amount = 0;
        try {
            amount = BudgetCalculationHelper.parseDouble(amountStr);
        } catch (ParseException e) {
          request.setAttribute("errormessage","Input wasn't a number, or couldn't be converted to a double. Input was \"" + amountStr + "\". Exception message: " + e.getMessage());
          request.getRequestDispatcher("error.jsp").forward(request,response);
        } catch (NullPointerException e) {
          request.setAttribute("errormessage","Input was null. Exception message: " + e.getMessage());
          request.getRequestDispatcher("error.jsp").forward(request,response);
        }

        if ("income".equals(action)) {
            String name = request.getParameter("income");
            BudgetListItem budgetListItem = new BudgetListItem(name, amount, action);
            selectedIncomes.add(budgetListItem);
        }
        if ("expense".equals(action)) {
            String name = request.getParameter("expense");
            BudgetListItem budgetListItem = new BudgetListItem(name, amount, action);
            selectedExpenses.add(budgetListItem);
        }

        // balance is set to 0 to make sure it is correct after each item is added. After the balance is calculated.
        balance = 0;
        for (BudgetListItem budgetListItem : selectedIncomes) {
            double sumAmount = budgetListItem.getAmount();
            balance += sumAmount;
        }
        for (BudgetListItem budgetListItem : selectedExpenses) {
            double sumAmount = budgetListItem.getAmount();
            balance -= sumAmount;
        }
        // Both Lists are sort using the getAmount() or in other words by each item's 'amount'
        selectedIncomes.sort(Comparator.comparing(BudgetListItem::getAmount));
        selectedExpenses.sort(Comparator.comparing(BudgetListItem::getAmount));
        response.sendRedirect("budgetcalculate");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Sets all the attributes for the budget and table.
        request.setAttribute("budgetCalcSelectedExpenses", selectedExpenses);
        request.setAttribute("budgetCalcSelectedIncomes", selectedIncomes);
        request.setAttribute("budgetCalcBalance", balance);
        request.getRequestDispatcher("budget.jsp").forward(request, response);
    }

    //This method gets the stream to client to and then send the bytes of the csv file/text to the client, in other words it downloads the csv file.
    private void sendDownloadCSVFileFromText(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=budget.csv");
        String csvText = BudgetCalculationHelper.convertBudgetToCSV(selectedIncomes, selectedExpenses, balance);
        try(InputStream in = BudgetCalculationHelper.stringToInputStream(csvText);
            OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1048];
            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }


}