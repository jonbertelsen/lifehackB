package dat.backend.control.loancalc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoanCalc", value = "/LoanCalc")
public class LoanCalc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Read user input from fields
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double ARPC = Double.parseDouble(request.getParameter("ARPC"));
        double duration = Double.parseDouble(request.getParameter("duration"));

    }
}
