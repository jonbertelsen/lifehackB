package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Junkfood", value = "/Junkfood")
public class Junkfood extends HttpServlet {

    private ConnectionPool connectionPool;

    private String food;

    private int kcal;

    final static List<FoodAndDrinks> foodObjects = (new FoodAndDrinks("Pizza", 600));

    public FoodAndDrinks(String food, int kcal) {
        this.food = food;
        this.kcal = kcal;
    }
    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("junkfood.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
