package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.FoodAndDrinks;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Junkfood", value = "/Junkfood")
public class Junkfood extends HttpServlet {

    private ConnectionPool connectionPool;

    ArrayList<FoodAndDrinks> selectedChoices = new ArrayList<>();

    final static FoodAndDrinks[] foodObjects = {
            new FoodAndDrinks("Pizza", 600), //0
            new FoodAndDrinks("Burger", 700), //1
            new FoodAndDrinks("Soda", 300),
            new FoodAndDrinks("Sandwich", 500),
            new FoodAndDrinks("Muffin", 400),
            new FoodAndDrinks("Bananasplit", 600 kcal)
    };


    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //When the site is sent to client/browser then it will populate 'foodsanddrinks' object with the constant array foodObjects
        request.setAttribute("foodsanddrinks", foodObjects);
        request.setAttribute("selectedChoices",selectedChoices);
        int sum = 0;
        for (FoodAndDrinks item:selectedChoices) {
            sum += item.getKcal();
        }
        request.setAttribute("totalKcal", sum);
        request.getRequestDispatcher("junkfood.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("foodsanddrinks", foodObjects);

        int selectedObjectIndex = Integer.parseInt(request.getParameter("junk"));
        FoodAndDrinks selectedObject = foodObjects[selectedObjectIndex];
        selectedChoices.add(selectedObject);


        response.sendRedirect("Junkfood");
    }
}
