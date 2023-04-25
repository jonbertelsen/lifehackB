package dat.backend.control;

import dat.backend.model.entities.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String amountStr = request.getParameter("amount");

        // Initialize session variables
        HttpSession session = request.getSession();
        List<Item> selectedItems = (List<Item>) session.getAttribute("selectedItems");
        double totalIncome = (double) session.getAttribute("totalIncome");
        double totalExpense = (double) session.getAttribute("totalExpense");

        if (selectedItems == null) {
            selectedItems = new ArrayList<Item>();
        }

        if ("add".equals(action)) {
            double amount = Double.parseDouble(amountStr);
            Item item = new Item(type, name, amount);
            selectedItems.add(item);

            if ("income".equals(type)) {
                totalIncome += amount;
            } else {
                totalExpense += amount;
            }
        } else if ("remove".equals(action)) {
            int index = Integer.parseInt(request.getParameter("index"));
            Item item = selectedItems.remove(index);

            if ("income".equals(item.getType())) {
                totalIncome -= item.getAmount();
            } else {
                totalExpense -= item.getAmount();
            }
        }

        // Calculate remaining balance
        double balance = totalIncome - totalExpense;

        // Update session variables
        session.setAttribute("selectedItems", selectedItems);
        session.setAttribute("totalIncome", totalIncome);
        session.setAttribute("totalExpense", totalExpense);
        session.setAttribute("balance", balance);

        // Redirect to JSP view
        request.getRequestDispatcher("budget.jsp").forward(request, response);
    }

}
/*
 Scanner input = new Scanner(System.in);

      // Indtastning af indtægter
      System.out.print("Indtast din månedlige indtægt: ");
      double indtægt = input.nextDouble();

      // Indtastning af udgifter
      System.out.print("Indtast din månedlige husleje: ");
      double husleje = input.nextDouble();

      System.out.print("Indtast din månedlige madudgift: ");
      double madudgift = input.nextDouble();

      System.out.print("Indtast din månedlige transportudgift: ");
      double transportudgift = input.nextDouble();

      // Beregning af budgettet
      double udgifter = husleje + madudgift + transportudgift;
      double budget = indtægt - udgifter;

      // Udskrivning af resultatet
      System.out.println("Dit månedlige budget er: " + budget);
   }
}
 */