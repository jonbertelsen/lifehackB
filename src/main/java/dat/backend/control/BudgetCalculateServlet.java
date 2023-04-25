package dat.backend.control;

import dat.backend.model.entities.BudgetListItem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
    public void init() throws ServletException {
        selectedIncomes = new ArrayList<>();
        selectedExpenses = new ArrayList<>();
        balance = 0;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
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
        if(action.equals("download")){
            // This
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
            response.sendRedirect("budgetcalculate");
            return;
        }
        String amountStr = request.getParameter("amount").replace(',', '.');
        if (amountStr.contains("-")) {
            Exception e = new IllegalArgumentException("Input can not be negative");
           request.setAttribute("errormessage",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        try {
            if ("income".equals(action)) {
                double amount = Double.parseDouble(amountStr);
                String name = request.getParameter("income");
                BudgetListItem budgetListItem = new BudgetListItem(name, amount, action);
                selectedIncomes.add(budgetListItem);
            }
            if ("expense".equals(action)) {
                double amount = Double.parseDouble(amountStr);
                String name = request.getParameter("expense");
                BudgetListItem budgetListItem = new BudgetListItem(name, amount, action);
                selectedExpenses.add(budgetListItem);
            }
        } catch (NumberFormatException | NullPointerException e) {
          request.setAttribute("errormessage",e.getMessage());
          request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        balance = 0;
        for (BudgetListItem budgetListItem : selectedIncomes) {
            double amount = budgetListItem.getAmount();
            balance += amount;
        }
        for (BudgetListItem budgetListItem : selectedExpenses) {
            double amount = budgetListItem.getAmount();
            balance -= amount;
        }
        selectedIncomes.sort(Comparator.comparing(BudgetListItem::getAmount));
        selectedExpenses.sort(Comparator.comparing(BudgetListItem::getAmount));
        response.sendRedirect("budgetcalculate");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("budgetCalcSelectedExpenses", selectedExpenses);
        request.setAttribute("budgetCalcSelectedIncomes", selectedIncomes);
        request.setAttribute("budgetCalcBalance", balance);
        request.setAttribute("downloadBudgetText", BudgetCalculationHelper.convertBudgetToCSV(selectedIncomes, selectedExpenses, balance));

        request.getRequestDispatcher("budget.jsp").forward(request, response);
    }
}