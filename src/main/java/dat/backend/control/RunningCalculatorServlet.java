package dat.backend.control;

import dat.backend.model.entities.RunningCalculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*
This servlet functions as the control element between runningcalculator.jsp and RunningCalculator.java.
Since no data needs to be loaded in to run the page the doGet-method remains unused.
The servlet recognises how many inputs the user entered, and if used optimally recognises which variable needs to be calculated.
If all goes well - In the end all 3 values (2 entered and 1 calculated) will be returned to the jsp page per request object.
2 booleans are also  returned to the jsp page per request object - used to change the page if incorrect input was given.
 */

@WebServlet(name = "RunningCalculator", value = "/runningcalculator")
public class RunningCalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double distance = -1;
        int time = -1;
        double speed = -1;
        boolean distanceChosen = false;
        boolean timeChosen = false;
        boolean speedChosen = false;
        boolean allOptionsChosen = false;
        boolean notEnoughOptionsChosen = false;
        int numberOfOptionsChosen = 0;

        //Tries to retrieve values from the form - if all is well, it recognises that the value has been parsed and adds to the total number of options chosen.
        try {
            distance = Double.parseDouble(request.getParameter("km"));
            distanceChosen = true;
            numberOfOptionsChosen++;
        } catch(NullPointerException e){}
        try {
            time = Integer.parseInt(request.getParameter("time"));
            timeChosen = true;
            numberOfOptionsChosen++;
        } catch(NullPointerException e){}
        try {
            speed = Double.parseDouble(request.getParameter("average"));
            speedChosen = true;
            numberOfOptionsChosen++;
        } catch(NullPointerException e){}

        //If 3 options has been chosen - no calculations will be done - it is forwarded to the jsp page that the input needs to be specified.
        if(numberOfOptionsChosen == 3){
            allOptionsChosen = true;
        //If less than 2 options has been chosen - no calculations will be done - it is forwarded to the jsp page that the form requires more information.
        } else if(numberOfOptionsChosen < 2){
            notEnoughOptionsChosen = true;
        //Depending on which 2 values were passed to the servlet it will run the calculation for the third and missing value.
        } else {
            if(distanceChosen && speedChosen){
                request.setAttribute("distance", distance);
                request.setAttribute("time", RunningCalculator.calculateTime(distance, speed));
                request.setAttribute("speed", speed);
            } else if(distanceChosen && timeChosen){
                request.setAttribute("distance", distance);
                request.setAttribute("time", time);
                request.setAttribute("speed", RunningCalculator.calculateSpeed(distance, time));
            } else if(timeChosen && speedChosen){
                request.setAttribute("distance", RunningCalculator.calculateDistance(time, speed));
                request.setAttribute("time", time);
                request.setAttribute("speed", speed);
            }
        }
        request.setAttribute("allOptionsChosen", allOptionsChosen);
        request.setAttribute("notEnoughOptionsChosen", notEnoughOptionsChosen);

        request.getRequestDispatcher("runningcalculator.jsp").forward(request, response);
    }
}
