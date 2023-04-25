package dat.backend.control;

import dat.backend.model.entities.Item;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String amountStr = request.getParameter("amount").replace(',', '.');

        HttpSession session = request.getSession();
        List<Item> selectedIncome = (List<Item>) session.getAttribute("selectedIncome");
        if (selectedIncome == null) {
            selectedIncome = new ArrayList<Item>();
        }

        List<Item> selectedExpense = (List<Item>) session.getAttribute("selectedExpense");
        if (selectedExpense == null) {
            selectedExpense = new ArrayList<Item>();
        }

        if (amountStr.contains("-")) {
            Exception e = new IllegalArgumentException("Input can not be negative");
           request.setAttribute("errormessage",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        try {
            if ("income".equals(action)) {
                double amount = Double.parseDouble(amountStr);
                String name = request.getParameter("income");
                Item item = new Item(name, amount, action);
                selectedIncome.add(item);
            }
            if ("expense".equals(action)) {
                double amount = Double.parseDouble(amountStr);
                String name = request.getParameter("expense");
                Item item = new Item(name, amount, action);
                selectedExpense.add(item);
            }

        } catch (NumberFormatException e) {
      request.setAttribute("errormessage",e.getMessage());
      request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        catch (NullPointerException e){
         request.setAttribute("errormessage",e.getMessage());
         request.getRequestDispatcher("error.jsp").forward(request,response);
    }

        double balance = 0;
        for (Item item : selectedExpense) {
            double amount = item.getAmount();
            balance -= amount;

        }

        for (Item item : selectedIncome) {
            double amount = item.getAmount();
            balance += amount;


        }
        selectedIncome.sort(Comparator.comparing(Item::getAmount));
        selectedExpense.sort(Comparator.comparing(Item::getAmount));



        // Update session variables
        session.setAttribute("selectedExpense", selectedExpense);
        session.setAttribute("selectedIncome", selectedIncome);
        session.setAttribute("balance", balance);

        response.sendRedirect("calculate");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("budget.jsp").forward(request, response);

    }
}