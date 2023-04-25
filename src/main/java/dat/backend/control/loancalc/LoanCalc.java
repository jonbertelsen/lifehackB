package dat.backend.control.loancalc;

import dat.backend.model.entities.LoanCalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoanCalc", value = "/loancalc")
public class LoanCalc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read user input from fields
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double APRC = Double.parseDouble(request.getParameter("APRC"));
        double duration = Double.parseDouble(request.getParameter("duration"));

        if(loanAmount < 0 || APRC < 0 || duration < 0){
            request.setAttribute("fejlinput", "You cannot input negative values!");
            request.getRequestDispatcher("loancalc.jsp").forward(request, response);
        }

        if (request.getParameterMap().containsKey("monthYearChange")){
            APRC = LoanCalculator.recalculateToMonths(APRC);
        }

        // is getting the total cost of the loan as it is
        double totalCostOfLoan = LoanCalculator.totalCostOfLoan(loanAmount, duration, APRC);
        //gets the monthlypayment
        double monthlyPayment = LoanCalculator.findMonthlyPayment(loanAmount, duration, APRC);
        // gets total loan if we lowers the APRC with 50%
        double totalCostWithlowerAPRC = LoanCalculator.totalCostWithLowerAPRC(loanAmount, duration, APRC);
        // gets total loan if we lower the loanlenght by 33%
        double totalCostShorterDuration = LoanCalculator.totalCostWithLowerLength(loanAmount, duration, APRC);

        double interest = totalCostOfLoan - loanAmount;
        request.setAttribute("interest", interest);
        request.setAttribute("loanlength", duration);
        request.setAttribute("totalcostofloan", totalCostOfLoan);
        request.setAttribute("monthlypayment", monthlyPayment);
        request.setAttribute("totalcostwithlowerAPRC", totalCostWithlowerAPRC);
        request.setAttribute("totalcostshorterduration", totalCostShorterDuration);

        request.getRequestDispatcher("loancalc.jsp").forward(request, response);
    }
}
