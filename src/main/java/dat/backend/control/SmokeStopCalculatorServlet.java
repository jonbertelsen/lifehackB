package dat.backend.control;

import dat.backend.model.entities.SmokeStopCalculator;
import dat.backend.model.exceptions.SmokeStopCalculatorException;

// This is the servlet for the SmokeStopCalculator.
// The servlet takes in the parameters from the user, and then creates a new instance of the SmokeStopCalculator class.
// The servlet then calls the methods from the SmokeStopCalculator class, and sets the results as attributes.
// The servlet then forwards the request to the smokestopcalculator.jsp page, where the results are displayed to the user.
//The method uses the try catch block to catch any exceptions that might occur.
// If an exception occurs, the servlet forwards the request to the smokestopcalculator.jsp page, where the error message is displayed to the user.


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SmokeStopCalculatorServlet", value = "/smokestop")
public class SmokeStopCalculatorServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Get the parameters from the user
            // The reason why we use the Double.parseDouble() method is because the pricePerCigarette is a double, and the request.getParameter() method returns a string.
            // We need to convert the string to a double, so that we can use it in the SmokeStopCalculator class.

            double pricePerCigarette = Double.parseDouble(request.getParameter("pricePerCigarette"));
            int cigarettesPerDay = Integer.parseInt(request.getParameter("cigarettesPerDay"));

            SmokeStopCalculator smokeStopCalculator = new SmokeStopCalculator(cigarettesPerDay, pricePerCigarette);


            // Calculates the total savings per week, month and year

            double totalSavedAWeek = smokeStopCalculator.savingPerDay() * 7;
            double totalSavedAMonth = smokeStopCalculator.savingPerMonth();
            double totalSavedAYear = smokeStopCalculator.savingPerYear();

            // Sets the results as attributes so that they can be displayed to the user on the smokestopcalculator.jsp page
            // The results are displayed to the user using the JSTL tags in the smokestopcalculator.jsp page.

            request.setAttribute("totalSavedAWeek", totalSavedAWeek);
            request.setAttribute("totalSavedAMonth", totalSavedAMonth);
            request.setAttribute("totalSavedAYear", totalSavedAYear);
            request.setAttribute("savings10", smokeStopCalculator.calculateSavingsPercentageAYear(10));
            request.setAttribute("savings20", smokeStopCalculator.calculateSavingsPercentageAYear(20));
            request.setAttribute("savings50", smokeStopCalculator.calculateSavingsPercentageAYear(50));
            request.setAttribute("savings100", smokeStopCalculator.calculateSavingsPercentageAYear(100));
            request.setAttribute("cigarettesAfter10PercentCut", smokeStopCalculator.cigarettesAfterCuttingPercentage(10));
            request.setAttribute("cigarettesAfter20PercentCut", smokeStopCalculator.cigarettesAfterCuttingPercentage(20));
            request.setAttribute("cigarettesAfter50PercentCut", smokeStopCalculator.cigarettesAfterCuttingPercentage(50));

            // Forwards the request to the smokestopcalculator.jsp page, where the results are displayed to the user.
            request.getRequestDispatcher("smokestopcalculator.jsp").forward(request, response);

            // If an exception occurs, the servlet forwards the request to the smokestopcalculator.jsp page, where the error message is displayed to the user.
        } catch (SmokeStopCalculatorException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("smokestopcalculator.jsp").forward(request, response);
        }

    }
}
