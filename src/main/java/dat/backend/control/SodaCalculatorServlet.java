package dat.backend.control;

import dat.backend.model.entities.Soda;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// This servlet is responsible for calculating the savings and consumption of soda based on the input from the user.

@WebServlet(name = "SodaCalculatorServlet", value = "/sodacalculator")
public class SodaCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets the parameters from the form
        double soda = Double.parseDouble(request.getParameter("soda"));
        double price = Double.parseDouble(request.getParameter("price"));
        boolean sugarFree = Boolean.parseBoolean(request.getParameter("sugarFree"));

        // checks if either inputs are negative
        if(soda < 0 || price < 0 ) {
            request.setAttribute("errormessage", "Negative tal er ikke tilladt.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            // creates a new soda object
            Soda s = new Soda(soda, price);
            // sets the attributes for the soda object
            request.setAttribute("sugarFree", sugarFree);
            request.setAttribute("soda", s);
            // forwards the request to the sodaconsumption.jsp
            request.getRequestDispatcher("sodaconsumption.jsp").forward(request, response);

        }
    }



}
