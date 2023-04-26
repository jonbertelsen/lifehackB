package dat.backend.control;

import dat.backend.model.entities.LottoGenerator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


/**
 * Generates an array of random integers. Forwards to randomLottoNumbers.jsp.
 */
@WebServlet(name = "GeneratedNumb", value = "/generatednumb")
public class GeneratedNumb extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    /**
     * Generates array of random numbers based on timesToGenerate parameter
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int timesToGenerate = Integer.parseInt(request.getParameter("timesToGenerate"));
        int[] randomNumbers = new int[timesToGenerate];

        for (int i = 0; i < timesToGenerate; i++) {
            randomNumbers[i] = lottoGenerator.generateRandomNumber();
        }

        request.setAttribute("lottoNumbers", randomNumbers);
        request.getRequestDispatcher("WEB-INF/randomLottoNumbers.jsp").forward(request, response);

    }

}
