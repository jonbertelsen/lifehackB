package dat.backend.control;

import dat.backend.model.entities.SmokeStopCalculator;
import dat.backend.model.exceptions.SmokeStopCalculatorException;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SmokeStopCalculatorServlet", value = "/smokestop")
public class SmokeStopCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            double pricePerCigarette = Double.parseDouble(request.getParameter("pricePerCigarette"));
            int cigarettesPerDay = Integer.parseInt(request.getParameter("cigarettesPerDay"));
            int cigarettesPerWeek = cigarettesPerDay * 7;


            SmokeStopCalculator smokeStopCalculator = new SmokeStopCalculator(cigarettesPerDay, pricePerCigarette);

            double totalSavedAWeek = smokeStopCalculator.pricePerDay() * 7;
            double totalSavedAMonth = smokeStopCalculator.pricePerMonth();
            double totalSavedAYear = smokeStopCalculator.pricePerYear();


            request.setAttribute("totalSavedAWeek", totalSavedAWeek);
            request.setAttribute("totalSavedAMonth", totalSavedAMonth);
            request.setAttribute("totalSavedAYear", totalSavedAYear);
            request.setAttribute("savings10", smokeStopCalculator.calculateSavingsPercentage(10));
            request.setAttribute("savings20", smokeStopCalculator.calculateSavingsPercentage(20));
            request.setAttribute("savings50", smokeStopCalculator.calculateSavingsPercentage(50));
            request.setAttribute("savings100", smokeStopCalculator.calculateSavingsPercentage(100));
            request.setAttribute("cigarettesAfter10PercentCut", smokeStopCalculator.cigarettesAfterCuttingPercentage(10));
            request.setAttribute("cigarettesAfter20PercentCut", smokeStopCalculator.cigarettesAfterCuttingPercentage(20));
            request.setAttribute("cigarettesAfter50PercentCut", smokeStopCalculator.cigarettesAfterCuttingPercentage(50));
            request.setAttribute("cigarettesAfter100PercentCut", smokeStopCalculator.cigarettesAfterCuttingPercentage(100));



            request.getRequestDispatcher("SmokeStopCalculator.jsp").forward(request, response);

        } catch (NumberFormatException | SmokeStopCalculatorException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("SmokeStopCalculator.jsp").forward(request, response);
        }

    }
}
