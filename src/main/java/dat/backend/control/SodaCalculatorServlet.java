package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SodaCalculatorServlet", value = "/sodacalculator")
public class SodaCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        double soda = Double.parseDouble(request.getParameter("soda"));
        double price = Double.parseDouble(request.getParameter("price"));

        if(soda < 0 || price < 0 ) {
            request.setAttribute("errormessage", "Negative tal er ikke tilladt.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }else{
            double sodaMonth = soda * 30;
            double sodaYear = soda * 365;

            double sodaCostMonth = price * 30;
            double sodaCostYear = price * 365;

            ArrayList<Double> savingsPerMonth = percentCalculator(sodaCostMonth);
            ArrayList<Double> savingsPerYear = percentCalculator(sodaCostYear);
            ArrayList<Double> savingsPerDay = percentCalculator(price);

        }
    }

    public ArrayList<Double> percentCalculator(double sodaPrice){
        ArrayList<Double> procentages = new ArrayList<Double>();
        double procent = 0.1;
        double sodaTen = procent * sodaPrice;

        procent = 0.2;
        double sodaTwenty = procent * sodaPrice;

        procent = 0.5;
        double sodaFifty = procent * sodaPrice;

        double sodaHundred = sodaPrice;

        procentages.add(sodaTen);
        procentages.add(sodaTwenty);
        procentages.add(sodaFifty);
        procentages.add(sodaHundred);

        return procentages;
    }




}
