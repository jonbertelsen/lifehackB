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

@WebServlet(name = "Junkfood", value = "/junkfood")
public class Junkfood extends HttpServlet {

    private ConnectionPool connectionPool;

    /**
     * A arraylist to save our selectedChoices to show more than one output after pressing "add".
     */

    ArrayList<FoodAndDrinks> selectedChoices = new ArrayList<>();

    /**
     * Our foodObjects. We use these objects' index-number in our code later on.
     */

    final static FoodAndDrinks[] foodObjects = {
            new FoodAndDrinks("Pizza", 600), //0
            new FoodAndDrinks("Burger", 700), //1
            new FoodAndDrinks("Soda", 300),
            new FoodAndDrinks("Sandwich", 500),
            new FoodAndDrinks("Muffin", 400),
            new FoodAndDrinks("Bananasplit", 600)
    };


    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();

    }

    /**
     * When the site is sent to client/browser then it will populate 'foodsanddrinks' object with the constant array foodObjects
     * To get the total Kcal, we use a new variable called "sum", we set this variable to be 0, and then using a for-each loop that loops
     * through the selectedChoices, and automatic updates the total kcal.
     * We set the attribute totalKcal to be equals sum, to "automatic" update the totalKcal.
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("foodsanddrinks", foodObjects);
        request.setAttribute("selectedChoices", selectedChoices);

        int sum = 0;
        for (FoodAndDrinks item : selectedChoices) {
            sum += item.getKcal();
        }

        request.setAttribute("totalKcal", sum);
        request.getRequestDispatcher("junkfood.jsp").forward(request, response);

    }

    /**
     * To avoid the foodObjects and selectedChoices to be duplicated everytime we reload the site, we use this
     * band-aid fix, and reloads the site.
     * The reason for why this is a bad idea is because -
     * As told earlier, we use the Index of the Objects, and by doing that we make a new variable called selectedObjectIndex
     * that we make into a Integer, with the parameter called "junk", we use that "junk" in our fastfood.jsp site.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("foodsanddrinks", foodObjects);

        int selectedObjectIndex = Integer.parseInt(request.getParameter("junk"));
        FoodAndDrinks selectedObject = foodObjects[selectedObjectIndex];
        selectedChoices.add(selectedObject);


        response.sendRedirect("junkfood");
    }
}
